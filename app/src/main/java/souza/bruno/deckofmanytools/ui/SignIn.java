package souza.bruno.deckofmanytools.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gigamole.library.PulseView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import souza.bruno.deckofmanytools.R;
import souza.bruno.deckofmanytools.model.BaseActivity;

import static souza.bruno.deckofmanytools.R.id.sign_in_pulse_view;

public class SignIn extends BaseActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private PulseView pulseView;
    private SignInButton btSignIn;
    private TextView tvStatus;
    private TextView tvDetails;

    private FirebaseAuth mAuth;

    GoogleSignInClient mGooglesignInClient;

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        pulseView = findViewById(R.id.sign_in_pulse_view);
        pulseView.startPulse();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGooglesignInClient = GoogleSignIn.getClient(this,gso);

        mAuth = FirebaseAuth.getInstance();

        tvStatus = findViewById(R.id.si_tv_status);
        tvDetails = findViewById(R.id.si_tv_details);
        btSignIn = findViewById(R.id.sign_in_button);
        btSignIn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pulseView.finishPulse();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account);
            }catch(ApiException e) {
                Log.w(TAG, "Google sign in falhou.", e);
                updateUI(null);
            }
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult){
        Log.d(TAG, "onConnectionFailed:"+connectionResult);
    }

    private void firebaseAuth(GoogleSignInAccount acct){
        Log.d(TAG, "firebaseAuth:"+acct.getId());
        showProgressDialog();

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "signInCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }else{
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(getBaseContext(), "Autenticação falhou.", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        hideProgressDialog();
                    }
                });
    }

    private void handleSignInResult(GoogleSignInResult result){
        Log.d(TAG, "handleSignInResult: "+result.isSuccess());
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            tvStatus.setText(acct.getDisplayName());
        }
    }

    private void signIn(){
        Intent signInIntent = mGooglesignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    private void updateUI(FirebaseUser user){
        if (user != null){
            tvStatus.setText(getString(R.string.google_status_fmt, user.getEmail()));
            tvDetails.setText(getString(R.string.firebase_status_fmt, user.getUid()));
        }else{
            tvStatus.setText("Signed Out");
        }
    }
}

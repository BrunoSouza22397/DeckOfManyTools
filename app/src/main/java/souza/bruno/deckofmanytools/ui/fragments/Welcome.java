package souza.bruno.deckofmanytools.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import souza.bruno.deckofmanytools.R;
import souza.bruno.deckofmanytools.ui.MainActivity;
import souza.bruno.deckofmanytools.ui.SignIn;

/**
 * A simple {@link Fragment} subclass.
 */
public class Welcome extends Fragment {

    private TextView tvUser;

    public Welcome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        tvUser = view.findViewById(R.id.wc_tv_user);
        Button btSignOut = view.findViewById(R.id.wc_bt_signout);
        btSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(),SignIn.class));
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        tvUser.setText(user.getDisplayName());
    }
}

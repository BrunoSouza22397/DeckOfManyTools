package souza.bruno.deckofmanytools.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.gigamole.library.PulseView;

import souza.bruno.deckofmanytools.R;

import static souza.bruno.deckofmanytools.R.id.sign_in_pulse_view;

public class SignIn extends AppCompatActivity {

    private PulseView pulseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        pulseView = findViewById(R.id.sign_in_pulse_view);
        pulseView.startPulse();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pulseView.finishPulse();
    }
}

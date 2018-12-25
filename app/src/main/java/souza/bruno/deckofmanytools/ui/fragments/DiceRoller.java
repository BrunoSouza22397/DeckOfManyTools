package souza.bruno.deckofmanytools.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import souza.bruno.deckofmanytools.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiceRoller extends Fragment {


    public DiceRoller() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dice_roller, container, false);
    }

}

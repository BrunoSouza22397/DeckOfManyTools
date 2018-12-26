package souza.bruno.deckofmanytools.ui.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import souza.bruno.deckofmanytools.R;
import souza.bruno.deckofmanytools.adapters.DieAdapter;
import souza.bruno.deckofmanytools.model.Die;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommonDiceRoller extends Fragment {

    Button btAdd;
    RecyclerView rvDice;
    ArrayList<Resources> dice;
    DieAdapter adapter;

    public CommonDiceRoller() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_common_dice_roller, container, false);
        init(view);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
    private void init(View view){
        btAdd = view.findViewById(R.id.cdr_bt_add);
        rvDice = view.findViewById(R.id.cdr_rv_dice);

        dice = new ArrayList<>();
        adapter = new DieAdapter(getContext(),dice);
        rvDice.setAdapter(adapter);

        rvDice.setHasFixedSize(true);
        rvDice.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

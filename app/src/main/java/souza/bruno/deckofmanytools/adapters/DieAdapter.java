package souza.bruno.deckofmanytools.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;

import souza.bruno.deckofmanytools.R;
import souza.bruno.deckofmanytools.model.Die;

public class DieAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Resources> dice;

    public DieAdapter(Context context, ArrayList<Resources> dice) {
        this.context = context;
        this.dice = dice;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.line_dice, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder h = (ViewHolder) viewHolder;
        Resources d = dice.get(i);
//        Picasso.get().load(d.changeDieIcon()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(h.ivDie);
    }

    @Override
    public int getItemCount() {
        return dice.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private EditText etQt;
        private EditText etMod;
        private Spinner spType;
        private Button btDelete;
        private ImageView ivDie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etQt.findViewById(R.id.ld_et_number);
            etMod.findViewById(R.id.ld_et_mod);
            spType.findViewById(R.id.ld_sp_type);
            btDelete.findViewById(R.id.ld_bt_delete);
            ivDie.findViewById(R.id.ld_iv_die);
        }
    }
}

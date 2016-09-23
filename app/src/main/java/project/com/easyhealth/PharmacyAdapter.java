package project.com.easyhealth;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nikhil on 11/10/15.
 */
public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ViewHolder> implements View.OnClickListener {

    ArrayList<Medicine> meds;
    static Context context;
    SharedPreferences preferences;
    String email="";
    Typeface font;

    public PharmacyAdapter(ArrayList<Medicine> meds, Context context) {
        this.meds = meds;
        this.context = context;
    }




    @Override
    public void onBindViewHolder(final ViewHolder viewHolder,final int i) {
        final Medicine c = meds.get(i);
        viewHolder.serial.setText(""+i+1);
        viewHolder.name.setText(c.getName());
        viewHolder.dose.setText(c.getDose());
        viewHolder.time.setText(c.getTime());
        viewHolder.del.setVisibility(View.GONE);

    }



    @Override
    public int getItemCount() {
        return meds.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pharmacymedicine_card, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onClick(View v) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        TextView serial,name,dose,time;
        Button del;
        CardView card;
        public ViewHolder(View itemView) {
            super(itemView);
            card=(CardView)itemView.findViewById(R.id.Card);
            serial=(TextView)itemView.findViewById(R.id.serial);
            name=(TextView)itemView.findViewById(R.id.name);
            dose=(TextView)itemView.findViewById(R.id.dose);
            time=(TextView)itemView.findViewById(R.id.time);
            del=(Button)itemView.findViewById(R.id.delete);
        }
    }
}

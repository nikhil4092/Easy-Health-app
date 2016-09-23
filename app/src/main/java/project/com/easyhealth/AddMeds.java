package project.com.easyhealth;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddMeds extends AppCompatActivity implements View.OnClickListener{

    TextView name,gender,age,reason;
    FloatingActionButton add;
    Button cont;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    String patientid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meds);
        Intent i = getIntent();
        patientid=i.getStringExtra("Patientid");
        Global.patientid=patientid;
        Patient p = Global.list.get(0);
        name=(TextView)findViewById(R.id.name);
        age=(TextView)findViewById(R.id.age);
        gender=(TextView)findViewById(R.id.gender);
        reason=(TextView)findViewById(R.id.reason);
        add=(FloatingActionButton)findViewById(R.id.float_add);
        cont=(Button)findViewById(R.id.cont);
        name.setText(p.getName());
        age.setText(p.getAge());
        gender.setText(p.getSex());
        reason.setText(p.getReason());
        add.setOnClickListener(this);
        cont.setOnClickListener(this);
        mRecyclerView = (RecyclerView)findViewById(R.id.meds_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Global.mAdapter = new MedsAdapter(Global.meds,this);
        mRecyclerView.setAdapter(Global.mAdapter);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.float_add){
            Intent i = new Intent(AddMeds.this,AddEachMed.class);
            i.putExtra("Patientid",patientid);
            startActivity(i);
        }
        else if(id==R.id.cont){
            if(Global.meds.size()!=0)
            {
                Intent i = new Intent(AddMeds.this,Success.class);
            startActivity(i);
            }
            else{
                Toast.makeText(AddMeds.this, "No info to add", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onResume() {
        Global.mAdapter.notifyDataSetChanged();
        super.onResume();
    }
}

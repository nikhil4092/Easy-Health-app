package project.com.easyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Success extends AppCompatActivity implements View.OnClickListener{

    TextView id;
    Button oldp,newp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        id=(TextView)findViewById(R.id.prescription_id);
        oldp=(Button)findViewById(R.id.same_patient);
        newp=(Button)findViewById(R.id.new_patient);
        oldp.setOnClickListener(this);
        newp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.same_patient){
            finish();
        }
        else if(id==R.id.new_patient){
            Intent intent=new Intent(Success.this, Doctor.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Global.meds.clear();
        }
    }
}

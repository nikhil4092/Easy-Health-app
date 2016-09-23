package project.com.easyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientDetails extends AppCompatActivity implements View.OnClickListener{

    EditText patientid;
    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        patientid=(EditText)findViewById(R.id.patientid);
        cont=(Button)findViewById(R.id.check);
        cont.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(patientid.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(PatientDetails.this, "Please enter field.", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(this,PatientMedicines.class);
            i.putExtra("Patientid",patientid.getText().toString());
            startActivity(i);
        }
    }
}

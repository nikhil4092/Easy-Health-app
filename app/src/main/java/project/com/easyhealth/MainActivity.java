package project.com.easyhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout doctor,pharmacy,patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doctor=(LinearLayout)findViewById(R.id.doctor);
        patient=(LinearLayout)findViewById(R.id.patient);
        pharmacy=(LinearLayout)findViewById(R.id.pharmacy);
        doctor.setOnClickListener(this);
        patient.setOnClickListener(this);
        pharmacy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.doctor){
            Intent i = new Intent(MainActivity.this,Doctor.class);
            startActivity(i);
        }

        else if(v.getId()==R.id.patient){
            Intent i = new Intent(MainActivity.this,PatientDetails.class);
            startActivity(i);

        }
        else if(v.getId()==R.id.pharmacy){
            Intent i = new Intent(MainActivity.this,Pharmacy.class);
            startActivity(i);

        }
    }
}

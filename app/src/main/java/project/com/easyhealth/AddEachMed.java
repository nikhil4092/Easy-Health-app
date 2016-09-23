package project.com.easyhealth;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class AddEachMed extends AppCompatActivity implements View.OnClickListener{

    EditText name;
    CheckBox morning,afternoon,night;
    TextView starttime,endtime,selectsd,selected;
    ImageView med1,med2,med3;
    Button add,conti;
    SharedPreferences preferences;
    String patientid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_each_med);
        Intent i = getIntent();
        patientid=i.getStringExtra("Patientid");
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        name=(EditText)findViewById(R.id.medicine_name);
        morning=(CheckBox)findViewById(R.id.morning);
        afternoon=(CheckBox)findViewById(R.id.afternoon);
        night=(CheckBox)findViewById(R.id.night);
        starttime=(TextView)findViewById(R.id.startdate_selected);
        endtime=(TextView)findViewById(R.id.enddate_selected);
        selectsd=(TextView)findViewById(R.id.startdate);
        selected=(TextView)findViewById(R.id.enddate);
        add=(Button)findViewById(R.id.addmeds);
        conti=(Button)findViewById(R.id.addmeds_finish);
        med1=(ImageView)findViewById(R.id.med1);
        med2=(ImageView)findViewById(R.id.med2);
        med3=(ImageView)findViewById(R.id.med3);
        Picasso.with(this)
                .load("http://waverr.in/easyhealth/med1.jpg")
                .into(med1);
        Picasso.with(this)
                .load("http://waverr.in/easyhealth/med2.jpg")
                .into(med2);
        Picasso.with(this)
                .load("http://waverr.in/easyhealth/med3.jpg")
                .into(med3);
        med1.setOnClickListener(this);
        med2.setOnClickListener(this);
        med3.setOnClickListener(this);
        selectsd.setOnClickListener(this);
        selected.setOnClickListener(this);
        add.setOnClickListener(this);
        conti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.startdate){
            Calendar mcurrentDate = Calendar.getInstance();
            int mYear = mcurrentDate.get(Calendar.YEAR);
            int mMonth = mcurrentDate.get(Calendar.MONTH);
            int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker;
            mDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                    // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                    selectedmonth = selectedmonth + 1;
                    starttime.setText("" + selectedyear + "-" + selectedmonth + "-" + selectedday);

                }
            }, mYear, mMonth, mDay);
            mDatePicker.setTitle("Select Date");
            mDatePicker.show();
        }
        else if(id==R.id.enddate){
            Calendar mcurrentDate = Calendar.getInstance();
            int mYear = mcurrentDate.get(Calendar.YEAR);
            int mMonth = mcurrentDate.get(Calendar.MONTH);
            int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog mDatePicker;
            mDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                    // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                    selectedmonth = selectedmonth + 1;
                    endtime.setText("" + selectedyear + "-" + selectedmonth + "-" + selectedday);

                }
            }, mYear, mMonth, mDay);
            mDatePicker.setTitle("Select Date");
            mDatePicker.show();
        }
        else if(id==R.id.addmeds){
            Medicine c = new Medicine();
            String first="0",second="0",third="0";
            c.setPatientid(patientid);
            c.setName(name.getText().toString());
            if(morning.isChecked())
            first="1";
            if(afternoon.isChecked())
                second="1";
            if(night.isChecked())
                third="1";
            c.setDose(first + "-" + second + "-" + third);
            c.setTime(starttime.getText().toString() + "-" + endtime.getText().toString());
            Global.meds.add(c);
            Toast.makeText(AddEachMed.this, "Added Successfully", Toast.LENGTH_SHORT).show();
            finish();



        }
        else if(id==R.id.addmeds_finish){
            Intent i = new Intent(AddEachMed.this,Success.class);
            startActivity(i);
        }
        else if(id==R.id.med1){
            name.setText("Crosin");
        }
        else if(id==R.id.med2){
            name.setText("Calpol");
        }
        else if(id==R.id.med3){
            name.setText("Digene");
        }
    }
}

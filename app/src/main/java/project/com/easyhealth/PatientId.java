package project.com.easyhealth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class PatientId extends AppCompatActivity implements View.OnClickListener{

    Button logout;
    SharedPreferences preferences;
    EditText patientid;
    Button check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_id);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        logout=(Button)findViewById(R.id.logout);
        patientid=(EditText)findViewById(R.id.patientid);
        check=(Button)findViewById(R.id.check);
        check.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.logout){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("Username","");
            editor.apply();
            Global.user="";
            Intent intent=new Intent(PatientId.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else if(v.getId()==R.id.check){
            String id = patientid.getText().toString();
            if(id.equalsIgnoreCase("")){
                Toast.makeText(PatientId.this, "Please enter a patient ID", Toast.LENGTH_SHORT).show();
            }
            else{
                check.setText("Checking....");
                checkId(id);
            }
        }
    }

    public void checkId(final String id){
        String[] url = new String[]{
                "http://waverr.in/easyhealth/checkpatientid.php",
                "id",id
        };

        JSONObtainer obtainer;
        obtainer = new JSONObtainer() {
            @Override
            protected void onPostExecute(JSONArray array) {



                try {

                    if(array==null){
                        Toast.makeText(PatientId.this, "Sorry this is an invalid Patient ID.", Toast.LENGTH_SHORT).show();
                        check.setText("Check and Continue");
                    }
                    else if (array.length() == 0) {
                        {
                            Toast.makeText(PatientId.this, "Sorry this is an invalid Patient ID.", Toast.LENGTH_SHORT).show();
                            check.setText("Check and Continue");
                        }
                    }
                    else {
                        Toast.makeText(PatientId.this, "Valid code. Please wait...", Toast.LENGTH_SHORT).show();
                        JSONObject object = array.getJSONObject(0);
                        Patient p = new Patient();
                        p.setName(object.getString("Name"));
                        p.setAge(object.getString("Age"));
                        p.setReason(object.getString("Reason"));
                        p.setSex(object.getString("Sex"));
                        p.setId(object.getString("PatientId"));
                        Global.list.add(p);
                        check.setText("Check and Continue");
                        Intent i = new Intent(PatientId.this,AddMeds.class);
                        i.putExtra("Patientid",id);
                        startActivity(i);
                    }



                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    cancel(true);
                    e.printStackTrace();

                }
            }
        };

        obtainer.execute(url);
    }
}

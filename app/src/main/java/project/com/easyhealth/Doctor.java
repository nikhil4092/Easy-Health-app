package project.com.easyhealth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Doctor extends AppCompatActivity implements View.OnClickListener{

    EditText username,password;
    Button cont;
    CheckBox remember;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        cont=(Button)findViewById(R.id.cont);
        remember=(CheckBox)findViewById(R.id.rememberme);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        cont.setOnClickListener(this);
        String u = preferences.getString("Username","");
        if(!u.equalsIgnoreCase("")){
            Global.user=u;
            Intent i = new Intent(Doctor.this, PatientId.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cont){
            String user=username.getText().toString();
            String pass=password.getText().toString();
            if(user.equalsIgnoreCase("")||pass.equalsIgnoreCase("")){
                Toast.makeText(Doctor.this, "Please Enter Credentials.", Toast.LENGTH_SHORT).show();
            }
            else if(user.equalsIgnoreCase("doctor") && pass.equalsIgnoreCase("test")){
                if(remember.isChecked()) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Username",user);
                    editor.apply();
                    Global.user=user;
                    Intent i = new Intent(Doctor.this, PatientId.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Global.user=user;
                    Intent i = new Intent(Doctor.this, PatientId.class);
                    startActivity(i);
                    finish();
                }
            }
            else{
                Toast.makeText(Doctor.this, "Username or password incorrect.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

package project.com.easyhealth;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by nikhilkumar on 31/03/16.
 */
public class Global {

    public static String user,patientid;
    public static ArrayList<Patient> list = new ArrayList<>();
    public static ArrayList<Medicine> meds = new ArrayList<>();
    public static RecyclerView.Adapter mAdapter;
}

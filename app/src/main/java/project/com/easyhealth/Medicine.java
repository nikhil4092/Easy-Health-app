package project.com.easyhealth;

/**
 * Created by nikhilkumar on 10/04/16.
 */
public class Medicine {
    String patientid,name,dose,use,time;
    public void setPatientid(String patientid){this.patientid=patientid;}
    public void setName(String name){this.name=name;}
    public void setDose(String dose){this.dose=dose;}
    public void setUse(String use){this.use=use;}
    public void setTime(String time){this.time=time;}

    public String getPatientid(){return patientid;}
    public String getName(){return name;}
    public String getDose(){return dose;}
    public String getUse(){return use;}
    public String getTime(){return time;}
}

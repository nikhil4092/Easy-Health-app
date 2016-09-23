package project.com.easyhealth;

/**
 * Created by nikhilkumar on 02/04/16.
 */
public class Patient {
    String id,name,age,sex,reason;

    public void setId(String id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setAge(String age){this.age=age;}
    public void setSex(String sex){this.sex=sex;}
    public void setReason(String reason){this.reason=reason;}

    public String getId(){return id;}
    public String getName(){return name;}
    public String getAge(){return age;}
    public String getSex(){return sex;}
    public String getReason(){return reason;}
}

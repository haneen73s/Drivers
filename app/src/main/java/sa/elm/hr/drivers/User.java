package sa.elm.hr.drivers;

public class User {

    String phone;
    String fname;
    String lname;
    String  id;
    char type;
    String email;
    int i=3458;

    public User(String phone,String fname,String lname,char type,String email){
        this.phone=phone;
        this.fname=fname;
        this.lname=lname;
        this.type=type;
        this.email=email;
        if(!UsersData.isRegistered(phone))
        setId(i++);
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        int length = String.valueOf(id).length();
        if(length==1)
        this.id = "000"+id;

        else
            if(length==2)
                this.id = "00"+id;

            else
                if (length==3)
                    this.id = "0"+id;

                else if(length==4)
                    this.id = ""+id;
//
//        int min=1000;
//        int max=9999;
//
//        int random =(int)(Math.random()*max+min);
//        this.id=random+"";


    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPIN(String pin) {
        this.id = pin;
    }



}

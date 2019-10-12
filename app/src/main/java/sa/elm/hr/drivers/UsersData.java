package sa.elm.hr.drivers;

import java.util.ArrayList;

public class UsersData {

    public static User [] userArrayList=new User[1000];
    private static int cursor=0;


    public User[] getUserArrayList(){

        return userArrayList;
    }

    public int getCursor() {
        return cursor;
    }



    public static boolean isRegistered(String phone) {

        for (int i = 0; i < userArrayList.length; i++) {
            if(userArrayList[i]!=null)
            if (userArrayList[i].getPhone().equals(phone))
                return true;

        }

        return false;

    }

    public  static void addUser(User user){

        userArrayList[cursor++]=user;



    }

    public static String getIdByPhone(String phone){
        for (int i = 0; i < userArrayList.length; i++) {
            if(userArrayList[i]!=null)

                if (userArrayList[i].getPhone().equals(phone))
        return userArrayList[i].getId();
    }
        return "";}

    public static User getUser(String id){
        for (int i = 0; i < userArrayList.length; i++) {
            if(userArrayList[i]!=null)

                if (userArrayList[i].getId().equals(id))
                return userArrayList[i];
        }
        return null;}

}

package sa.elm.hr.drivers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class Settings extends Fragment {


    CheckedTextView txtLanguage ;
    CheckedTextView txtPersonalInfo ;
    Switch txtNotification ;
//    CheckedTextView txtFavoritePlaces ;
    CheckedTextView txtLogout ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings, container, false);

//1
        txtPersonalInfo = v.findViewById(R.id.pers_info);
        txtPersonalInfo.setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View view) {
              Intent intent = new Intent(getActivity() ,PersonalInfo.class);
                startActivity(intent);
            }
       });


//2
        txtLanguage = v.findViewById(R.id.lang);
        txtLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() ,Language.class);
                startActivity(intent);
            }
        });
//3
        txtNotification = v.findViewById(R.id.setNotif);
//        txtNotification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//             //nothing
//            }
//        });
//4
//        txtFavoritePlaces = v.findViewById(R.id.fav_p);
//        txtFavoritePlaces.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity() ,FavoritePlaceses.class);
//                startActivity(intent);
//            }
//        });
//5
        txtLogout = v.findViewById(R.id.logout);
        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new AlertDialog.Builder(getContext()).setTitle("Logout..").setMessage("Are you sure to exit")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                logout();

                            }}).setNegativeButton("NO",null).show();}



        });
        return v;
    }


    public  void logout(){
        String applang = MySharedPrefence.getString(getContext(),Constants.Keys.APP_LANGUAGE,"en");
        MySharedPrefence.clearData(getContext());
        MySharedPrefence.putString(getContext(),Constants.Keys.APP_LANGUAGE ,applang);
        Intent intent = new Intent(getContext() , SignInActivity.class);
        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        //todo
        //finish();

    }

}

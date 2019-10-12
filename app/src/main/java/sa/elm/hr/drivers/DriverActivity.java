package sa.elm.hr.drivers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import static android.Manifest.permission.CALL_PHONE;

public class DriverActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        EditText car_type= findViewById(R.id.car_type);
        EditText car_plate= findViewById(R.id.car_plate);
        EditText name_driver= findViewById(R.id.name_driver);
        Button continue_button= findViewById(R.id.continue_button);
        car_type.setEnabled(false);
        car_plate.setEnabled(false);
        name_driver.setEnabled(false);

        ImageView call= findViewById(R.id.call);
         linearLayout=(LinearLayout) findViewById(R.id.layout);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(DriverActivity.this).setTitle("Driver call..")
                        .setMessage("Do you want to call driver? ")
                        .setPositiveButton("call", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse("tel:0581466612"));

                                if (ActivityCompat.checkSelfPermission(DriverActivity.this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(DriverActivity.this, new String[]{CALL_PHONE}, 200);

                                }
                                startActivity(intent);
                                //todo calling
                            }}).setNegativeButton("cancel",null).show();}

        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
                new AlertDialog.Builder(DriverActivity.this).setTitle("")
                        .setMessage("Driver is arrived!")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(DriverActivity.this,duringTrip.class);
                                startActivity(intent);
                                //todo calling
                            }}).show();

            }
        });
    }

}

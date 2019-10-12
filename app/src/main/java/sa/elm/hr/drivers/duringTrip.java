package sa.elm.hr.drivers;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Timer;
import java.util.TimerTask;

import static android.Manifest.permission.CALL_PHONE;

public class duringTrip extends AppCompatActivity {
 //MySharedPrefence.getString(getContext(), Constants.Keys.SOURCE, "");
    LinearLayout share_trip , help ;
    EditText from,mTo;
//    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.during_trip);

        from=findViewById(R.id.fromContent);
        mTo=findViewById(R.id.ToContent);


        if(!MySharedPrefence.getString(this, Constants.Keys.SOURCE, "").equals("")
                || !MySharedPrefence.getString(this, Constants.Keys.DESTINATION, "").equals("")){

            from.setText(MySharedPrefence.getString(this, Constants.Keys.SOURCE, ""));
            mTo.setText(MySharedPrefence.getString(this, Constants.Keys.DESTINATION, ""));
            from.setEnabled(false);
            mTo.setEnabled(false);

        }

//        final ProgressDialog pd = new ProgressDialog(duringTrip.this);
//        pd.setMessage(getResources().getString(R.string.search_driver));
//        pd.show();
//
//
//
//
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                pd.dismiss();
//            }
//        }, 4000);



        share_trip=findViewById(R.id.share_trip);

        share_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT","Share Trip");
                intent.putExtra("android.intent.extra.TEXT","Share Trip");
                startActivity(intent.createChooser(intent,"share: "));



            }
        });


        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(duringTrip.this).setTitle("Emergency call..")
                        .setMessage("Do you need help? ")
                        .setPositiveButton("call", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse("tel:8009999"));

                                if (ActivityCompat.checkSelfPermission(duringTrip.this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    ActivityCompat.requestPermissions(duringTrip.this, new String[]{CALL_PHONE}, 200);

                                }
                                startActivity(intent);
                              //todo calling
                            }}).setNegativeButton("cancel",null).show();}

        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(duringTrip.this, RatingActivity.class));
                finish();
            }
        }, 6000);


//        relativeLayout=findViewById(R.id.relLayout1);
//        relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(duringTrip.this,ThankingActivity.class));
//            }
//        });

    }
}

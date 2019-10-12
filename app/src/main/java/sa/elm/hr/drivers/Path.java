package sa.elm.hr.drivers;




import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class Path extends AppCompatActivity {


Button cancel ;
    ProgressDialog progressdialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.path);
//        showProgressDialog(true);



        final ProgressDialog pd = new ProgressDialog(Path.this);
        pd.setMessage(getResources().getString(R.string.search_driver));
        pd.show();




        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                pd.dismiss();

                move();
            }
        }, 4000);



//        cancel = findViewById(R.id.cancel);
//
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Path.this , MapActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    private void move() {

        startActivity(new Intent(Path.this, DriverActivity.class));
//        startActivity(new Intent(Path.this, duringTrip.class));
        finish();
    }

//
//    public void showProgressDialog(boolean isCancelable){
//        try{
//            if(progressdialog!=null||progressdialog.isShowing()){
//                progressdialog= new ProgressDialog(this);
//                progressdialog.setMessage(getString(R.string.search));
//                progressdialog.setCancelable(isCancelable);
//                progressdialog.show();
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }// end showProgressDialog
//
//    public void hideProgressDialog(){
//
//        if(progressdialog!=null)
//            if(progressdialog.isShowing())
//                progressdialog.dismiss();
//
//    }//end hideProgressDialog



}


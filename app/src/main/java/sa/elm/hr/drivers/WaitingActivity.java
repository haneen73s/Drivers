package sa.elm.hr.drivers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class WaitingActivity extends AppCompatActivity {


private Button confirm;
private RelativeLayout payment;
 ImageView economy_car,xl_car,private_car;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        payment = findViewById(R.id.paymentClick);
        confirm = findViewById(R.id.confirm);

        economy_car=findViewById(R.id.economy_car);
        xl_car=findViewById(R.id.xl_car);
        private_car=findViewById(R.id.private_car);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// custom dialog
                final Dialog dialog = new Dialog(WaitingActivity.this);
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Payment : ");

                /*// set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("Android custom dialog example!");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.ic_launcher);*/

               /* Button dialogButton = dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });*/

                dialog.show();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WaitingActivity.this, Path.class));
            }
        });

        economy_car.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (economy_car.getBackground()!=null) {
                    economy_car.setBackground(null);
                }
                economy_car.setBackground(getDrawable(R.drawable.img_border));
                xl_car.setBackground(getDrawable(R.drawable.img_bord));
                private_car.setBackground(getDrawable(R.drawable.img_bord));
            }
        });

        xl_car.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (xl_car.getBackground()!=null) {
                    xl_car.setBackground(null);
                }
                xl_car.setBackground(getDrawable(R.drawable.img_border));
               economy_car.setBackground(getDrawable(R.drawable.img_bord));
                private_car.setBackground(getDrawable(R.drawable.img_bord));
            }
        });

        private_car.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (private_car.getBackground()!=null) {
                    private_car.setBackground(null);
                }
                private_car.setBackground(getDrawable(R.drawable.img_border));
                xl_car.setBackground(getDrawable(R.drawable.img_bord));
                economy_car.setBackground(getDrawable(R.drawable.img_bord));
            }
        });


    }
}

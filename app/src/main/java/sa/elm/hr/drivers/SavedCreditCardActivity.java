package sa.elm.hr.drivers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class SavedCreditCardActivity extends Fragment {

    private TextView cardNumber;
    private ImageView removeCard;
    private Button payByCreditCard;
    private LinearLayout savedCreditCardLayout;

    View view;

//    Toolbar toolbar;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.saved_credit_card, container, false);

//        if( MySharedPrefence.getString(getContext(), Constants.Keys.CREDIT_CARD_NUMBER,"").equals("")){
//
////            setTitle(R.string.add_credit_card);
////        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddCreditCardActivity()).commit();
//           // getChildFragmentManager().beginTransaction().replace(R.id.container, new AddCreditCardActivity()).commit();
//        }

//
//        toolbar = view.findViewById(R.id.toolbar);
//        toolbar.setTitle(getResources().getString(R.string.saved_credit_card));
//        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        savedCreditCardLayout=view.findViewById(R.id.savedCreditCard);
        cardNumber=view.findViewById(R.id.cardNumberTxt);
        cardNumber.setText(MySharedPrefence.getString(getContext(), Constants.Keys.CREDIT_CARD_NUMBER,""));


        removeCard=view.findViewById(R.id.removeCard);
        removeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearCreditCardData();
                savedCreditCardLayout.setVisibility(View.GONE);
        startActivity(new Intent(getContext(),MainActivity.class));
                //payByCreditCard.setVisibility(View.GONE);

            }
        });

        //todo when click back goto home
return view;
    }//end onCreate()


    private void setPayByCreditCard() {
        MySharedPrefence.putString(getContext(), Constants.Keys.PAYMENT_METHOD,"Credit Card");
        //todo add finish();
    }

    private void clearCreditCardData() {
        MySharedPrefence.putString(getContext(), Constants.Keys.CREDIT_CARD_NUMBER, "");
    }//end clearCreditCardData()
}

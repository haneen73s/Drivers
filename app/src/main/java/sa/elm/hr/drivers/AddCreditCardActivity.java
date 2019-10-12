package sa.elm.hr.drivers;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


import com.braintreepayments.cardform.view.CardForm;


    public class AddCreditCardActivity extends Fragment {

        protected CardForm cardForm;
        private AlertDialog.Builder alertBuilder;

//        Toolbar toolbar;
        Button save;
View view;

        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.activity_add_credit_card, container, false);

//                toolbar = view.findViewById(R.id.toolbar);
//                toolbar.setTitle(getResources().getString(R.string.add_credit_card));
//                toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//                setSupportActionBar(toolbar);
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//                getSupportActionBar().setDisplayShowHomeEnabled(true);

            cardForm = view.findViewById(R.id.card_form);
            save = view.findViewById(R.id.saveCreditCardBtn);
            cardForm.cardRequired(true)
                    .expirationRequired(true)
                    .cvvRequired(true)
                    .setup(getActivity());
            cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

            alertBuilder = new AlertDialog.Builder(getContext());

            clearCreditCardData();

            save.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            if (cardForm.isValid()) {

                                                alertBuilder.setTitle("Confirm before add");
                                                alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                                                        "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                                                        "Card CVV: " + cardForm.getCvv());
                                                alertBuilder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialogInterface.dismiss();
                                                        Toast.makeText(getContext(), "Added your credit card successfully", Toast.LENGTH_LONG).show();
                                                        if (saveCreditCard()) {
                                                        //    setTitle(R.string.saved_credit_card);
//                                                            getChildFragmentManager().beginTransaction().replace(R.id.container, new MapActivity()).commit();

                                                            startActivity(new Intent(getActivity(),MainActivity.class));
                                                        }//end if credit card saved
                                                    }
                                                });
                                                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {
                                                        dialogInterface.dismiss();
                                                    }
                                                });
                                                AlertDialog alertDialog = alertBuilder.create();
                                                alertDialog.show();

                                            } else {
                                                Toast.makeText(getContext(), getString(R.string.dialog_complete_form), Toast.LENGTH_LONG).show();
                                            }//end else
                                        }//end onClick()
                                    }//end View.OnClickListener()
            );//end setOnClickListener
return view;
        }//end onCreate()

        private void clearCreditCardData() {
            MySharedPrefence.putString(getContext(), Constants.Keys.CREDIT_CARD_NUMBER, "");
        }//end clearCreditCardData()


        // save credit card to display it in next activity
        private boolean saveCreditCard() {
            if(cardForm!=null) {
                String stars = "**** **** ****";
                String cardNum =cardForm.getCardNumber();
                MySharedPrefence.putString(getContext(), Constants.Keys.CREDIT_CARD_NUMBER,
                        stars + cardNum.substring(cardNum.length() - 4));
                MySharedPrefence.putBoolean(getContext(), Constants.Keys.SAVED_CREDIT_CARD, true);
                return true;
            } else return false;

        }//end saveCreditCard()




    }//end class
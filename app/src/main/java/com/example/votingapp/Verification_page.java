package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Verification_page extends AppCompatActivity {
    PinView pinView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);

        Intent intent=getIntent();
        getSupportActionBar().hide();

        pinView=findViewById(R.id.pinView);
        button=findViewById(R.id.button1);
        pinView.requestFocus();
        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);

        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()==6 ){
                    button.setOnClickListener(btn_clikck());

                }


            }

            @Override
            public void afterTextChanged(Editable editable){




            }
        });

    }

    View.OnClickListener btn_clikck(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setIcon(R.drawable.img);
        builder.setMessage("You’re Verified");
        builder.setMessage("Your account is verified,\n" +
                "let’s start!");
        builder.setNeutralButton("Get started", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle the neutral button action here
                dialog.dismiss();
            }
        });
        builder.show();

        return null;
    }





}
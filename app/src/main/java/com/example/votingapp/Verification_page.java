package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;

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
                    button.setOnClickListener(this::btn_click);

                }
                else{
                    button.setOnClickListener(this::show);
                }



            }

            private void btn_click(View view) {
                click(view);
            }
            private void show(View view){
                Toast.makeText(Verification_page.this, "Please enter the pin", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void afterTextChanged(Editable editable){


            }


        });


    }

    private void click(View view) {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.show();
    }






}
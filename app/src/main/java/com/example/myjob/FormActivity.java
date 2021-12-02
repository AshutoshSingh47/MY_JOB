package com.example.myjob;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class FormActivity extends AppCompatActivity {
    private static int backbackexit = 1;
    EditText operater,partname,moldnumber,machine,machinenumber;
    String OPERATER,PARTNAME,MACHINE,MACHINE_NUMBER;

     private Button button;
     SharedPreferences sp;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        button = (Button) findViewById(R.id.start);
        operater=(EditText)findViewById(R.id.operator);
        moldnumber=(EditText)findViewById(R.id.moldnumber);
        partname=(EditText)findViewById(R.id.partname);
        machine=(EditText)findViewById(R.id.machine);
        machinenumber=(EditText)findViewById(R.id.machinenumber);
        sp=getSharedPreferences("Logged",MODE_PRIVATE);
        if(sp.getBoolean("Logged",false)){
            openNewActivity();}

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OPERATER=operater.getText().toString();
                PARTNAME=partname.getText().toString();
                MACHINE=machine.getText().toString();
                MACHINE_NUMBER=machinenumber.getText().toString();

                if ((TextUtils.isEmpty(operater.getText().toString())) || (TextUtils.isEmpty(partname.getText().toString())) || (TextUtils.isEmpty(partname.getText().toString())) || (TextUtils.isEmpty(machine.getText().toString())) || (TextUtils.isEmpty(machinenumber.getText().toString())) || (TextUtils.isEmpty(moldnumber.getText().toString())))
                {
                    Toast.makeText(getBaseContext(), "Field is Empty", Toast.LENGTH_SHORT).show();
                    }



                else{
                    openNewActivity();
                    sp.edit().putBoolean("Logged",true).apply();
                }
            }
        });
    }
    public void openNewActivity () {
        Intent intent = new Intent(this, StopActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (backbackexit >= 1) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    FormActivity.this);
            alertDialog.setTitle(getResources().getString(R.string.app_name));

            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want to exit??");
            alertDialog.setPositiveButton("YES",
                    (dialog, which) -> finish());
            // Setting Positive Yes Button
            alertDialog.setNeutralButton("NO",
                    (dialog, which) -> {
                    });
            // Showing Alert Message
            alertDialog.show();
//					super.onBackPressed();
        } else {
            backbackexit++;
            Toast.makeText(getBaseContext(), "Press again to Exit", Toast.LENGTH_SHORT).show();
        }
    }






}




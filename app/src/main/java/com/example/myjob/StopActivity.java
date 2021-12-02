package com.example.myjob;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class StopActivity extends AppCompatActivity {

    private static int backbackexit = 1;
    Button stop;
    Button finish;
    SharedPreferences sp,sp2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        stop = (Button) findViewById(R.id.stop);
        finish = (Button) findViewById(R.id.finish);
        sp=getSharedPreferences("Logged",MODE_PRIVATE);
        sp2=getSharedPreferences("Login",MODE_PRIVATE);
        if(sp2.getBoolean("Login",false))
        {
            contActivity();
        }
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(StopActivity.this, ContActivity.class);
//                startActivity(intent);
                contActivity();
                sp2.edit().putBoolean("Login",true).apply();
            }

        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StopActivity.this, FormActivity.class);
                startActivity(intent);
                sp.edit().putBoolean("Logged",false).apply();

            }
        });


    }

    private void contActivity() {
        Intent intent=new Intent(getApplicationContext(),ContActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (backbackexit >= 1) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    StopActivity.this);
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








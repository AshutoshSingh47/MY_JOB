package com.example.myjob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContActivity extends AppCompatActivity {

    private static int backbackexit=1;
    Button button;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont);
        button  = (Button) findViewById(R.id.cont);
        sp=getSharedPreferences("Login",MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
                sp.edit().putBoolean("Login",false).apply();
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
                    ContActivity.this);
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


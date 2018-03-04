package com.app.lookya;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zappar.ZapparEmbed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isCompatible = ZapparEmbed.isCompatible(getApplicationContext());

                if (isCompatible) {
//                    Intent i = new Intent(MainActivity.this, ZapparEmbed.getZapcodeClassForIntent());
//                    startActivity(i);
//                    finish();
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Your device is not compatible to lookya.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }, 3000);

    }
}

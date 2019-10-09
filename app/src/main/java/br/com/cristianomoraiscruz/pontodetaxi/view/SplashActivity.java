package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import br.com.cristianomoraiscruz.pontodetaxi.R;

public class SplashActivity extends AppCompatActivity {

    private final static int TIME_SPLASH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent dashboard = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(dashboard);
                finish();

            }
        },TIME_SPLASH);
    }
}

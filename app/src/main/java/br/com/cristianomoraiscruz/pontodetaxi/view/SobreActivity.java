package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.cristianomoraiscruz.pontodetaxi.BuildConfig;
import br.com.cristianomoraiscruz.pontodetaxi.R;

public class SobreActivity extends AppCompatActivity {

    String versionName;
    TextView txtVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        txtVersion = findViewById(R.id.txtVersion);
        versionName = BuildConfig.VERSION_NAME;

        txtVersion.setText(versionName);
    }
}

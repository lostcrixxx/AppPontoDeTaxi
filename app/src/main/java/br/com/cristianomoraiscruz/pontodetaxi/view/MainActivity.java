package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.onesignal.OneSignal;

import io.sentry.Sentry;
import io.sentry.android.AndroidSentryClientFactory;

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.database.Database;

public class MainActivity extends AppCompatActivity {

    Database db = new Database();

    SharedPreferences prefs;
    TextView txtNPonto, txtQtdTaxista;
    CardView btnTaxi, btnExtrato, btnTaxista, btnGrafico, btnConfig, btnCombustivel, btnDetran, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Gerenciamento");
        Sentry.init("https://90f47a878600458da2399094332392d0@sentry.io/1795712", new AndroidSentryClientFactory(this));


        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        txtNPonto = findViewById(R.id.txtNPonto);
        txtQtdTaxista = findViewById(R.id.txtQtdTaxista);

        btnTaxi = findViewById(R.id.btnTaxi);
        btnExtrato = findViewById(R.id.btnExtrato);
        btnTaxista = findViewById(R.id.btnTaxista);
        btnGrafico = findViewById(R.id.btnGrafico);
        btnCombustivel = findViewById(R.id.btnCombustivel);
        btnDetran = findViewById(R.id.btnDetran);

        btnConfig = findViewById(R.id.btnConfig);
        btnSobre = findViewById(R.id.btnSobre);

        btnTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), AddActivity.class);
                startActivity(i);
//                Toast.makeText(getApplication(), "Click: Taxista", Toast.LENGTH_SHORT).show();
            }
        });

        btnExtrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), ListActivity.class);
                startActivity(i);
            }
        });

        btnTaxista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), ListTaxistaActivity.class);
                startActivity(i);
            }
        });

        btnGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), GraphicActivity.class);
                startActivity(i);
//                Toast.makeText(getApplication(), "Desculpe! Função em processo de manutenção... ", Toast.LENGTH_SHORT).show();
            }
        });

        btnCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), FuelChooseActivity.class);
                startActivity(i);
                //Toast.makeText(getApplication(), "Desculpe! Função em processo de manutenção... ", Toast.LENGTH_SHORT).show();
            }
        });

        btnDetran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), DetranActivity.class);
                startActivity(i);
//                Toast.makeText(getApplication(), "Desculpe! Função em processo de manutenção...", Toast.LENGTH_SHORT).show();
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), ConfigActivity.class);
                startActivity(i);
            }
        });

        // id 6
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SobreActivity.class);
                startActivity(i);
//                Toast.makeText(getApplication(), "Click: Sobre", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        txtNPonto.setText(prefs.getString("nPonto", "Configure o N. do Ponto"));

        String num = String.valueOf(db.getTaxistasCount(this));
        txtQtdTaxista.setText( num + " taxistas");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.settings_sobre:
                Log.d("MainActivity", "sobre");
                Intent iSobre = new Intent(this, SobreActivity.class);
                startActivity(iSobre);
            break;
            case R.id.settings_config:
                Log.d("MainActivity", "configurações");
                Intent iConfig = new Intent(this, ConfigActivity.class);
                startActivity(iConfig);
            break;
            case R.id.settings_sair:
                Log.d("MainActivity", "sair");
                finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}

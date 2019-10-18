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

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.database.Database;

public class MainActivity extends AppCompatActivity {

    Database db = new Database();

    SharedPreferences prefs;
    TextView txtNPonto, txtQtdTaxista;
    CardView btnTaxi, btnExtrato, btnConfig, btnCombustivel, btnDetran, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNPonto = findViewById(R.id.txtNPonto);
        txtQtdTaxista = findViewById(R.id.txtQtdTaxista);

        btnTaxi = findViewById(R.id.btnTaxi);
        btnExtrato = findViewById(R.id.btnExtrato);
        btnCombustivel = findViewById(R.id.btnCombustivel);
        btnDetran = findViewById(R.id.btnDetran);

        btnConfig = findViewById(R.id.btnConfig);
        btnSobre = findViewById(R.id.btnSobre);

        prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        txtNPonto.setText(prefs.getString("nPonto", "Configure o N. do Ponto"));

        String num = String.valueOf(db.getTaxistasCount(this));
        txtQtdTaxista.setText( num + " taxistas");

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


        btnCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Desculpe! Função em processo de manutenção... ", Toast.LENGTH_SHORT).show();
            }
        });

        btnDetran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Desculpe! Função em processo de manutenção...", Toast.LENGTH_SHORT).show();
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

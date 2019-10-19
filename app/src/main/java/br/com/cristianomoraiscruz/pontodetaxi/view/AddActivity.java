package br.com.cristianomoraiscruz.pontodetaxi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.cristianomoraiscruz.pontodetaxi.R;

public class AddActivity extends AppCompatActivity {

    CardView btnMensalidade, btnDespesas, btnTaxista;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnMensalidade = findViewById(R.id.btnMensalidade);
        btnDespesas = findViewById(R.id.btnDespesas);
        btnTaxista = findViewById(R.id.btnTaxista);

        btnMensalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(getApplicationContext(), AddMensalidadeActivity.class);
                startActivity(in);
            }
        });

        btnDespesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(getApplicationContext(), AddDespesasActivity.class);
                startActivity(in);
            }
        });

        btnTaxista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(getBaseContext(), AddTaxistaActivity.class);
                startActivity(in);
            }
        });
    }
}

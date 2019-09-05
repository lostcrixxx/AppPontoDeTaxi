package br.com.cristianomoraiscruz.pontodetaxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView btnTaxi, btnExtrato, btnConfig, btnCombustivel, btnDetran, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTaxi = findViewById(R.id.btnTaxi);
        btnExtrato = findViewById(R.id.btnExtrato);
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


        btnCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Click: Combustivel", Toast.LENGTH_SHORT).show();
            }
        });

        btnDetran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Click: Detran", Toast.LENGTH_SHORT).show();
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
}

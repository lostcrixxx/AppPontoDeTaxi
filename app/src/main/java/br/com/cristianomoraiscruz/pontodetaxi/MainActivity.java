package br.com.cristianomoraiscruz.pontodetaxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView btnTaxi, btnLista, btnPlaca, btnCombustivel, btnDetran, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTaxi = findViewById(R.id.btn1);
        btnLista = findViewById(R.id.btn2);
        btnPlaca = findViewById(R.id.btn3);
        btnCombustivel = findViewById(R.id.btn4);
        btnDetran = findViewById(R.id.btn5);

        btnSobre = findViewById(R.id.btn6);

        btnTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Click: Taxista", Toast.LENGTH_SHORT).show();
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Click: Lista", Toast.LENGTH_SHORT).show();
            }
        });

        btnPlaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Click: Placa", Toast.LENGTH_SHORT).show();
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

        // id 6
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), SobreActivity.class);
//                startActivity(i);
                Toast.makeText(getApplication(), "Click: Sobre", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

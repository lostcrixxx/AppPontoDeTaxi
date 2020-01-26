package br.com.cristianomoraiscruz.pontodetaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import br.com.cristianomoraiscruz.pontodetaxi.R;

import static br.com.cristianomoraiscruz.pontodetaxi.controller.FuelChooseController.calcularVantagem;

public class FuelChooseActivity extends AppCompatActivity {

    EditText edtValueGasolina, edtValueAlcool;
    double valueGasolina = 0, valueAlcool = 0;
    TextView valueResult;
    MaterialButton btnCalcularFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_choose);

        edtValueGasolina = findViewById(R.id.edtValueGasolina);
        edtValueAlcool = findViewById(R.id.edtValueAlcool);
        valueResult = findViewById(R.id.valueResult);
        btnCalcularFuel = findViewById(R.id.btnCalcularFuel);

        btnCalcularFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtValueGasolina.getText().toString().isEmpty() && !edtValueAlcool.getText().toString().isEmpty()) {
                    valueGasolina = Double.parseDouble(edtValueGasolina.getText().toString());
                    valueAlcool = Double.parseDouble(edtValueAlcool.getText().toString());

                    try {
                        valueResult.setText(calcularVantagem(valueGasolina, valueAlcool));
                    } catch (Exception e) {
                        Log.e("FuelChoose", "ERROR " + e.toString());
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "ERRO! Preencha todos os campos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

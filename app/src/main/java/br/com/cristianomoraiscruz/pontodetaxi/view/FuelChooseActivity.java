package br.com.cristianomoraiscruz.pontodetaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.cristianomoraiscruz.pontodetaxi.R;

import static br.com.cristianomoraiscruz.pontodetaxi.controller.FuelChooseController.calcularVantagem;

public class FuelChooseActivity extends AppCompatActivity {

    EditText edtValueGasolina, edtValueAlcool;
    double valueGasolina = 0, valueAlcool = 0;
    TextView valueResult;
    Button btnCalcularFuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_choose);

        edtValueGasolina = (EditText) findViewById(R.id.edtValueGasolina);
        edtValueAlcool = (EditText) findViewById(R.id.edtValueAlcool);
        valueResult = (TextView) findViewById(R.id.valueResult);
        btnCalcularFuel = (Button) findViewById(R.id.btnCalcularFuel);

        btnCalcularFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueGasolina = Double.parseDouble(edtValueGasolina.getText().toString());
                valueAlcool = Double.parseDouble(edtValueAlcool.getText().toString());

                try {
                    valueResult.setText(calcularVantagem(valueGasolina, valueAlcool));
                } catch(Exception e){
                    Log.e("FuelChoose", "ERROR " + e.toString());
                    e.printStackTrace();
                }
            }
        });
    }
}

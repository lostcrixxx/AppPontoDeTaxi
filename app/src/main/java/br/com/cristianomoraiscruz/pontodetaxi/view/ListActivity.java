package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.cristianomoraiscruz.pontodetaxi.database.Database;
import br.com.cristianomoraiscruz.pontodetaxi.database.HelperDB;
import br.com.cristianomoraiscruz.pontodetaxi.R;

/**
 * Modified by Cristiano M. on 23/11/19
 */

public class ListActivity extends AppCompatActivity {

    Database db = new Database();
    double valueMensal, valueDespesa, valueTotal;
    TextView mensalidade, despesa, saldo, lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mensalidade = (TextView) findViewById(R.id.txtValueMensalidade);
        despesa = (TextView) findViewById(R.id.txtValueDespesas);
        saldo = (TextView) findViewById(R.id.txtValueSaldo);
        lista = (TextView) findViewById(R.id.lista);

        valueMensal = db.getMensalidadeTotal(this);
        valueDespesa = db.getDespesaTotal(this);

        valueTotal = valueMensal - valueDespesa;

        mensalidade.setText(String.valueOf("+ R$ " + valueMensal));
        despesa.setText(String.valueOf("- R$ " + valueDespesa));
        saldo.setText(String.valueOf("R$ " + valueTotal));

        // Cor conforme o status de saldo
        if(valueTotal < 0){
            saldo.setTextColor(Color.RED);
        } else if(valueTotal == 0){
            saldo.setTextColor(Color.YELLOW);
        } else {
            saldo.setTextColor(Color.GREEN);
        }

        lista.setText(String.valueOf(db.getHistorico(this)));

    }
}

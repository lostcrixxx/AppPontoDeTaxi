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
 * Modified by Cristiano M. on 20/11/19
 */

public class ListActivity extends AppCompatActivity {

    Database db = new Database();
    double valueMensal, valueDespesa, valueTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView mensalidade = (TextView) findViewById(R.id.txtValueMensalidade);
        TextView despesa = (TextView) findViewById(R.id.txtValueDespesas);
        TextView saldo = (TextView) findViewById(R.id.txtValueSaldo);

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



        //valueMensal = Double.parseDouble(mensalidade.toString());
        Log.e("ListActivity", "valueDespesa " + (valueMensal - valueDespesa));


        HelperDB ch1 = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdr1 = null;
        String str= "\nHistórico\n\n";
        try {
            Context ctx = this;  // ou: Context ctx = v.getContext(); dentro de onClick
            ch1 = new HelperDB(ctx);
            bdr1 = ch1.getReadableDatabase();
            Cursor cursor = bdr1.query("mensalidade", null, null, null, null, null, null);
            // ou Cursor cursor = bdr.rawQuery("select * from contatos", null);
            while (cursor.moveToNext()) {
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String placa = cursor.getString(cursor.getColumnIndex("data"));
                String valor = cursor.getString(cursor.getColumnIndex("valor"));
                String nom = cursor.getString(0);
                String cel = cursor.getString(1);
                String em = cursor.getString(2);
                str += "Nome: " + nome + ", Data: "  + placa + ", R$"  + valor + "\n\n";
            }
            ((TextView)findViewById(R.id.lista)).setText(str);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD.\n", Toast.LENGTH_LONG).show();
        }
        finally {
            if(bdr1!=null) bdr1.close();
            if(ch1!=null) ch1.close();
        }
    }
}

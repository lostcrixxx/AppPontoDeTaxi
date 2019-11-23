package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.database.Database;
import br.com.cristianomoraiscruz.pontodetaxi.database.HelperDB;

public class ListTaxistaActivity extends AppCompatActivity {

    Database db = new Database();
    TextView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_taxista);

        lista = (TextView)findViewById(R.id.lista);

        lista.setText(String.valueOf(db.getTaxistasName(this)));
    }
}

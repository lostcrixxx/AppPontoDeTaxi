package br.com.cristianomoraiscruz.pontodetaxi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        final EditText nPonto = (EditText)findViewById(R.id.edtNPonto);
        Button salvar = (Button)findViewById(R.id.btnSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("nPonto", "Ponto de Táxi: N° " + nPonto.getText().toString());
                editor.apply();
                Toast.makeText(getBaseContext(), "Número do ponto foi salvo com sucesso !", Toast.LENGTH_LONG).show();

                nPonto.setText("");
            }
        });
    }
}

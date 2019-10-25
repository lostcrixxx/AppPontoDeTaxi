package br.com.cristianomoraiscruz.pontodetaxi.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.database.HelperDB;

public class AddMensalidadeActivity extends AppCompatActivity {

    EditText edtNome, edtPlaca, edtCelular;
    String lblNome, lblPlaca, lblCelular;
    Button btnInserirTaxista, btnAlterarTaxista, btnExcluirTaxista;

    HelperDB openHelper = null; // a classe derivada de SQLiteOpenHelper
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mensalidade);
        btnInserirTaxista = findViewById(R.id.btnInserirTaxista);
        btnAlterarTaxista = findViewById(R.id.btnAlterarTaxista);
        btnExcluirTaxista = findViewById(R.id.btnExcluirTaxista);

        createMensalidade(); // insert, update and delete
    }

    public void createMensalidade() {
        btnInserirTaxista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    openHelper = new HelperDB(getApplicationContext());
                    db = openHelper.getWritableDatabase();
                    edtNome = (EditText) findViewById(R.id.nome);
                    edtPlaca = (EditText) findViewById(R.id.placa);
                    edtCelular = (EditText) findViewById(R.id.cel);
                    lblNome = edtNome.getText().toString();
                    lblPlaca = edtPlaca.getText().toString();
                    lblCelular = edtCelular.getText().toString();
                    if (lblNome.isEmpty() || lblCelular.isEmpty()) {
                        Toast.makeText(getApplicationContext(),
                                "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
                    } else {
                        ContentValues cv = new ContentValues();
                        cv.put("nome", lblNome);
                        cv.put("data", lblPlaca);
                        cv.put("valor", lblCelular);
                        long id = db.insert("mensalidade", null, cv);
                        Log.d("AddMensalidadeActivity", "teste db value id: " + id);
                        if (id > 0) {
                            Toast.makeText(getApplicationContext(), "Mensalidade cadastrada com sucesso!",
                                    Toast.LENGTH_LONG).show();
                            edtNome.setText("");
                            edtPlaca.setText("");
                            edtCelular.setText("");
                        } else if (id == -1) {
                            Toast.makeText(getApplicationContext(), "Não foi possível inserir. Nome duplicado!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Não foi possível inserir. Erro!",
                                    Toast.LENGTH_LONG).show();
                            Log.e("AddMensalidadeActivity", "Erro ao inserir Mensalidade");
                        }
                    }
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                            Toast.LENGTH_LONG).show();
                } finally {
                    if (db != null) {
                        db.close();
                    }
                    if (openHelper != null) {
                        openHelper.close();
                    }
                }
            }
        });

        btnAlterarTaxista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    openHelper = new HelperDB(getApplicationContext());
                    db = openHelper.getWritableDatabase();
                    EditText nome = (EditText) findViewById(R.id.nome);
                    EditText celular = (EditText) findViewById(R.id.cel);
                    EditText email = (EditText) findViewById(R.id.email);
                    String n = nome.getText().toString();
                    String c = celular.getText().toString();
                    String e = email.getText().toString();
                    if (n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                        Toast.makeText(getApplicationContext(),
                                "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
                    } else {
                        ContentValues cv = new ContentValues();
                        cv.put("nome", n);
                        cv.put("celular", c);
                        cv.put("email", e);
                        long id = db.update("contatos", cv, "nome='" + n + "'", null);
                        if (id == 0) {
                            Toast.makeText(getApplicationContext(), "\nNão foi possível alterar\n",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                            Toast.LENGTH_LONG).show();
                } finally {
                    if (db != null) {
                        db.close();
                    }
                    if (openHelper != null) {
                        openHelper.close();
                    }
                }
            }
        });

        btnExcluirTaxista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    openHelper = new HelperDB(getApplicationContext());
                    db = openHelper.getWritableDatabase();
                    EditText nome = (EditText) findViewById(R.id.nome);

                    String n = nome.getText().toString();

                    if (n.isEmpty()) {
                        Toast.makeText(getApplicationContext(),
                                "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
                    } else {
                        ContentValues cv = new ContentValues();
                        cv.put("nome", n);

                        long id = db.delete("contatos", "nome='" + n + "'", null);
                        if (id == 0) {
                            Toast.makeText(getApplicationContext(), "\nNão foi possível excluir\n",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
                            Toast.LENGTH_LONG).show();
                } finally {
                    if (db != null) {
                        db.close();
                    }
                    if (openHelper != null) {
                        openHelper.close();
                    }
                }
            }
        });
    }
}

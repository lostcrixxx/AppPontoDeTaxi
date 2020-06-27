package br.com.cristianomoraiscruz.pontodetaxi.view;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import br.com.cristianomoraiscruz.pontodetaxi.R;
import br.com.cristianomoraiscruz.pontodetaxi.controller.MaskWatcher;
import br.com.cristianomoraiscruz.pontodetaxi.database.HelperDB;

import static br.com.cristianomoraiscruz.pontodetaxi.controller.Utils.validarPlaca;

public class AddTaxistaActivity extends AppCompatActivity {

    TextInputEditText edtNome, edtPlaca, edtCelular, edtEmail;
    String lblNome, lblPlaca, lblCelular, lblEmail;
    Button btnInserirTaxista, btnAlterarTaxista, btnExcluirTaxista, btnLimparCampos;

    HelperDB openHelper = null; // a classe derivada de SQLiteOpenHelper
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_taxista);

        btnInserirTaxista = findViewById(R.id.btnInserirTaxista);
//        btnAlterarTaxista = findViewById(R.id.btnAlterarTaxista);
//        btnExcluirTaxista = findViewById(R.id.btnExcluirTaxista);
        btnLimparCampos = findViewById(R.id.btnLimparCampos);

        edtNome = findViewById(R.id.nomeTaxista);
        edtCelular = findViewById(R.id.celTaxista);
        edtPlaca = findViewById(R.id.placaTaxista);
        edtEmail = findViewById(R.id.emailTaxista);

        createTaxista(); // insert, update and delete

        // Mask field
        edtCelular.addTextChangedListener(MaskWatcher.buildCel());
        edtPlaca.addTextChangedListener(MaskWatcher.buildPlaca());
    }

    public void savePonto(View v) {
        HelperDB ch = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdw = null;
        try {
            ch = new HelperDB(getApplicationContext());
            bdw = ch.getWritableDatabase();
            EditText nome = (EditText) findViewById(R.id.nome);
            EditText celular = (EditText) findViewById(R.id.cel);
            EditText email = (EditText) findViewById(R.id.emailTaxista);
            String n = nome.getText().toString();
            String c = celular.getText().toString();
            String e = email.getText().toString();
            if (n.isEmpty() || c.isEmpty() || e.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
            } else {
                ContentValues cv = new ContentValues();
//                cv.put("nome", lblNome);
//                cv.put("celular", lblValor);
//                cv.put("email", lblEmail);
                long id = bdw.insert("contatos", null, cv);
                Log.d("AddTaxistaActivity", "teste db value id: " + id);
                if (id > 0) {
                    Toast.makeText(getApplicationContext(), "Taxista cadastrado com sucesso!",
                            Toast.LENGTH_LONG).show();
//                    edtNome.setText("");
//                    edtValor.setText("");
//                    edtEmail.setText("");
                } else if (id == -1) {
                    Toast.makeText(getApplicationContext(), "Não foi possível inserir. Nome duplicado!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Não foi possível inserir. Erro!",
                            Toast.LENGTH_LONG).show();
                    Log.e("AddTaxistaActivity", "Erro ao inserir Taxista");
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "\nErro processando o BD. Nome duplicado?\n",
                    Toast.LENGTH_LONG).show();
        } finally {
            if (bdw != null) bdw.close();
            if (ch != null) ch.close();
        }
    }

    public void createTaxista() {
        btnInserirTaxista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    openHelper = new HelperDB(getApplicationContext());
                    db = openHelper.getWritableDatabase();

                    lblNome = edtNome.getText().toString();
                    lblPlaca = edtPlaca.getText().toString();
                    lblCelular = edtCelular.getText().toString();
                    lblEmail = edtEmail.getText().toString();
                    if (lblNome.isEmpty() || lblPlaca.isEmpty()) {
                        Toast.makeText(getApplicationContext(),
                                "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
                    } else {
                        validarPlaca(lblPlaca);

                        ContentValues cv = new ContentValues();
                        cv.put("nome", lblNome);
                        cv.put("placa", lblPlaca);
                        cv.put("celular", lblCelular);
                        cv.put("email", lblEmail);
                        long id = db.insert("taxistas", null, cv);
                        Log.d("AddTaxistaActivity", "teste db value id: " + id);
                        if (id > 0) {
                            Toast.makeText(getApplicationContext(), "Taxista cadastrado com sucesso!",
                                    Toast.LENGTH_LONG).show();
                            limparCampos();
                        } else if (id == -1) {
                            Toast.makeText(getApplicationContext(), "Não foi possível inserir. Nome duplicado!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Não foi possível inserir. Erro!",
                                    Toast.LENGTH_LONG).show();
                            Log.e("AddTaxistaActivity", "Erro ao inserir Taxista");
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

//        btnAlterarTaxista.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                try {
//                    openHelper = new HelperDB(getApplicationContext());
//                    db = openHelper.getWritableDatabase();
//                    EditText nome = (EditText) findViewById(R.id.nome);
//                    EditText placa = (EditText) findViewById(R.id.placa);
//                    EditText celular = (EditText) findViewById(R.id.cel);
//                    EditText email = (EditText) findViewById(R.id.email);
//                    String n = nome.getText().toString();
//                    String strPlaca = placa.getText().toString();
//                    String c = celular.getText().toString();
//                    String e = email.getText().toString();
//                    if (n.isEmpty() || c.isEmpty() || e.isEmpty()) {
//                        Toast.makeText(getApplicationContext(),
//                                "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
//                    } else {
//                        ContentValues cv = new ContentValues();
//                        cv.put("nome", n);
//                        cv.put("placa", strPlaca);
//                        cv.put("celular", c);
//                        cv.put("email", e);
//                        long id = db.update("contatos", cv, "nome='" + n + "'", null);
//                        if (id == 0) {
//                            Toast.makeText(getApplicationContext(), "\nNão foi possível alterar\n",
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    }
//                } catch (Exception ex) {
//                    Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
//                            Toast.LENGTH_LONG).show();
//                } finally {
//                    if (db != null) {
//                        db.close();
//                    }
//                    if (openHelper != null) {
//                        openHelper.close();
//                    }
//                }
//            }
//        });
//
//        btnExcluirTaxista.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    openHelper = new HelperDB(getApplicationContext());
//                    db = openHelper.getWritableDatabase();
//                    EditText nome = (EditText) findViewById(R.id.nome);
//
//                    String n = nome.getText().toString();
//
//                    if (n.isEmpty()) {
//                        Toast.makeText(getApplicationContext(),
//                                "Por favor, preencha os dados.", Toast.LENGTH_LONG).show();
//                    } else {
//                        ContentValues cv = new ContentValues();
//                        cv.put("nome", n);
//
//                        long id = db.delete("contatos", "nome='" + n + "'", null);
//                        if (id == 0) {
//                            Toast.makeText(getApplicationContext(), "\nNão foi possível excluir\n",
//                                    Toast.LENGTH_LONG).show();
//                        }
//                    }
//                } catch (Exception ex) {
//                    Toast.makeText(getApplicationContext(), "\nErro processando o BD. \n",
//                            Toast.LENGTH_LONG).show();
//                } finally {
//                    if (db != null) {
//                        db.close();
//                    }
//                    if (openHelper != null) {
//                        openHelper.close();
//                    }
//                }
//            }
//        });

        btnLimparCampos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    void limparCampos() {
        edtNome.setText("");
        edtPlaca.setText("");
        edtCelular.setText("");
        edtEmail.setText("");
    }
}
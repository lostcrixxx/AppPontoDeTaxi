package br.com.cristianomoraiscruz.pontodetaxi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION = 1;

    private final static String TAB_CONTATO = "contatos";

    private final static String DATABASE_NAME = "db_pontotaxi";   //nome do BD
    public final static String TAB_PONTO = "ponto"; //nome da tabela
    public final static String TAB_TAXISTA = "taxistas";
    public final static String TAB_MENSALIDADE = "mensalidade";
    public final static String TAB_CONTA = "contas";

    private String TABLE_CREATE10 = "create table " + TAB_CONTATO +
            " (nome String PRIMARY KEY, placa String, valor String, celular String, email String);";

    private String TABLE_CREATE1 = "create table " + TAB_PONTO +
            " (id Integer, numPonto Integer PRIMARY KEY, telefone1 Text, telefone2 Text, endereco Text, email Text, site Text);";

    private String TABLE_CREATE2 = "create table " + TAB_TAXISTA +
            " (id Integer, nome String PRIMARY KEY, placa String, celular String, email String);";

    private String TABLE_CREATE3 = "create table " + TAB_MENSALIDADE +
            " (id Integer PRIMARY KEY, nome String, data String, valor String);";

    private String TABLE_CREATE4 = "create table " + TAB_CONTA +
            " (id Integer PRIMARY KEY, nome String, data String, valor String);";

    public HelperDB(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE1);
        db.execSQL(TABLE_CREATE2);
        db.execSQL(TABLE_CREATE3);
        db.execSQL(TABLE_CREATE4);

        db.execSQL(TABLE_CREATE10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}

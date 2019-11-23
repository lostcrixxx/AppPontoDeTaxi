package br.com.cristianomoraiscruz.pontodetaxi.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Modified by Cristiano M. on 20/11/19
 */

public class Database {

    //    HelperDB helperDB = new HelperDB(context);
    HelperDB helperDB;
    SQLiteDatabase db;

    public long getTaxistasCount(Context context) {
        long count = 0;
        helperDB = new HelperDB(context);
        db = helperDB.getReadableDatabase();

        try {
            count = DatabaseUtils.queryNumEntries(db, "taxistas");
            Log.i("Database", "Quantidade de taxistas: " + count);
        } catch (Exception e) {
            Log.e("Database", "Quantidade de taxistas");
        }

        db.close();
        return count;
    }

    public String getTaxistasName(Context context) {
        HelperDB ch1 = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdr1 = null;
        String str = "\nTaxistas\n\n";
        try {
            ch1 = new HelperDB(context);
            bdr1 = ch1.getReadableDatabase();
            Cursor cursor = bdr1.query("taxistas", null, null, null, null, null, "nome");
            // ou Cursor cursor = bdr.rawQuery("select * from contatos", null);
            while (cursor.moveToNext()) {
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String placa = cursor.getString(cursor.getColumnIndex("placa"));
                String valor = cursor.getString(cursor.getColumnIndex("celular"));
                str += "Nome: " + nome + ", Placa: " + placa + ", Celular:" + valor + "\n\n";
            }
        } catch (Exception ex) {
            Log.e("Database", "ERROR getTaxistasName");
            //Toast.makeText(getApplicationContext(), "\nErro processando o BD.\n", Toast.LENGTH_LONG).show();
        } finally {
            if (bdr1 != null) bdr1.close();
            if (ch1 != null) ch1.close();
        }
        return str;
    }

    public double getMensalidadeTotal(Context context) {
        double count = 0;
        helperDB = new HelperDB(context);
        db = helperDB.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT sum(valor) FROM mensalidade", null);
        if (c.moveToFirst()) {
            do {
                //Recuperando valores
                count += c.getDouble(0);

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return count;
    }

    public double getDespesaTotal(Context context) {
        double count = 0;
        helperDB = new HelperDB(context);
        db = helperDB.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT sum(valor) FROM contas", null);
        if (c.moveToFirst()) {
            do {
                //Recuperando valores
                count += c.getDouble(0);

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return count;
    }

    public String getHistorico(Context context) {
        HelperDB ch1 = null;  // a classe derivada de SQLiteOpenHelper
        SQLiteDatabase bdr1 = null;
        String str = "\nHistórico\n\n";
        try {
            //Context ctx = this;  // ou: Context ctx = v.getContext(); dentro de onClick
            ch1 = new HelperDB(context);
            bdr1 = ch1.getReadableDatabase();
            Cursor cursor = bdr1.query("mensalidade", null, null, null, null, null, "id DESC");
            // ou Cursor cursor = bdr.rawQuery("select * from contatos", null);
            while (cursor.moveToNext()) {
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String placa = cursor.getString(cursor.getColumnIndex("data"));
                String valor = cursor.getString(cursor.getColumnIndex("valor"));
                str += "Nome: " + nome + ", Data: " + placa + ", R$" + valor + "\n\n";
            }
        } catch (Exception ex) {
            Log.e("Database", "ERROR getHistorico");
            //Toast.makeText(getApplicationContext(), "\nErro processando o BD.\n", Toast.LENGTH_LONG).show();
        } finally {
            if (bdr1 != null) bdr1.close();
            if (ch1 != null) ch1.close();
        }
        return str;
    }

    public void insertFast(int insertCount) {

        // you can use INSERT only
//        String sql = "INSERT OR REPLACE INTO " + tableName + " ( name, description ) VALUES ( ?, ? )";
//
//        SQLiteDatabase db = HelperDB.getWritableDatabase();
//
//        /*
//         * According to the docs http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html
//         * Writers should use beginTransactionNonExclusive() or beginTransactionWithListenerNonExclusive(SQLiteTransactionListener)
//         * to start a transaction. Non-exclusive mode allows database file to be in readable by other threads executing queries.
//         */
//        db.beginTransactionNonExclusive();
//        // db.beginTransaction();
//
//        SQLiteStatement stmt = db.compileStatement(sql);
//
//        for(int x=1; x<=insertCount; x++){
//
//            stmt.bindString(1, "Name # " + x);
//            stmt.bindString(2, "Description # " + x);
//
//            stmt.execute();
//            stmt.clearBindings();
//
//        }
//
//        db.setTransactionSuccessful();
//        db.endTransaction();
//
//        db.close();
    }
}

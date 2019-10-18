package br.com.cristianomoraiscruz.pontodetaxi.database;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class Database {

    Context context;
//    HelperDB helperDB = new HelperDB(context);

    public long getTaxistasCount(Context context) {
        long count = 0;
        HelperDB helperDB = new HelperDB(context);
        SQLiteDatabase db = helperDB.getReadableDatabase();
        try {
            count = DatabaseUtils.queryNumEntries(db, "taxistas");
            Log.i("Database", "Quantidade de taxistas: " + count);
        } catch(Exception e){
            Log.e("Database", "Quantidade de taxistas");
        }
        db.close();
        return count;
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

package br.com.cristianomoraiscruz.pontodetaxi.database;

import android.database.sqlite.SQLiteStatement;

public class Database {

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

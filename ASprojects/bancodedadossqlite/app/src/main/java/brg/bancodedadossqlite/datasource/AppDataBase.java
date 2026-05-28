package brg.bancodedadossqlite.datasource;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import brg.bancodedadossqlite.datamodel.ClienteDataModel;

public class AppDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME = "loja.sqlite";
    public static int version = 2;

    SQLiteDatabase db;
    public AppDataBase(Context context) {
        super(context, DB_NAME, null, version);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + ClienteDataModel.TABELA);
    }

    public boolean insert(String tabela, ContentValues dados){
        db = getWritableDatabase();
        boolean retorno = false;
        retorno = db.insert(tabela, null, dados) >0;
        return retorno;
    }
}

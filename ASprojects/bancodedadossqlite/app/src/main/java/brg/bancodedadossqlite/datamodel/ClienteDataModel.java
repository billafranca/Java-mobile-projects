package brg.bancodedadossqlite.datamodel;

import java.util.Queue;

public class ClienteDataModel {
    public static final String TABELA = "cliente";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL= "email";
    public static String queryCriarTabela = "";
    public static String criarTabela(){
        queryCriarTabela += "CREATE TABLE " + TABELA + "(";
        queryCriarTabela += ID    + " integer primary key autoincrement, ";
        queryCriarTabela += NOME  + " TEXT, ";
        queryCriarTabela += EMAIL + " TEXT ";
        queryCriarTabela += ")";

        return  queryCriarTabela;
    }
}
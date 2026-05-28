package brg.bancodedadossqlite.controller;

import android.content.ContentValues;
import android.content.Context;

import brg.bancodedadossqlite.datamodel.ClienteDataModel;
import brg.bancodedadossqlite.datasource.AppDataBase;
import brg.bancodedadossqlite.model.Cliente;

import java.util.Collections;
import java.util.List;

public class ClienteController extends AppDataBase implements iCRUD<Cliente> {
    ContentValues dados;
    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {
        dados = new ContentValues();
        dados.put(ClienteDataModel.NOME, obj.getNome());
        dados.put(ClienteDataModel.EMAIL, obj.getEmail());

        //                   cliente , obj dos clientes
        return insert(ClienteDataModel.TABELA, dados);
    }

    @Override
    public boolean apagar(Cliente obj) {
        dados = new ContentValues();
        dados.put(ClienteDataModel.ID, obj.getId() );

        return false;
    }

    @Override
    public boolean alterar(Cliente obj) {
        return false;
    }

    @Override
    public List listar(Cliente obj) {
        return Collections.emptyList();
    }
}
package brg.bancodedadossqlite.controller;

import java.util.List;

public interface iCRUD <T>{
    public boolean incluir(T obj);
    public boolean apagar(T obj);
    public boolean alterar(T obj);
    public List listar (T obj);
}

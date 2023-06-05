package br.com.dio.desafio.view;

public class ItemNaoEncontradoException extends Exception {
    public ItemNaoEncontradoException(String nomeItem) {
        super("Nao foi possivel encontrar \'" + nomeItem + "\'");
    }
    
}

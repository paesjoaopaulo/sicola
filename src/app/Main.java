package app;

import DB.Conexao;

public class Main {
    public static void main(String args[]){
        Conexao c = new Conexao();
        c.getInstance();
    }
}

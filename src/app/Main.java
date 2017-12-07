package app;

import bean.Cliente;
import bean.Distribuicao;
import bean.Safra;

import persistencia.ClientePersistency;
import persistencia.DistribuicaoPersistency;
import persistencia.SafraPersistency;

public class Main {

    public static void main(String args[]) {

        SafraPersistency s = new SafraPersistency();
        Safra safra = new Safra("2017-12-23", "2017-12-30", 1000, "Laranja Lima");
        s.insert(safra);

        ClientePersistency c = new ClientePersistency();
        Cliente cliente = new Cliente("João Paulo Paes", "Palmital/SP");
        c.insert(cliente);
        
        DistribuicaoPersistency d = new DistribuicaoPersistency();
        Distribuicao distribuicao = new Distribuicao(200, 2000, 1, "2017-12-07");
        d.insert(distribuicao);

        //TODO: criar interfaces gráficas
    }
}

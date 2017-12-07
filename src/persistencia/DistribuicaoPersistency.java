package persistencia;

import bean.Distribuicao;
import dao.DistribuicaoDAO;
import java.util.List;

public class DistribuicaoPersistency {

    private final DistribuicaoDAO dao;

    public DistribuicaoPersistency() {
        dao = new DistribuicaoDAO();
    }

    public void insert(Distribuicao d) {
        dao.insert(d);
    }

    public void delete(Distribuicao d) {
        dao.delete(d);
    }

    public void update(Distribuicao d) {
        dao.update(d);
    }

    public List findByDataEntrega(Distribuicao d) {
        return dao.findByDataEntrega(d);
    }

    public List findByKg(Distribuicao d) {
        return dao.findByKg(d);
    }

    public List all() {
        return dao.findAll();
    }
}

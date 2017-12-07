package persistencia;

import bean.Cliente;
import dao.ClienteDAO;
import java.util.List;

public class ClientePersistency {

    private final ClienteDAO dao;

    public ClientePersistency() {
        dao = new ClienteDAO();
    }

    public void insert(Cliente c) {
        dao.insert(c);
    }

    public void delete(Cliente c) {
        dao.delete(c);
    }

    public void update(Cliente c) {
        dao.update(c);
    }

    public List findByCidade(Cliente c) {
        return dao.findByCidade(c);
    }

    public List findByNome(Cliente c) {
        return dao.findByNome(c);
    }

    public List all() {
        return dao.findAll();
    }
}

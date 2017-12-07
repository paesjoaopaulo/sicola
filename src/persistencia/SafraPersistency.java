package persistencia;

import bean.Safra;
import dao.SafraDAO;
import java.util.List;

public class SafraPersistency {

    private final SafraDAO dao;

    public SafraPersistency() {
        dao = new SafraDAO();
    }

    public void insert(Safra s) {
        dao.insert(s);
    }

    public void delete(Safra s) {
        dao.delete(s);
    }

    public void update(Safra s) {
        dao.update(s);
    }

    public List findByAno(Safra s) {
        return dao.findByAno(s);
    }

    public List findByTipo(Safra s) {
        return dao.findByTipo(s);
    }

    public List all() {
        return dao.findAll();
    }
}

package bean;

import dao.ClienteDAO;

public class Distribuicao {

    private int id;
    private int kg;
    private int totalPago;
    private Cliente cliente;
    private String dataEntrega;
    private ClienteDAO cliDAO;
            
    public Distribuicao() {
        this.cliDAO = new ClienteDAO();
    }

    public Distribuicao(int id, int kg, int totalPago, int clientes_id, String dataEntrega) {
        this.cliDAO = new ClienteDAO();
        this.id = id;
        this.kg = kg;
        this.totalPago = totalPago;
        this.setClienteById(clientes_id);
        this.dataEntrega = dataEntrega;
    }

    public Distribuicao(int kg, int totalPago, int clientes_id, String dataEntrega) {
        this.cliDAO = new ClienteDAO();
        this.kg = kg;
        this.totalPago = totalPago;
        this.setClienteById(clientes_id);
        this.dataEntrega = dataEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(int totalPago) {
        this.totalPago = totalPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString() {
        return "Distribuicao{" + "id=" + id + ", kg=" + kg + ", totalPago=" + totalPago + ", cliente=" + cliente + ", dataEntrega=" + dataEntrega + '}';
    }
    
    public final void setClienteById(int id){
        this.cliente = cliDAO.find(id);
    }

}

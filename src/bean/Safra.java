package bean;

public class Safra {

    private int id;
    private String dataPlantio;
    private String dataColheita;
    private int kg;
    private String tipo;

    public Safra() {
    }

    public Safra(String dataPlantio, String dataColheita, int kg, String tipo) {
        this.dataPlantio = dataPlantio;
        this.dataColheita = dataColheita;
        this.kg = kg;
        this.tipo = tipo;
    }

    public Safra(int id, String dataPlantio, String dataColheita, int kg, String tipo) {
        this.id = id;
        this.dataPlantio = dataPlantio;
        this.dataColheita = dataColheita;
        this.kg = kg;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataPlantio() {
        return dataPlantio;
    }

    public void setDataPlantio(String dataPlantio) {
        this.dataPlantio = dataPlantio;
    }

    public String getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(String dataColheita) {
        this.dataColheita = dataColheita;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Safra{" + "id=" + id + ", dataPlantio=" + dataPlantio + ", dataColheita=" + dataColheita + ", kg=" + kg + ", tipo=" + tipo + '}';
    }

}

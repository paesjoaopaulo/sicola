package bean;

public class Cliente {

    private int id;
    private String nome;
    private String cidade;

    public Cliente() {
    }

    public Cliente(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public Cliente(int id, String nome, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cidade=" + cidade + '}';
    }

}

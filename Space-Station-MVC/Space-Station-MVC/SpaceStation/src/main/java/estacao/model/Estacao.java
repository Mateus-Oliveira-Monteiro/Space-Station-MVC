package estacao.model;


public class Estacao {
    private int idEstacao;
    private String nome;
    private float temperatura;
    private int oxigenioIdOxigenio;

    public Estacao(int idEstacao, String nome, float temperatura, int oxigenioIdOxigenio) {
        this.idEstacao = idEstacao;
        this.nome = nome;
        this.temperatura = temperatura;
        this.oxigenioIdOxigenio = oxigenioIdOxigenio;
    }

    public Estacao() {

    }

    public int getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(int idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public int getOxigenioIdOxigenio() {
        return oxigenioIdOxigenio;
    }

    public void setOxigenioIdOxigenio(int oxigenioIdOxigenio) {
        this.oxigenioIdOxigenio = oxigenioIdOxigenio;
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "idEstacao=" + idEstacao +
                ", nome='" + nome + '\'' +
                ", temperatura=" + temperatura +
                ", oxigenioIdOxigenio=" + oxigenioIdOxigenio +
                '}';
    }
}

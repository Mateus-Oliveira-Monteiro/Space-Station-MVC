package estacao.model;

public class Foguete {
    private int idFoguete;
    private String nome;
    private int combustivelIdCombustivel;
    private String localLancamento;

    public Foguete(int idFoguete, String nome, int combustivelIdCombustivel, String localLancamento) {
        this.idFoguete = idFoguete;
        this.nome = nome;
        this.combustivelIdCombustivel = combustivelIdCombustivel;
        this.localLancamento = localLancamento;
    }

    public Foguete() {

    }

    public int getIdFoguete() {
        return idFoguete;
    }

    public void setIdFoguete(int idFoguete) {
        this.idFoguete = idFoguete;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCombustivelId() {
        return combustivelIdCombustivel;
    }

    public void setCombustivelId(int combustivelIdCombustivel) {
        this.combustivelIdCombustivel = combustivelIdCombustivel;
    }

    public String getLocalLancamento() {
        return localLancamento;
    }

    public void setLocalLancamento(String localLancamento) {
        this.localLancamento = localLancamento;
    }

    @Override
    public String toString() {
        return "Foguete{" +
                "idFoguete=" + idFoguete +
                ", nome='" + nome + '\'' +
                ", combustivelIdCombustivel=" + combustivelIdCombustivel +
                ", localLancamento='" + localLancamento + '\'' +
                '}';
    }

}
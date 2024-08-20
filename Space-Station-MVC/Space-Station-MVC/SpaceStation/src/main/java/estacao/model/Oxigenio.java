package estacao.model;

public class Oxigenio {
    private int idOxigenio;
    private float quantidadeAbastecida;
    private String estado;

    public Oxigenio(int idOxigenio, float quantidadeAbastecida, String estado) {
        this.idOxigenio = idOxigenio;
        this.quantidadeAbastecida = quantidadeAbastecida;
        this.estado = estado;
    }

    public Oxigenio() {

    }

    public int getIdOxigenio() {
        return idOxigenio;
    }

    public void setIdOxigenio(int idOxigenio) {
        this.idOxigenio = idOxigenio;
    }

    public float getQuantidadeAbastecida() {
        return quantidadeAbastecida;
    }

    public void setQuantidadeAbastecida(float quantidadeAbastecida) {
        this.quantidadeAbastecida = quantidadeAbastecida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Oxigenio{" +
                "idOxigenio=" + idOxigenio +
                ", quantidadeAbastecida=" + quantidadeAbastecida +
                ", estado='" + estado + '\'' +
                '}';
    }
}


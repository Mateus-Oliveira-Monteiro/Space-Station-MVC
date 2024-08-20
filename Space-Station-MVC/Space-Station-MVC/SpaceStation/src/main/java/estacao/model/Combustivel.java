package estacao.model;

public class Combustivel {
    private int idCombustivel;
    private String marca;

    // Construtor padrão
    public Combustivel() {}

    // Construtor com parâmetros
    public Combustivel(int idCombustivel, String marca) {
        this.idCombustivel = idCombustivel;
        this.marca = marca;
    }

    // Getters e Setters
    public int getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(int idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Combustivel{" +
                "idCombustivel=" + idCombustivel +
                ", marca='" + marca + '\'' +
                '}';
    }
}



package estacao.model;

public class Relatorio {
    private int idRelatorio;
    private String descricao;

    public Relatorio(int idRelatorio, String descricao) {
        this.idRelatorio = idRelatorio;
        this.descricao = descricao;
    }

    public Relatorio() {

    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "idRelatorio=" + idRelatorio +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
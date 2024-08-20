package estacao.model;

public class EmpresaParceria {
    private int idEmpresaParceria;
    private String nomeEmpresa;
    private String pais;

    public EmpresaParceria(int idEmpresaParceria, String nomeEmpresa, String pais) {
        this.idEmpresaParceria = idEmpresaParceria;
        this.nomeEmpresa = nomeEmpresa;
        this.pais = pais;
    }

    public EmpresaParceria() {

    }

    public int getIdEmpresaParceria() {
        return idEmpresaParceria;
    }

    public void setIdEmpresaParceria(int idEmpresaParceria) {
        this.idEmpresaParceria = idEmpresaParceria;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "EmpresaParceria{" +
                "idEmpresaParceria=" + idEmpresaParceria +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
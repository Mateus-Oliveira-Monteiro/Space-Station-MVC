package estacao.model;

public class Astronauta {
    private int idAstronauta;
    private String nomeAstro;
    private String pais;
    private int especialidadeIdEspecialidade;

    public Astronauta(int idAstronauta, String nomeAstro, String pais, int especialidadeIdEspecialidade) {
        this.idAstronauta = idAstronauta;
        this.nomeAstro = nomeAstro;
        this.pais = pais;
        this.especialidadeIdEspecialidade = especialidadeIdEspecialidade;
    }

    public Astronauta() {

    }

    public Astronauta(int idAstro, String nomeAstro, String pais) {

    }

    public int getIdAstronauta() {
        return idAstronauta;
    }

    public void setIdAstronauta(int idAstronauta) {
        this.idAstronauta = idAstronauta;
    }

    public String getNomeAstro() {
        return nomeAstro;
    }

    public void setNomeAstro(String nomeAstro) {
        this.nomeAstro = nomeAstro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEspecialidadeIdEspecialidade() {
        return especialidadeIdEspecialidade;
    }

    public void setEspecialidadeIdEspecialidade(int especialidadeIdEspecialidade) {
        this.especialidadeIdEspecialidade = especialidadeIdEspecialidade;
    }

    @Override
    public String toString() {
        return "Astronauta{" +
                "idAstronauta=" + idAstronauta +
                ", nomeAstro='" + nomeAstro + '\'' +
                ", pais='" + pais + '\'' +
                ", especialidadeIdEspecialidade=" + especialidadeIdEspecialidade +
                '}';
    }
}
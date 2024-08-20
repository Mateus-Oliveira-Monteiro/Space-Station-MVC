package estacao.model;

public class Missao {
    private int idMissao;
    private String nomeMissao;
    private int duracaoDias;
    private String motivo;
    private int empresaParceriaIdEmpresaParceria;
    private int astronautaIdAstronauta;
    private int fogueteIdFoguete;
    private int fogueteCombustivelIdCombustivel;
    private int relatorioIdRelatorio;
    private int estacaoIdEstacao;

    public Missao(int idMissao, String nomeMissao, int duracaoDias, String motivo, int empresaParceriaIdEmpresaParceria, int astronautaIdAstronauta, int fogueteIdFoguete, int fogueteCombustivelIdCombustivel, int relatorioIdRelatorio, int estacaoIdEstacao) {
        this.idMissao = idMissao;
        this.nomeMissao = nomeMissao;
        this.duracaoDias = duracaoDias;
        this.motivo = motivo;
        this.empresaParceriaIdEmpresaParceria = empresaParceriaIdEmpresaParceria;
        this.astronautaIdAstronauta = astronautaIdAstronauta;
        this.fogueteIdFoguete = fogueteIdFoguete;
        this.fogueteCombustivelIdCombustivel = fogueteCombustivelIdCombustivel;
        this.relatorioIdRelatorio = relatorioIdRelatorio;
        this.estacaoIdEstacao = estacaoIdEstacao;
    }

    public Missao() {

    }

    public int getIdMissao() {
        return idMissao;
    }

    public void setIdMissao(int idMissao) {
        this.idMissao = idMissao;
    }

    public  String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getEmpresaParceriaIdEmpresaParceria() {
        return empresaParceriaIdEmpresaParceria;
    }

    public void setEmpresaParceriaIdEmpresaParceria(int empresaParceriaIdEmpresaParceria) {
        this.empresaParceriaIdEmpresaParceria = empresaParceriaIdEmpresaParceria;
    }

    public int getAstronautaIdAstronauta() {
        return astronautaIdAstronauta;
    }

    public void setAstronautaIdAstronauta(int astronautaIdAstronauta) {
        this.astronautaIdAstronauta = astronautaIdAstronauta;
    }

    public int getFogueteIdFoguete() {
        return fogueteIdFoguete;
    }

    public void setFogueteIdFoguete(int fogueteIdFoguete) {
        this.fogueteIdFoguete = fogueteIdFoguete;
    }

    public int getFogueteCombustivelIdCombustivel() {
        return fogueteCombustivelIdCombustivel;
    }

    public void setFogueteCombustivelIdCombustivel(int fogueteCombustivelIdCombustivel) {
        this.fogueteCombustivelIdCombustivel = fogueteCombustivelIdCombustivel;
    }

    public int getEstacaoIdEstacao() {
        return estacaoIdEstacao;
    }

    public void setEstacaoIdEstacao(int estacaoIdEstacao) {
        this.estacaoIdEstacao = estacaoIdEstacao;
    }

    public int getRelatorioIdRelatorio() {
        return relatorioIdRelatorio;
    }

    public void setRelatorioIdRelatorio(int relatorioIdRelatorio) {
        this.relatorioIdRelatorio = relatorioIdRelatorio;
    }

    @Override
    public String toString() {
        return "Missao{" +
                "idMissao=" + idMissao +
                ", nomeMissao='" + nomeMissao + '\'' +
                ", duracaoDias=" + duracaoDias +
                ", motivo='" + motivo + '\'' +
                ", empresaParceriaIdEmpresaParceria=" + empresaParceriaIdEmpresaParceria +
                ", astronautaIdAstronauta=" + astronautaIdAstronauta +
                ", fogueteIdFoguete=" + fogueteIdFoguete +
                ", fogueteCombustivelIdCombustivel=" + fogueteCombustivelIdCombustivel +
                ", relatorioIdRelatorio=" + relatorioIdRelatorio +
                '}';
    }
}
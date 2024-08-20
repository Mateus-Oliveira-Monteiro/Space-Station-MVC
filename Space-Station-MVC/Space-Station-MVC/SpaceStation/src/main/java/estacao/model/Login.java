package estacao.model;

public class Login {
    private Integer idLogin;
    private String nome;
    private String senha;

    public Login(String nome, String senha) {
        this(null, nome, senha);
    }
    public Login(Integer idLogin, String nome, String senha) {
        this.idLogin = idLogin;
        this.nome = nome;
        this.senha = senha;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" +
                "idLogin=" + idLogin +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

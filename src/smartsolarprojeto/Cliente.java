package smartsolarprojeto;

public class Cliente {
    
    private int id;
    private String nome;
    private String RG;
    private String CPF;
    private String email;
    private String senha;

    public Cliente(int id, String nome, String senha){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    // Getters e Setters corretos

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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void AtualizarSenha(String senha) {
        this.senha = senha;
    }
}

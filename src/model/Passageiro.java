package model;

public class Passageiro {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone_contato;
    private String email;

    public Passageiro() {
    }

    public Passageiro(Integer id, String nome, String cpf, String telefone_contato, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone_contato = telefone_contato;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone_contato() {
        return telefone_contato;
    }

    public void setTelefone_contato(String telefone_contato) {
        this.telefone_contato = telefone_contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone_contato='" + telefone_contato + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class Cliente {
    private String nome;
    private String endereço;
    private String email;
    private String telefone;
    private String senha;

public Cliente(String nome, String endereço, String email, String telefone, String senha) {
    this.nome = nome;
    this.endereço = endereço;
    this.email = email;
    this.telefone = telefone;
    this.senha = senha;
}
public String getnome() {
    return nome;
}
public String getEndereço() {
    return endereço;
}

public String getEmail() {
    return email;
}

public String getTelefone() {
    return telefone;
}

public boolean autenticar(String email2, String senha2) {
    return this.email.equals(email2) && this.senha.equals(senha2);
    }
}
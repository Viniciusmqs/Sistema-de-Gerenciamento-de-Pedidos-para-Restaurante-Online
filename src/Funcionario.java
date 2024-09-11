public class Funcionario {
    private String nome;
    private String senha; 

    public Funcionario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public void atualizarStatusPedido(Pedido pedido, String status) {
        pedido.setStatus(status);
    }
}



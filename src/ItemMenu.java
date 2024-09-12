public class ItemMenu {
    private String nome;
    private String descricao;
    private double preco;

    public ItemMenu(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao + " : R$ " + preco;
    }
}
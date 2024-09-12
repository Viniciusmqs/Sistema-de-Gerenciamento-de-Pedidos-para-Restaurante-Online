import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemMenu> itens;
    private String status;

    public Pedido(Cliente cliente) {
        this.itens = new ArrayList<>();
        this.status = "Recebido";
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemMenu::getPreco).sum();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void exibirResumo() {
        System.out.println("Resumo do Pedido:");
        itens.forEach(System.out::println);
        System.out.println("Total: R$ " + calcularTotal());
        System.out.println("Status: " + status);
    }
}
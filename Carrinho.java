import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemMenu> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public void exibirCarrinho() {
        System.out.println("Carrinho:");
        itens.forEach(System.out::println);
    }

    public List<ItemMenu> getItens() {
        return itens;
    }
}
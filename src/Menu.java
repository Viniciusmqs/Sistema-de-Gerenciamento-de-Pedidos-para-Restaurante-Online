import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<ItemMenu> itens;

    public Menu() {
        itens = new ArrayList<>();
        itens.add(new ItemMenu("Entrada 1", "Descrição da entrada", 10.0));
        itens.add(new ItemMenu("Prato Principal 1", "Descrição do prato principal", 25.0));
        itens.add(new ItemMenu("Sobremesa 1", "Descrição da sobremesa", 15.0));
        itens.add(new ItemMenu("Bebida 1", "Descrição da bebida", 5.0));
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void exibirMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + ". " + itens.get(i));
        }
    }
}
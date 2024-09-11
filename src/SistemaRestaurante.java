import java.util.Scanner;

public class SistemaRestaurante {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu();
            Cliente cliente = new Cliente("João", "Rua A, 123", "99999-9999", "joao@gmail.com", "1234");
            
            System.out.println("Bem-vindo ao Sabor Gourmet!");
            
            // Login Simples
            System.out.println("Digite seu email:");
            String email = scanner.nextLine();
            System.out.println("Digite sua senha:");
            String senha = scanner.nextLine();
            
            if (cliente.autenticar(email, senha)) {
                System.out.println("Login bem-sucedido!");
                Carrinho carrinho = new Carrinho();
                
                // Exibir Menu
                menu.exibirMenu();
                
                // Adicionar itens ao carrinho
                System.out.println("Selecione um item (pelo número) para adicionar ao carrinho:");
                int itemSelecionado = scanner.nextInt();
                carrinho.adicionarItem(menu.getItens().get(itemSelecionado - 1));
                
                // Exibir carrinho e revisar pedido
                carrinho.exibirCarrinho();
                
                // Processar pagamento
                Pagamento pagamento = new Pagamento();
                double total = carrinho.getItens().stream().mapToDouble(ItemMenu::getPreco).sum();
                if (pagamento.processarPagamento("Cartão de Crédito", total)) {
                    Pedido pedido = new Pedido(cliente);
                    pedido.adicionarItem(menu.getItens().get(itemSelecionado - 1));
                    pedido.exibirResumo();
                    pedido.setStatus("Em preparação");
                    System.out.println("Status do pedido: " + pedido.getStatus());
                }
            } else {
                System.out.println("Falha no login. Tente novamente.");
            }
        }
    }
}
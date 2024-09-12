import java.util.Scanner;

public class SistemaRestaurante {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu();
            System.out.println("insira um nome");
            String nome = scanner.nextLine();
            System.out.println("insira um endereco");
            String endereco = scanner.nextLine();
            System.out.println("insira um telefone");
            String telefone = scanner.nextLine();
            System.out.println("insira um email");
            String email = scanner.next();
            System.out.println("insira uma senha");
            String senha = scanner.next();

            Cliente cliente = new Cliente(nome, endereco, telefone, email, senha);
            
            
            System.out.println("Bem-vindo ao Sabor Gourmet!");
            
            // Login Simples
            System.out.println("Digite seu email:");
            String email2 = scanner.next();
            System.out.println("Digite sua senha:");
            String senha2 = scanner.next();
    
            
            if (cliente.autenticar(email2, senha2)) {
                System.out.println("Login bem-sucedido!");
                Carrinho carrinho = new Carrinho();
                
                // Exibir Menu
                menu.exibirMenu();
                
                // Adicionar itens ao carrinho
                System.out.println("Selecione um item (pelo numero) para adicionar ao carrinho:");
                int itemSelecionado = scanner.nextInt();
                carrinho.adicionarItem(menu.getItens().get(itemSelecionado - 1));
                
                // Exibir carrinho e revisar pedido
                carrinho.exibirCarrinho();
                
                // Processar pagamento
                Pagamento pagamento = new Pagamento();
                double total = carrinho.getItens().stream().mapToDouble(ItemMenu::getPreco).sum();
                if (pagamento.processarPagamento("Cartao de Credito", total)) {
                    Pedido pedido = new Pedido(cliente);
                    pedido.adicionarItem(menu.getItens().get(itemSelecionado - 1));
                    pedido.exibirResumo();
                    pedido.setStatus("Em preparacao");
                    System.out.println("Status do pedido: " + pedido.getStatus());
                }
            } else {
                System.out.println("Falha no login. Tente novamente.");
            }
        }
    }
}
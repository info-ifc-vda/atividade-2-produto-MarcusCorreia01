public class Produto {
    private String nome;
    private double valor;
    private int quantidadeEmEstoque;

    // Construtor
    public Produto(String nome, double valor, int quantidadeEmEstoque) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Método para exibir os dados do produto
    public void escreverDados() {
        System.out.println("Nome: " + this.nome);
        System.out.printf("Valor unitário: R$ %.2f\n", this.valor);
        System.out.println("Quantidade em estoque: " + this.quantidadeEmEstoque);
    }

    // Método para calcular o valor total em estoque
    public double calcularValorTotal() {
        return this.valor * this.quantidadeEmEstoque;
    }

    // Método para alterar a quantidade em estoque
    public boolean alterarQuantidade(int alteracao) {
        int novaQuantidade = this.quantidadeEmEstoque + alteracao;
        
        if (novaQuantidade < 0) {
            System.out.println("Erro: Quantidade não pode ser negativa.");
            return false;
        }
        
        this.quantidadeEmEstoque = novaQuantidade;
        return true;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando um produto
        Produto produto1 = new Produto("Notebook", 2500.00, 10);

        // Exibindo dados
        System.out.println("=== Dados do Produto ===");
        produto1.escreverDados();

        // Calculando valor total em estoque
        double total = produto1.calcularValorTotal();
        System.out.printf("\nValor total em estoque: R$ %.2f\n", total);

        // Alterando quantidade (+5 unidades)
        System.out.println("\nAdicionando 5 unidades...");
        produto1.alterarQuantidade(5);
        System.out.println("Nova quantidade: " + produto1.getQuantidadeEmEstoque());

        // Tentando remover mais unidades do que existe
        System.out.println("\nTentando remover 20 unidades...");
        boolean sucesso = produto1.alterarQuantidade(-20);
        if (!sucesso) {
            System.out.println("Falha ao alterar quantidade.");
        }

        // Removendo 3 unidades com sucesso
        System.out.println("\nRemovendo 3 unidades...");
        produto1.alterarQuantidade(-3);
        System.out.println("Quantidade final: " + produto1.getQuantidadeEmEstoque());
        
        // Exibindo dados finais
        System.out.println("\n=== Dados Finais do Produto ===");
        produto1.escreverDados();
        total = produto1.calcularValorTotal();
        System.out.printf("Valor total final em estoque: R$ %.2f\n", total);
    }
}
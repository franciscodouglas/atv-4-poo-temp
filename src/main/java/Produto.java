public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto() {
        this.nome = null;
        this.preco = 0.0;
        this.quantidadeEstoque = 0;
    }

    public Produto(String nome, double preco) {
        this.setNome(nome);
        this.setPreco(preco);
        this.quantidadeEstoque = 0;
    }

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.setNome(nome);
        this.setPreco(preco);
        this.setQuantidadeEstoque(quantidadeEstoque);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo.");
        this.preco = preco;
    }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa.");
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int qtd) {
        if (qtd <= 0) throw new IllegalArgumentException("Quantidade a adicionar deve ser positiva.");
        this.quantidadeEstoque += qtd;
    }

    public void removerEstoque(int qtd) {
        if (qtd <= 0) throw new IllegalArgumentException("Quantidade a remover deve ser positiva.");
        if (qtd > this.quantidadeEstoque) throw new IllegalStateException("Estoque insuficiente para remoção.");
        this.quantidadeEstoque -= qtd;
    }

    public double calcularValorTotal() { return this.preco * this.quantidadeEstoque; }

    public String resumo() {
        return String.format("Produto[nome=%s, preco=%.2f, estoque=%d, total=%.2f]",
            this.nome, this.preco, this.quantidadeEstoque, this.calcularValorTotal());
    }
}

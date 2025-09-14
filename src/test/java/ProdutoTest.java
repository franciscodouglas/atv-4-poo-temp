import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Locale;

public class ProdutoTest {

    @Test
    void constructorWithNameAndPrice_initializesCorrectly() {
        Produto p = new Produto("Livro", 30.0);
        assertEquals("Livro", p.getNome());
        assertEquals(30.0, p.getPreco(), 1e-9);
        assertEquals(0, p.getQuantidadeEstoque());
    }

    @Test
    void constructorWithAllArgs_initializesCorrectly() {
        Produto p = new Produto("Mouse", 99.9, 5);
        assertEquals("Mouse", p.getNome());
        assertEquals(99.9, p.getPreco(), 1e-9);
        assertEquals(5, p.getQuantidadeEstoque());
    }

    @Test
    void setPreco_negative_throws() {
        Produto p = new Produto("X", 1.0);
        assertThrows(IllegalArgumentException.class, () -> p.setPreco(-1.0));
    }

    @Test
    void setQuantidadeEstoque_negative_throws() {
        Produto p = new Produto("X", 1.0);
        assertThrows(IllegalArgumentException.class, () -> p.setQuantidadeEstoque(-5));
    }

    @Test
    void adicionarEstoque_and_removerEstoque_workAndValidate() {
        Produto p = new Produto("Caderno", 10.0, 10);
        p.adicionarEstoque(5);
        assertEquals(15, p.getQuantidadeEstoque());

        assertThrows(IllegalArgumentException.class, () -> p.adicionarEstoque(0));
        assertThrows(IllegalArgumentException.class, () -> p.removerEstoque(0));
        assertThrows(IllegalStateException.class, () -> p.removerEstoque(999));

        p.removerEstoque(3);
        assertEquals(12, p.getQuantidadeEstoque());
    }

    @Test
    void calcularValorTotal_ok() {
        Produto p = new Produto("PenDrive", 20.0, 4);
        assertEquals(80.0, p.calcularValorTotal(), 1e-9);
    }

    @Test
    void resumo_containsFormattedValues() {
        Locale.setDefault(Locale.US);
        Produto p = new Produto("Teclado", 100.0, 2);
        String r = p.resumo();
        assertTrue(r.contains("Produto["));
        assertTrue(r.contains("nome=Teclado"));
        assertTrue(r.contains("preco=100.00"));
        assertTrue(r.contains("estoque=2"));
        assertTrue(r.contains("total=200.00"));
    }
}

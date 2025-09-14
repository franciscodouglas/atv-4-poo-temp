import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class MainTest {

    @Test
    void main_runsAndPrintsSummary() {
        Locale.setDefault(Locale.US);
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        try {
            Main.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String out = baos.toString();
        assertTrue(out.contains("Produto["), "Saída deve conter resumo de Produto");
        assertTrue(out.toLowerCase().contains("valor total do estoque"), "Saída deve conter valor total");
    }
}

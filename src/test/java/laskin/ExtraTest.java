package laskin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import Laskin.Laskin;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExtraTest extends AbstractParent {

    private static Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testVirtaON() {
        System.out.println("@BeforeAll Virta ON (ennen ensimmäistä testiä)");
        laskin.virtaON();
    }

    @AfterAll
    public static void testVirtaOFF() {
        System.out.println("@AfterAll Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @BeforeEach
    public void testNollaa() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
        assertEquals(0, laskin.annaTulos(), DELTA , "Nollaus ei onnistunut");
    }

    @ParameterizedTest(name = "Luvun {0} neliö on {1}")
    @CsvSource({ "0, 0", "1, 1", "2, 4", "4, 16", "5, 25", "6, 36" })
    public void testNelio(double luku, double tulos) {
        laskin.nelio(luku);
        assertEquals(tulos, laskin.annaTulos(), DELTA, "Luvun {0} neliöön korotus väärin");
    }
    @ParameterizedTest(name = "Luvun {0} neliöjuuri on {1}")
    @CsvSource({ "0, 0", "1, 1", "4, 2", "9, 3", "16, 4", "25, 5" })
    public void testNeliojuuri2(double luku, double tulos) {
        laskin.neliojuuri(luku);
        assertEquals(tulos, laskin.annaTulos(), DELTA, "Luvun {0} neliöjuuri väärin");
    }

    @Test
    @DisplayName("Testaa negatiivinen neliöjuuri")
    public void testNeliojuuriNegat() {
        ArithmeticException poikkeus = assertThrows(ArithmeticException.class, () -> laskin.neliojuuri(-1));
        assertEquals("Negatiiviselle luvulle ei voi laskea neliöjuurta", poikkeus.getMessage());
    }
}
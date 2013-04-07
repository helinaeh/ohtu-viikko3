package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.1;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVarastonJosTilavuusNolla() {
        varasto = new Varasto(0.0);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVarastonJosTilavuusNeg() {
        varasto = new Varasto(-0.1);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVarastonJosTilavuusPos() {
        varasto = new Varasto(0.1);
        assertEquals(0.0001, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1,1);
        varasto = new Varasto(1,2);
        varasto = new Varasto(-1,2);
        varasto = new Varasto(-1,-1);
        varasto.toString();
    }
    
    @Test
    public void lisaaminenEiToimiJosMaaraNeg() {
        varasto = new Varasto(3, 1);
        varasto.lisaaVarastoon(-2);
        assertEquals(1, varasto.getSaldo(), vertailuTarkkuus);
        //assertEquals(mitäPitäisiOlla, mitäSaadaan, vertailuTarkkuus);
    }
    
    @Test
    public void josLisaysMaaraOnSuurempiKuinTila() {
        varasto = new Varasto(3,1);
        varasto.lisaaVarastoon(10);
        assertEquals(3, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void josLisaysMaaraPienempiKuinTila() {
        varasto = new Varasto(10,4);
        varasto.lisaaVarastoon(2);
        assertEquals(6, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void josLisaysMaaraPienempiKuinTila2() {
        varasto = new Varasto(10,4);
        varasto.lisaaVarastoon(5.9);
        assertEquals(9.9, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void JosLisaysMaaraTayttaaTasanTilan() {
        varasto = new Varasto(10,4);
        varasto.lisaaVarastoon(6);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void JosOttoMaaraOnPienempiKuinNolla() {
        varasto = new Varasto(10,4);
        varasto.otaVarastosta(-5);
        assertEquals(4, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void JosOttoMaaraOnSuurempiKuinSaldo() {
        varasto = new Varasto(10,4);
        varasto.otaVarastosta(7);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void JosOttoPienempiKuinSaldo() {
        varasto = new Varasto(10,5);
        varasto.otaVarastosta(2);
        assertEquals(3, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void JosOttoTasanSaldo() {
        varasto = new Varasto(10,4);
        varasto.otaVarastosta(4);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    //    
//    @Test
//    public void asd() {
//        assertEquals();
//    }
//    
//    @Test
//    public void asd() {
//        assertEquals();
//    }
    //    
//    @Test
//    public void asd() {
//        assertEquals();
//    }
//    
//    @Test
//    public void asd() {
//        assertEquals();
//    }
}
package entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 20/03/2017.
 */
public class MarketOperatorIDTest {
    @Test
    public void getMarketCode() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        assertNotNull(moID);
        Integer x = 238;
        assertEquals(x, moID.getMarketCode());
    }

    @Test
    public void setMarketCode() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        moID.setMarketCode(240);
        Integer x = 240;
        assertNotNull(moID);
        assertEquals(x, moID.getMarketCode());
    }

    @Test
    public void getOperatorCode() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        assertNotNull(moID);
        Integer x = 1;
        assertEquals(x, moID.getOperatorCode());
    }

    @Test
    public void setOperatorCode() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        moID.setOperatorCode(2);
        Integer x = 2;
        assertNotNull(moID);
        assertEquals(x, moID.getOperatorCode());
    }

}
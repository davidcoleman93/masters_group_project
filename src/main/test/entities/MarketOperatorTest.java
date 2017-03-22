package entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 20/03/2017.
 */
public class MarketOperatorTest {
    @Test
    public void getOperatorCode() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        assertNotNull(mOperator);
        Integer x = 238;
        Integer y = 1;
        assertEquals(moID, mOperator.getOperatorCode());
        assertEquals(x, mOperator.getOperatorCode().getMarketCode());
        assertEquals(y, mOperator.getOperatorCode().getOperatorCode());
    }

    @Test
    public void setOperatorCode() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");

        MarketOperatorID moID2 = new MarketOperatorID(240, 2);
        mOperator.setOperatorCode(moID2);
        Integer x = 240;
        Integer y = 2;
        assertNotNull(mOperator);
        assertEquals(moID2, mOperator.getOperatorCode());
        assertEquals(x, mOperator.getOperatorCode().getMarketCode());
        assertEquals(y, mOperator.getOperatorCode().getOperatorCode());
    }

    @Test
    public void getCountry() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        assertNotNull(mOperator);
        String x = "Denmark";
        assertEquals(x, mOperator.getCountry());
    }

    @Test
    public void setCountry() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");

        mOperator.setCountry("Sweden");
        String x = "Sweden";
        assertNotNull(mOperator);
        assertEquals(x, mOperator.getCountry());

    }

    @Test
    public void getOperator() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");
        assertNotNull(mOperator);
        String x = "TDC-DK";
        assertEquals(x, mOperator.getOperator());
    }

    @Test
    public void setOperator() throws Exception {
        MarketOperatorID moID = new MarketOperatorID(238, 1);
        MarketOperator mOperator = new MarketOperator(moID, "Denmark", "TDC-DK");

        mOperator.setOperator("Sonofon DK ");
        String x = "Sonofon DK ";
        assertNotNull(mOperator);
        assertEquals(x, mOperator.getOperator());
    }

}
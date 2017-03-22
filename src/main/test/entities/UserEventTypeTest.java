package entities;

import org.junit.Test;

import javax.xml.registry.infomodel.User;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 20/03/2017.
 */
public class UserEventTypeTest {
    @Test
    public void getTac() throws Exception {
        UserEventType uet = new UserEventType(100100);
        assertNotNull(uet);
        Integer x = 100100;
        assertEquals(x, uet.getTac());
    }

    @Test
    public void setTac() throws Exception {
        UserEventType uet = new UserEventType();
        uet.setTac(100100);
        Integer x = 100100;
        assertNotNull(uet);
        assertEquals(x, uet.getTac());
    }

    @Test
    public void getMarketingName() throws Exception {
        //Integer tac, String marketingName, String manufacturer, String accessCapability, String model, String vendorName, String ueDevice, String operatingSystem, String inputMode
        UserEventType uet = new UserEventType(100100, "G410", "Mitibishi",
                "GSM 1800, GSM 900", "G410", "Mitsubishi",
                "HANDHELD", "testOS", "testInputMode");
        assertNotNull(uet);
        String x = "G410";
        assertEquals(x, uet.getMarketingName());
    }

    @Test
    public void setMarketingName() throws Exception {
        UserEventType uet = new UserEventType();
        //UserEventType uet = new UserEventType(100100, "G410", "Mitibishi",
        //        "GSM 1800, GSM 900", "G410", "Mitsubishi",
        //        "HANDHELD", "testOS", "testInputMode");
        uet.setMarketingName("G412");
        String x = "G412";
        assertNotNull(uet);
        assertEquals(x, uet.getMarketingName());
    }

    @Test
    public void getManufacturer() throws Exception {

    }

    @Test
    public void setManufacturer() throws Exception {

    }

    @Test
    public void getAccessCapability() throws Exception {

    }

    @Test
    public void setAccessCapability() throws Exception {

    }

    @Test
    public void getModel() throws Exception {

    }

    @Test
    public void setModel() throws Exception {

    }

    @Test
    public void getVendorName() throws Exception {

    }

    @Test
    public void setVendorName() throws Exception {

    }

    @Test
    public void getUeDevice() throws Exception {

    }

    @Test
    public void setUeDevice() throws Exception {

    }

    @Test
    public void getOperatingSystem() throws Exception {

    }

    @Test
    public void setOperatingSystem() throws Exception {

    }

    @Test
    public void getInputMode() throws Exception {

    }

    @Test
    public void setInputMode() throws Exception {

    }

}
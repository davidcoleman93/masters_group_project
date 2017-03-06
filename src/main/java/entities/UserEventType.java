package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Entity
@Table(name = "ue_types")
public class UserEventType implements Serializable {

    @Id
    @Column(name = "tac") private Integer tac;

    @Column(name = "marketing_name") private String marketingName;
    @Column(name = "manufacturer") private String manufacturer;
    @Column(name = "access_capability") private String accessCapability;
    @Column(name = "model") private String model;
    @Column(name = "vendor_name") private String vendorName;
    @Column(name = "ue_type") private String ueDevice;
    @Column(name = "os") private String operatingSystem;
    @Column(name = "input_mode") private String inputMode;

    public UserEventType() {
    }

    public UserEventType(Integer tac){
        this.tac = tac;
    }

    public UserEventType(Integer tac, String marketingName, String manufacturer, String accessCapability, String model, String vendorName, String ueDevice, String operatingSystem, String inputMode) {
        this.tac = tac;
        this.marketingName = marketingName;
        this.manufacturer = manufacturer;
        this.accessCapability = accessCapability;
        this.model = model;
        this.vendorName = vendorName;
        this.ueDevice = ueDevice;
        this.operatingSystem = operatingSystem;
        this.inputMode = inputMode;
    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public String getMarketingName() {
        return marketingName;
    }

    public void setMarketingName(String marketingName) {
        this.marketingName = marketingName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getAccessCapability() {
        return accessCapability;
    }

    public void setAccessCapability(String accessCapability) {
        this.accessCapability = accessCapability;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getUeDevice() {
        return ueDevice;
    }

    public void setUeDevice(String ueDevice) {
        this.ueDevice = ueDevice;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getInputMode() {
        return inputMode;
    }

    public void setInputMode(String inputMode) {
        this.inputMode = inputMode;
    }
}

package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Entity
@Table(name = "mcc_mnc")
public class MarketOperator implements Serializable {

	@EmbeddedId
	private MarketOperatorID marketOpID;

	@Column(name = "country")
	private String country;
	@Column(name = "operator")
	private String operator;

	public MarketOperator() {
	}

	public MarketOperator(MarketOperatorID marketOpID) {
		this.marketOpID = marketOpID;
	}

	public MarketOperator(MarketOperatorID marketOpID, String country, String operator) {
		this.marketOpID = marketOpID;
		this.country = country;
		this.operator = operator;
	}

	public MarketOperatorID getOperatorCode() {
		return marketOpID;
	}

	public void setOperatorCode(MarketOperatorID marketOpID) {
		this.marketOpID = marketOpID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}

package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by C06590861 on 16/02/2017.
 */

// @Embeddable allows us to use a composite key as a primary key in the parent
// table

@Embeddable
public class MarketOperatorID implements Serializable {

	@Column(name = "mcc")
	public Integer marketCode;
	@Column(name = "mnc")
	public Integer operatorCode;

	public MarketOperatorID() {
	}

	public MarketOperatorID(Integer marketCode, Integer operatorCode) {

		this.marketCode = marketCode;
		this.operatorCode = operatorCode;

	}

	public Integer getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(Integer marketCode) {
		this.marketCode = marketCode;
	}

	public Integer getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(Integer operatorCode) {
		this.operatorCode = operatorCode;
	}
}

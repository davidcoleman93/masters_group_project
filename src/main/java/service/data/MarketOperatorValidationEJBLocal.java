package service.data;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 28/03/2017.
 */
@Local
public interface MarketOperatorValidationEJBLocal {
    void updateMarketOperator(String fileName);
    Collection<?> allMarketOperators();
}

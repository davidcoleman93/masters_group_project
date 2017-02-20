package dao;

import entities.MarketOperator;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class MarketOperatorDAOImpl implements MarketOperatorDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Collection<?> getAllMarketOperators(){
        return (List<MarketOperator>)em.createQuery("FROM MarketOperator ").getResultList();
    }

}

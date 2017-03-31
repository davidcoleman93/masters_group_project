package dao;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import entities.*;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class MarketOperatorDAOImpl implements MarketOperatorDAOLocal {

    @PersistenceContext
    private EntityManager em;

    public Multimap<Integer, Integer> getMarketOpMap(){
        List<Object[]> temp = (List<Object[]>)
                em.createQuery("SELECT o.marketOpID.marketCode, o.marketOpID.operatorCode FROM MarketOperator o").getResultList();

        Multimap<Integer, Integer> map = ArrayListMultimap.create();
        for(Object[] t : temp) {
            map.put((Integer) t[0], (Integer) t[1]);
        }

        return map;
    }

    public void addMarketOperator(MarketOperator marketOperator){
        em.persist(marketOperator);
    }
}

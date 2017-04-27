package service.data;

import com.google.common.collect.Multimap;
import dao.MarketOperatorDAOLocal;
import dao.UserEventTypeDAOLocal;
import entities.MarketOperator;
import entities.MarketOperatorID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by david on 28/03/2017.
 */

@Local
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MarketOperatorValidationEJB implements MarketOperatorValidationEJBLocal {

    @Inject
    private MarketOperatorDAOLocal marketOperatorBean;

    public void updateMarketOperator(String fileName){
        File temp;
        LineIterator lineIterator = null;

        Multimap<Integer, Integer> marketOperatorMap = null;
        int lineNum = 0;

        //Data types for Market Operator Types
        Integer mcc;
        Integer mnc;
        String country;
        String operator;

        String[] fEvents;

        boolean error;

        try{
            temp = new File(fileName);
            lineIterator = FileUtils.lineIterator(temp, "UTF-8");
        }catch(Exception ioe){
        }

        //Data structure to hold the composite primary keys
        try{
            marketOperatorMap = marketOperatorBean.getMarketOpMap();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING FAILURE CLASS TO MULTIMAP");
        }

        try{
            System.out.println("STARTED");
            while(lineIterator.hasNext()){
                fEvents = lineIterator.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(lineNum == 0){
                    lineNum++;
                }else{
                    mcc = null;
                    mnc = null;
                    country = null;
                    operator = null;

                    error = false;

                    try{
                        mcc = Integer.parseInt(fEvents[0]);
                        mnc = Integer.parseInt(fEvents[1]);
                    }catch (Exception e) {
                        if(!error) error = true;
                    }
                    if(!marketOperatorMap.containsEntry(mcc, mnc) && !error){
                        try{
                            country = fEvents[2];
                        }catch (Exception e){
                            if(!error) error = true;
                        }
                        try {
                            operator = fEvents[3];
                        }catch (Exception e){
                            if(!error) error = true;
                        }
                        if(!error){
                            marketOperatorBean.addMarketOperator(
                                    new MarketOperator(
                                            new MarketOperatorID(
                                                    mcc,
                                                    mnc
                                            ),
                                            country,
                                            operator
                                    )
                            );
                        }
                    }
                }
            }
        }finally {
            LineIterator.closeQuietly(lineIterator);
        }
        System.out.println("COMPLETED");
    }

    public Collection<?> allMarketOperators(){
        return marketOperatorBean.allMarketOperators();
    }
}

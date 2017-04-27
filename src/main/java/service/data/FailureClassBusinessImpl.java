package service.data;

import dao.FailureClassDAOLocal;
import dao.UserEventTypeDAOLocal;
import entities.FailureClass;
import entities.UserEventType;
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
public class FailureClassBusinessImpl implements FailureClassBusinessLocal {

    @Inject
    private FailureClassDAOLocal failureClassBean;

    public void updateFailureClasses(String fileName){
        File temp;
        LineIterator lineIterator = null;

        HashSet<Integer> failureClassSet = null;
        int lineNum = 0;

        //Data types for User Event Types
        Integer failureClass;
        String description;

        String[] failureClasses;

        boolean error;

        try{
            temp = new File(fileName);
            lineIterator = FileUtils.lineIterator(temp, "UTF-8");
        }catch(Exception ioe){
        }

        //Data structure to hold the primary keys
        try{
            failureClassSet = failureClassBean.getFailureClassSet();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING FAILURE CLASS TO MULTIMAP");
        }

        try{
            System.out.println("STARTED");
            while(lineIterator.hasNext()){
                failureClasses = lineIterator.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(lineNum == 0){
                    lineNum++;
                }else{
                    failureClass = null;
                    description = null;

                    error = false;

                    try{
                        failureClass = Integer.parseInt(failureClasses[0]);
                    }catch (Exception e) {
                        if(!error) error = true;
                    }
                    if(!failureClassSet.contains(failureClass) && !error){
                        try{
                            description = failureClasses[1];
                        }catch (Exception e){
                            if(!error) error = true;
                        }

                        if(!error){
                            failureClassBean.addFailureClass(
                                    new FailureClass(
                                            failureClass,
                                            description
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

    public Collection<?> allFailureClasses(){
        return failureClassBean.allFailureClasses();
    }
}

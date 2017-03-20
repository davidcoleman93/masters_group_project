package service.data;

import dao.FailureClassDAOLocal;
import entities.FailureClass;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
@Stateless
public class FailureClassBusinessImpl implements FailureClassBusinessLocal {

    @Inject
    private FailureClassDAOLocal daoBean;

    @Resource
    private SessionContext session;

    public void updateFailureClasses(String fileName){
        File temp;
        LineIterator lineIterator = null;

        HashSet<Integer> failureMap = null;
        int lineNum = 0;

        try{
            temp = new File(fileName);
            lineIterator = FileUtils.lineIterator(temp, "UTF-8");
        }catch(Exception ioe){
        }

        try{
            failureMap = daoBean.getFailureClassSet();
        }catch (Exception e){
            System.out.println("ERROR IN PARSING FAILURE CLASS TO MULTIMAP");
        }

        try{
            System.out.println("STARTED");
            while(lineIterator.hasNext()){
                String line = lineIterator.nextLine();

                if(!line.equals("")){
                    if(lineNum == 0){
                        lineNum++;
                    }else{
                        lineNum++;
                        String[] fEvents = line.split(",");
                        Integer failureClass = -1;
                        String desc = "";
                        try{
                            failureClass = Integer.parseInt(fEvents[0]);
                            try{
                                desc = fEvents[1];
                            }catch (Exception e){
                            }
                        }catch (Exception e) {
                        }
                        System.out.println(failureClass + "," + desc);
                        if(!failureMap.contains(failureClass)){
                            daoBean.addFailureClass(new FailureClass(failureClass, desc));
                        }
                    }
                }

            }

        }finally {
            LineIterator.closeQuietly(lineIterator);
        }
        System.out.println("COMPLETED");
    }

}

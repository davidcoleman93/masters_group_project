package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c11456862 on 15/03/2017.
 */
public class FailureClassTest {

    @Test
    public void getFailureClass() throws Exception {
        FailureClass fClass = new FailureClass(0, "test description");
        assertNotNull(fClass);
        Integer x = 0;
        assertEquals(x, fClass.getFailureClass());
    }

    @Test
    public void getFailureClassWhenNotSet() throws Exception {
        FailureClass fClass = new FailureClass();
        assertNotNull(fClass);
        Integer x = null;
        assertEquals(x, fClass.getFailureClass());
    }


    @Test
    public void setFailureClassWhenNotSet() throws Exception {
        FailureClass fClass = new FailureClass();
        fClass.setFailureClass(0);
        Integer x = 0;
        assertNotNull(fClass);
        assertEquals(x, fClass.getFailureClass());
    }

    @Test
    public void setFailureClassToUpdateIt() throws Exception {
        FailureClass fClass = new FailureClass(0, "test description");
        fClass.setFailureClass(1);
        Integer x = 1;
        assertNotNull(fClass);
        assertEquals(x, fClass.getFailureClass());
    }

    @Test
    public void getDescription() throws Exception {
        FailureClass fClass = new FailureClass(0, "test description 2");
        assertNotNull(fClass);
        String desc = "test description 2";
        assertEquals(desc, fClass.getDescription());
    }

    @Test
    public void getDescriptionWhenNotSet() throws Exception {
        FailureClass fClass = new FailureClass();
        assertNotNull(fClass);
        String desc = null;
        assertEquals(desc, fClass.getDescription());
    }

    @Test
    public void setDescriptionWhenNotSet() throws Exception {
        FailureClass fClass = new FailureClass();
        fClass.setDescription("test description 3");
        String desc = "test description 3";
        assertNotNull(fClass);
        assertEquals(desc, fClass.getDescription());
    }

    @Test
    public void setDescriptionToUpdate() throws Exception {
        FailureClass fClass = new FailureClass(0, "test description 4");
        fClass.setDescription("test description 5");
        String desc = "test description 5";
        assertNotNull(fClass);
        assertEquals(desc, fClass.getDescription());
    }

}
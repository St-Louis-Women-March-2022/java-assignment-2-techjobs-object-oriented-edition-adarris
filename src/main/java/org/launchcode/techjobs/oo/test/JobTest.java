package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job object_1 = new Job();
        Job object_2 = new Job();
        assertNotEquals(object_1.getId(), object_2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job object_3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(object_3.getName() instanceof String);
        //System.out.println(object_3.getName().getClass());
        assertTrue(object_3.getEmployer() instanceof Employer);
        assertTrue(object_3.getLocation() instanceof Location);
        assertTrue(object_3.getPositionType() instanceof PositionType);
        assertTrue(object_3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(object_3.getName(), "Product tester");
        assertEquals(object_3.getEmployer().toString(), "ACME");
        assertEquals(object_3.getLocation().toString(), "Desert");
        assertEquals(object_3.getPositionType().toString(), "Quality control");
        assertEquals(object_3.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job object_4 = new Job("Java Developer", new Employer("ADARRIS"), new Location("St. Louis"), new PositionType("Web developer"), new CoreCompetency("uhhhh"));
        Job object_5 = new Job("Java Developer", new Employer("ADARRIS"), new Location("St. Louis"), new PositionType("Web developer"), new CoreCompetency("uhhhh"));

        assertFalse(object_4.equals(object_5));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job object_6 = new Job();
        assertEquals('\n', object_6.toString().charAt(0));
        assertEquals('\n', object_6.toString().charAt(object_6.toString().length() -1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job object_7 = new Job("Java Developer", new Employer("ADARRIS"), new Location("St. Louis"), new PositionType("Web developer"), new CoreCompetency("uhhhh"));
        assertEquals("\nID: "+object_7.getId()+"\nName: Java Developer\nEmployer: ADARRIS\nLocation: St. Louis\nPosition Type: Web developer\nCore Competency: uhhhh\n", object_7.toString());
        //assertTrue(object_7.toString().contains("Employer: ADARRIS"));
        //assertTrue(object_7.toString().contains("Location: St. Louis"));
        //assertTrue(object_7.toString().contains("Position Type: Web developer"));
        //assertTrue(object_7.toString().contains("Core Competency: uhhhh"));
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job object_8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: "+object_8.getId()+"\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", object_8.toString());
        //assertTrue(object_8.toString().contains("Employer: Data not available"));
        //assertTrue(object_8.toString().contains("Location: Data not available"));
        //assertTrue(object_8.toString().contains("Position Type: Data not available"));
        //assertTrue(object_8.toString().contains("Core Competency: Data not available"));
    }
}

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
        System.out.println(object_3.getName().getClass());
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

        assertFalse(object_4.getId() == object_5.getId());
    }
}

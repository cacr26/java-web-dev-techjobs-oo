package org.launchcode.techjobs_oo.Tests;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Job;
import org.junit.Before;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.Location;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;

    @Before
    public void createJobTestObject(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job5 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId () {
    assertEquals(1 ,job2.getId()-job1.getId(), .0001);
    }

    @Test
    public void testJobContructorSetsAllFields(){
        assertTrue(job3 instanceof Job);
        assertTrue(job3.getName() == "Product tester");
        assertTrue(job3.getEmployer().getValue() == "ACME");
        assertTrue(job3.getLocation().getValue() == "Desert");
        assertTrue(job3.getPositionType().getValue() == "Quality control");
        assertTrue(job3.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job3.equals(job4));
        }

    @Test
    public void testToString(){
        assertTrue(job3.toString().startsWith("\n"));
        assertTrue(job3.toString().endsWith(("\n")));
    }
    @Test
    public void testDataNotAvailable() {
        assertTrue(job5.toString().contains("Data not available"));
    }
}
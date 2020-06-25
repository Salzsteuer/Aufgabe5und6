package de.hfu.residents.service;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.*;
import java.util.*;

@RunWith( Parameterized.class)
public class BaseResidentServiceTest {
	
    private Resident resident1;
    private Resident resident2;
    private Resident resident3;


    private DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private ResidentRepositoryStub residentRepositoryStub;



    public BaseResidentServiceTest(String[] resident1, String[] resident2, String[] resident3) throws ParseException
    	{
    	
        this.resident1 = new Resident(resident1[0], resident1[1], resident1[2], resident1[3], format.parse(resident1[4]));
        this.resident2 = new Resident(resident2[0], resident2[1], resident2[2], resident2[3], format.parse(resident2[4]));
        this.resident3 = new Resident(resident3[0], resident3[1], resident3[2], resident3[3], format.parse(resident3[4]));
        List<Resident> residents = Arrays.asList(this.resident1, this.resident2, this.resident3);
        this.residentRepositoryStub = new ResidentRepositoryStub(residents);
    }

    @Parameterized.Parameters
    public static Collection daten() {
        return Arrays.asList(new String[][][] {
            {{"Fabian", "Bozic", "Doner", "Fuwa", "01-01-1990"},
            {"Juan", "Tabuena", "Berg", "Fuwa", "01-01-1994"},
            {"Matze", "Schulz", "Ghb", "Fuwa", "29-02-1993"}}
        });
    }

    
    @Test
    public void testGetUniqueResident() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Fabian", "Bozic", "Doner", "Fuwa", format.parse("01-01-1990"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
    
    

    @Test
    public void testGetUniqueResident1() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Juan", "Tabuena", "Berg", "Fuwa", format.parse("01-01-1994"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
    
    @Test
    public void testGetUniqueResident2() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Matze", "Schulz", "Ghb", "Fuwa", format.parse("29-02-1993"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
    
    

    @Test
    public void testGetFilteredResidentsList() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("", "Bozic", "", "", null);
        Assert.assertEquals(Arrays.asList(resident1), baseResidentService.getFilteredResidentsList(resident));
    }

    
    @Test
    public void testGetFilteredResidentsList1() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("", "Tabuena", "", "", null);
        Assert.assertEquals(Arrays.asList(resident2), baseResidentService.getFilteredResidentsList(resident));
    }
  
    
    
    @Test
    public void testGetFilteredResidentsList2() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("", "Schulz", "", "Fuwa", null);
        Assert.assertEquals(Arrays.asList(resident3), baseResidentService.getFilteredResidentsList(resident));
    }
    
} 
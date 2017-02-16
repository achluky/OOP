
import javafx.scene.shape.Sphere;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sphere.Exception.InvalidRadiusException;
import sphere.SphereUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class SphereTest 
{
    @BeforeClass
    public static void prepare()
    {
        System.out.println("memulai Test");
    }
    @Before
    public void preparedTest()
    {
        System.out.println("Memulai test");
    }
    @Test
    public void testSetRadiusRusukPositif() throws InvalidRadiusException
    {
        SphereUnit sphere =  new SphereUnit();
        sphere.setRadius(10);
    }
    @Test(expected = InvalidRadiusException.class)
    public void testSetRadiusRusukNegatif() throws InvalidRadiusException
    {
        SphereUnit sphere =  new SphereUnit();
        sphere.setRadius(-10);
    }
    @Test(timeout = 1000)
    public void testSetRadiusDenganBatasWaktu() throws InvalidRadiusException
    {
        SphereUnit sphere =  new SphereUnit();
        sphere.setRadius(1000);
    }
    @Test
    public void testGetVolumeSphere() throws InvalidRadiusException
    {
        SphereUnit sphere =  new SphereUnit();
        sphere.setRadius(10);
        assertEquals("Error, hasil getVolume tidak sesuai",4082,sphere.getDiameter());
    }
    @After
    public void testSelesaiDilakukan()
    {
        System.out.println("testSelesai Dilakukan");
    }
    @AfterClass
    public static void Akhir()
    {
        System.out.println("Akhir dari test");
    }
}

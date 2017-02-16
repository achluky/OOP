package kubus;

import java.io.IOException;
import kubus.controller.KubusController;
import kubus.model.Kubus;
import kubus.view.KubusViewConsole;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    public static void main(String[] args) throws IOException 
    {
        Kubus kubus = new Kubus(1000);
        
        KubusViewConsole view =  new KubusViewConsole();
        KubusController controller = new KubusController(kubus,view);
        while(true)
        {
            controller.mintaDuluRusuk();
        }
    }
    
}

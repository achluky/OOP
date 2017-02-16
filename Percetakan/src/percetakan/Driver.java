package percetakan;

/**
 *
 * @author Jayuk
 */
public class Driver
{
    public static void main(String[] args)
    {
        MesinFactory mesinfactory = new MesinFactory();
        Printer printer1 = (Printer) mesinfactory.getMesin("HP deksjet", "Hanya printer yang rendah hati", 20);
        printData(printer1);
        
        //Pembuatan anynomous Class
        Printable printerPDF = new Printable()
        {
            @Override
            public void cetakDokumen() 
            {
                System.out.println("Dokumen dicetak dalam fomat PDF");
                System.out.println("Ketuhanan yang maha esa");
            }
        };
        printerPDF.cetakDokumen();
                
    }
    
    public static void printData(Mesin mesin)
    {
        if(mesin instanceof Printer)
            ((Printer) mesin).cetakDokumen();
        else if(mesin instanceof Fotokopi)
            ((Fotokopi) mesin).cetakDokumen();
        else
            System.out.println("Objek yang ente masukkan tidak cocok");
    }
}

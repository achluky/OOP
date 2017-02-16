package ai.game.puzzle.core;

public class ManipulasiString
{
    private String[] data;
    private int baris;
    private int kolom;
    private int position;
    ManipulasiString(String data)
    {
        this.data = data.split(",");
        this.setPosition();
        this.setBaris();
        this.setKolom();
    }
    public String[] getData()
    {
        return this.data;
    }
    public void setPosition()
    {
        for (int i = 0; i < data.length; i++) 
        {
            if(data[i].matches("0") )
            {
                this.position = i;
                break;
            }
        }
    }
    public int getPosition()
    {
        return this.position;
    }
    public void setBaris()
    {
        this.baris = (int) (this.getPosition()/Math.sqrt(data.length));
    }
    public int getBaris()
    {
        return baris;
    }
    public void setKolom()
    {
        this.kolom = (int) (this.getPosition()%Math.sqrt(data.length));
    }
    public int getKolom()
    {
        return this.kolom;
    }
    public String getLeftSide()
    {
        if(this.getKolom()-1 >= 0)
        {
            return this.data[this.getPosition()-1];
        }
        return null;
    }
    public String getRightSide()
    {
        if(this.getKolom()+1 < Math.sqrt(this.data.length ))
        {
            return this.data[this.getPosition()+1];
        }
        return null;
    }
    public String getUpSide()
    {
        if(this.getBaris()-1 >= 0)
        {
            return this.data[this.getPosition() - (int)Math.sqrt(this.data.length)];
        }
        return null;
    }
    public String getBotSide()
    {
        if(this.getBaris() + 1 < (int)Math.sqrt(this.data.length) )
        {
            return this.data[this.getPosition() + (int)Math.sqrt(this.data.length)];
        }
        return null;
 } 
}
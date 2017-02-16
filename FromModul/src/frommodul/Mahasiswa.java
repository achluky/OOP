package frommodul;

/**
 *
 * @author Jayuk
 */
public class Mahasiswa extends Manusia
{
private String nim;
public Mahasiswa()
{
}
public Mahasiswa(String nim)
{
this.nim = nim;
}
public String getNim()
{
return nim;
}
public void setNim(String nim)
{
this.nim = nim;
}
public String toString()
{
return "MHS NIM :" + nim;
}
}

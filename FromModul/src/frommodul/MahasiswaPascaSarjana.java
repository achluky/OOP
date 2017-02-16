package frommodul;

/**
 *
 * @author Jayuk
 */
public class MahasiswaPascaSarjana extends Mahasiswa
{
private String judulTHesis;
public MahasiswaPascaSarjana()
{
}
public MahasiswaPascaSarjana(String judulTHesis)
{
this.judulTHesis = judulTHesis;
}
public MahasiswaPascaSarjana(String judulTHesis, String nim)
{
super(nim);
this.judulTHesis = judulTHesis;
}
public String getJudulTHesis()
{
return judulTHesis;
}
public void setJudulTHesis(String judulTHesis)
{
this.judulTHesis = judulTHesis;
}
}

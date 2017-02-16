package frommodul;

/**
 *
 * @author Jayuk
 */
public abstract class Manusia
{
private String nama;
private char jenisKelamin;
public Manusia(String nama, char jenisKelamin)
{
this.nama = nama;
this.jenisKelamin = jenisKelamin;
}
public Manusia()
{
}
public String getNama()
{
return nama;
}
public void setNama(String nama)
{
this.nama = nama;
}
public char getJenisKelamin()
{
return jenisKelamin;
}
public void setJenisKelamin(char jenisKelamin)
{
this.jenisKelamin = jenisKelamin;
}
}

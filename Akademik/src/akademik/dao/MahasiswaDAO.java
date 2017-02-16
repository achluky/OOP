package akademik.dao;


import akademik.model.Kelas;
import akademik.model.Mahasiswa;
import akademik.util.DBUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jayuk
 */
public class MahasiswaDAO
{
    private Connection connection;
    
    public MahasiswaDAO() throws SQLException, IOException
    {
        connection = DBUtil.getConnection();
    }
    
    public void addMahasiswa(Mahasiswa mahasiswa) throws SQLException
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MAHASISWA(nim,nama,indeksPrestasi,idKelas) values(?,?,?,?)");
            preparedStatement.setString(1 ,mahasiswa.getNim());
            preparedStatement.setString(2 ,mahasiswa.getNama());
            preparedStatement.setDouble(3 ,mahasiswa.getIndeksPrestasi());
            preparedStatement.setInt(4, mahasiswa.getKelas().getId());
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void deleteMahasiswa(String nim) throws SQLException
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MAHASISWA WHERE nim="+nim);
            //preparedStatement.setString(1, nim);
            preparedStatement.executeUpdate();
            //connection.commit();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void updateMahasiswa(Mahasiswa mahasiswa) throws SQLException
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MAHASISWA SET nim=?, nama=?, indeksPrestasi=?, idKelas=? WHERE nim=?");
            preparedStatement.setString(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setDouble(3, mahasiswa.getIndeksPrestasi());
            preparedStatement.setInt(4, mahasiswa.getKelas().getId());
            preparedStatement.setString(5, mahasiswa.getNim());
            preparedStatement.executeQuery();
            connection.commit();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public List<Mahasiswa> getAllMahasiswa()
    {
    List<Mahasiswa> mahasiswas = new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT a.nim, a.nama, a.indeksPrestasi, a.idKelas, b.nama FROM MAHASISWA a, kelas b WHERE a.idKelas = b.id");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
            String nim=rs.getString(1);
            String nama=rs.getString(2);
            double ip = rs.getDouble(3);
            int idKelas =  rs.getInt(4);
            String namaKelas = rs.getString(5);
            Mahasiswa m = new Mahasiswa(nim,nama,ip,new Kelas(idKelas,namaKelas));
            mahasiswas.add(m);
            }
            connection.commit();
            rs.close();
            preparedStatement.close();
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        }
        return mahasiswas;
    }
    public Mahasiswa getMahasiswaByNim(String nim)
    {
        Mahasiswa mahasiswa =  null;
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.nim, m.nama,m.indeksPrestasi,m.idKelas,k.nama FROM MAHASISWA as m , Kelas as k where m.idKelas =k.id and m.nim="+nim+" limit 1");
            //preparedStatement.setString(1, nim);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                String nimBaru = rs.getString(1);
                String nama = rs.getString(2);
                double ip = rs.getDouble(3);
                int idKelas =  rs.getInt(4);
                String namaKelas = rs.getString(5);
                mahasiswa = new Mahasiswa(nimBaru,nama,ip,new Kelas(idKelas,namaKelas));
            }
            connection.commit();
            rs.close();
            preparedStatement.close();
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return mahasiswa;
    }
}

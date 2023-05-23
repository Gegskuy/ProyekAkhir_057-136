/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class datakasirDAO implements datakasirimplement{
    Connection connection;
    
    final String select = "SELECT * FROM kasir";
    final String insert = "INSERT INTO kasir (nama_kasir, no_telp_kasir, alamat_kasir) VALUES (?, ?, ?);";
    final String update = "update kasir set nama_kasir=?, no_telp_kasir=?, alamat_kasir=? where id_kasir=?";
    final String delete = "delete from kasir where id_kasir=?";
    
    public datakasirDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datakasir dksr) {
        PreparedStatement statement = null;
        try{
           statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, dksr.getNama_kasir());
           statement.setString(2, dksr.getNo_telp_kasir());
           statement.setString(3, dksr.getAlamat_kasir());
           statement.executeUpdate();
           ResultSet rs = statement.getGeneratedKeys();
           while(rs.next()) {
               dksr.setId_kasir(rs.getInt(1));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datakasir dksr) {
        PreparedStatement statement = null;
        try{
           statement = connection.prepareStatement(update);
           statement.setString(1, dksr.getNama_kasir());
           statement.setString(2, dksr.getNo_telp_kasir());
           statement.setString(3, dksr.getAlamat_kasir());
           statement.setInt(4, dksr.getId_kasir());
           statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int idksr) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, idksr);
            statement.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datakasir> getALL() {
        List<datakasir> dkasir = null;
        try{
            dkasir = new ArrayList<datakasir>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datakasir ksr = new datakasir();
                ksr.setId_kasir(rs.getInt("id_kasir"));
                ksr.setNama_kasir(rs.getString("nama_kasir"));
                ksr.setNo_telp_kasir(rs.getString("no_telp_kasir"));
                ksr.setAlamat_kasir(rs.getString("alamat_kasir"));
                dkasir.add(ksr);
            }
        }catch(SQLException ex){
            Logger.getLogger(datakasirDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dkasir;
    }
    
    
    
}

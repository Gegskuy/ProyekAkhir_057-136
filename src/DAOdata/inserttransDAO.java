/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.inserttransimplement;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author ASUS
 */
public class inserttransDAO implements inserttransimplement{
    Connection connection;
    
    final String select = "SELECT * FROM transaksi JOIN makanan ON transaksi.id_makanan = makanan.id_makanan JOIN minuman ON transaksi.id_minuman = minuman.id_minuman;";
    final String insert = "INSERT INTO `transaksi` (atas_nama, tanggal, id_makanan, jml_mkn, id_minuman, jml_mnm, total_harga) VALUES (?, current_timestamp(), ?, ?, ?, ?, ?);";
    
    public inserttransDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(inserttrans itrns) {
        PreparedStatement statement = null;
        try{
           statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, itrns.getAtas_nama());
           statement.setString(2, itrns.getTanggal());
           statement.setString(3, itrns.getNama_makanan());
           statement.setInt(4, itrns.getHarga_makanan());
           statement.setInt(5, itrns.getJml_mkn());
           statement.setString(6, itrns.getNama_minuman());
           statement.setInt(7, itrns.getHarga_minuman());
           statement.setInt(8, itrns.getJml_mnm());
           statement.setInt(9, itrns.getTotal_harga());
           statement.executeUpdate();
           ResultSet rs = statement.getGeneratedKeys();
           while(rs.next()) {
               itrns.setId_transaksi(rs.getInt(1));
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
    public List<inserttrans> getALL() {
        List<inserttrans>  itrans= null;
        try{
            itrans = new ArrayList<inserttrans>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                inserttrans it = new inserttrans();
                it.setId_transaksi(rs.getInt("id_transaksi"));
                it.setAtas_nama(rs.getString("atas_nama"));
                it.setTanggal(rs.getString("tanggal"));
                it.setNama_makanan(rs.getString("nama_makanan"));
                it.setHarga_makanan(rs.getInt("harga_makanan"));
                it.setJml_mkn(rs.getInt("jml_mkn"));
                it.setNama_minuman(rs.getString("nama_minuman"));
                it.setHarga_minuman(rs.getInt("harga_minuman"));
                it.setJml_mnm(rs.getInt("jml_mnm"));
                it.setTotal_harga(rs.getInt("total_harga"));
                itrans.add(it);
            }
        }catch(SQLException ex){
            Logger.getLogger(inserttransDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return itrans;
    }

    
}

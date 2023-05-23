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
public class transaksiDAO implements transaksiimplement{
    Connection connection;
    
    final String select = "SELECT * FROM transaksi JOIN makanan ON "
            + "transaksi.id_makanan = makanan.id_makanan JOIN minuman on transaksi.id_minuman = minuman.id_minuman";
    final String insert = "INSERT INTO `transaksi` (atas_nama, tanggal, id_makanan, jml_mkn, id_minuman, jml_mnm, total_harga)"
            + " VALUES (?, current_timestamp(), ?, ?, ?, ?, ?);";
    
    public transaksiDAO(){
        connection =  connector.connection();
    }

    @Override
    public void insert(transaksi trns) {
        PreparedStatement statement = null;
        try{
           statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, trns.getAtas_nama());
           statement.setString(2, trns.getTanggal());
           statement.setString(3, trns.getNama_makanan());
           statement.setInt(4, trns.getHarga_makanan());
           statement.setInt(5, trns.getJml_mkn());
           statement.setString(6, trns.getNama_minuman());
           statement.setInt(7, trns.getHarga_minuman());
           statement.setInt(8, trns.getJml_mnm());
           statement.setInt(9, trns.getTotal_harga());
           statement.executeUpdate();
           ResultSet rs = statement.getGeneratedKeys();
           while(rs.next()) {
               trns.setId_transaksi(rs.getInt(1));
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
    public void update(transaksi trns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int idtrans) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<transaksi> getALL() {
        List<transaksi>  trans= null;
        try{
            trans = new ArrayList<transaksi>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                transaksi t = new transaksi();
                t.setId_transaksi(rs.getInt("id_transaksi"));
                t.setAtas_nama(rs.getString("atas_nama"));
                t.setTanggal(rs.getString("tanggal"));
                t.setNama_makanan(rs.getString("nama_makanan"));
                t.setHarga_makanan(rs.getInt("harga_makanan"));
                t.setJml_mkn(rs.getInt("jml_mkn"));
                t.setNama_minuman(rs.getString("nama_minuman"));
                t.setHarga_minuman(rs.getInt("harga_minuman"));
                t.setJml_mnm(rs.getInt("jml_mnm"));
                t.setTotal_harga(rs.getInt("total_harga"));
                trans.add(t);
            }
        }catch(SQLException ex){
            Logger.getLogger(datamakananDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return trans;
    }
    
}

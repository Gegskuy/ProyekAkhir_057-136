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
public class datamakananDAO implements datamakananimplement{
    Connection connection;
    
    final String select = "SELECT * FROM makanan";
    final String insert = "INSERT INTO `transaksi` (atas_nama, tanggal, id_makanan, jml_mkn, id_minuman, jml_mnm, total_harga) VALUES (?, current_timestamp(), ?, ?, ?, ?, ?);";
    
    public datamakananDAO(){
        connection =  connector.connection();
        
    }

    @Override
    public void insert(datamakanan dmkn) {
        
    }

    @Override
    public void update(datamakanan dmkn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int idmkn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<datamakanan> getALL() {
        List<datamakanan> dmakan = null;
        try{
            dmakan = new ArrayList<datamakanan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datamakanan mkn = new datamakanan();
                mkn.setId_makanan(rs.getInt("id_makanan"));
                mkn.setNama_makanan(rs.getString("nama_makanan"));
                mkn.setHarga_makanan(rs.getInt("harga_makanan"));
                dmakan.add(mkn);
            }
        }catch(SQLException ex){
            Logger.getLogger(datamakananDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dmakan;
    }
}

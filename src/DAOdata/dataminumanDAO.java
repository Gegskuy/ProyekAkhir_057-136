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
public class dataminumanDAO implements dataminumanimplement{
    Connection connection;
    
    final String select = "SELECT * FROM minuman";
    final String insert = "INSERT INTO `transaksi` (atas_nama, tanggal, id_makanan, jml_mkn, id_minuman, jml_mnm, total_harga) VALUES (?, current_timestamp(), ?, ?, ?, ?, ?);";
    
    public dataminumanDAO(){
        connection =  connector.connection();
        
    }

    @Override
    public void insert(dataminuman dmnn) {
        
    }

    @Override
    public void update(dataminuman dmnn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int idmnn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<dataminuman> getALL() {
        List<dataminuman> dminum = null;
        try{
            dminum = new ArrayList<dataminuman>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataminuman mnn = new dataminuman();
                mnn.setId_minuman(rs.getInt("id_minuman"));
                mnn.setNama_minuman(rs.getString("nama_minuman"));
                mnn.setHarga_minuman(rs.getInt("harga_minuman"));
                dminum.add(mnn);
            }
        }catch(SQLException ex){
            Logger.getLogger(dataminumanDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dminum;
    }
    
    
    
}

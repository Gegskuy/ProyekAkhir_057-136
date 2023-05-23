/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.transaksiDAO;
import DAOimplement.transaksiimplement;
import model.*;
import restaurant.laporan;
/**
 *
 * @author ASUS
 */
public class transaksicontroller {
    laporan frame;
    transaksiimplement impltrans;
    List<transaksi> trans;
    
    public transaksicontroller(laporan frame) {
        this.frame = frame;
        impltrans = new transaksiDAO();
        trans = impltrans.getALL();
    }
    
    public void isitabel(){
        trans = impltrans.getALL();
        modeltransaksi modtrans = new modeltransaksi(trans);
        frame.getTabelTrans().setModel(modtrans);
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.inserttransDAO;
import DAOimplement.inserttransimplement;
import model.*;
import restaurant.menu2;
/**
 *
 * @author ASUS
 */
public class inserttranscontroller {
    menu2 frame;
    inserttransimplement itrnsimp;
    List<inserttrans> itrans;
    
    public inserttranscontroller(menu2 frame){
        this.frame = frame;
        itrnsimp = new inserttransDAO();
        itrans = itrnsimp.getALL();
    }
    
    
    public void insert(){
        inserttrans itrans = new inserttrans();
        itrans.setAtas_nama(frame.getAtasNama().getText());
        itrans.setNama_makanan(frame.getNamaMakanan().getText());
        itrans.setHarga_makanan(Integer.parseInt(frame.getHargaMakanan().getText()));
        itrans.setJml_mkn(Integer.parseInt(frame.getJml_mkn().getText()));
        itrans.setNama_minuman(frame.getNamaMinuman().getText());
        itrans.setHarga_minuman(Integer.parseInt(frame.getHargaMinuman().getText()));
        itrans.setJml_mnm(Integer.parseInt(frame.getJml_mnm().getText()));
        itrans.setTotal_harga(0);
        
        itrnsimp.insert(itrans);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.datakasirDAO;
import DAOimplement.datakasirimplement;
import model.*;
import restaurant.hal_admin;
/**
 *
 * @author ASUS
 */
public class datakasircontroller {
    hal_admin frame;
    datakasirimplement impldatakasir;
    List<datakasir> dkasir;
    
    public datakasircontroller(hal_admin frame){
        this.frame = frame;
        impldatakasir = new datakasirDAO();
        dkasir = impldatakasir.getALL();
    }
    
    public void isitabel(){
        dkasir = impldatakasir.getALL();
        modeltabeldatakasir mtdksr = new modeltabeldatakasir(dkasir);
        frame.getTabelKaryawan().setModel(mtdksr);
    }
    
    public void insert(){
        datakasir dkasir = new datakasir();
        dkasir.setNama_kasir(frame.getNamaKaryawan().getText());
        dkasir.setNo_telp_kasir(frame.getTelponKaryawan().getText());
        dkasir.setAlamat_kasir(frame.getAlamatKaryawan().getText());
        impldatakasir.insert(dkasir);
    }
    
    public void update(){
        datakasir dkasir = new datakasir();
        dkasir.setNama_kasir(frame.getNamaKaryawan().getText());
        dkasir.setNo_telp_kasir(frame.getTelponKaryawan().getText());
        dkasir.setAlamat_kasir(frame.getAlamatKaryawan().getText());
        dkasir.setId_kasir(Integer.parseInt(frame.getIdKaryawan().getText()));
        impldatakasir.update(dkasir);
    }
    
    public void delete(){
        int idksr = Integer.parseInt(frame.getIdKaryawan().getText());
        impldatakasir.delete(idksr);
    }
}

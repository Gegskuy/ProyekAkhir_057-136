/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.datamakananDAO;
import DAOimplement.datamakananimplement;
import model.*;
import restaurant.menu2;
/**
 *
 * @author ASUS
 */
public class datamakanancontroller {
    menu2 frame;
    datamakananimplement impldatamakan;
    List<datamakanan> dmakan;
    
    public datamakanancontroller(menu2 frame){
        this.frame = frame;
        impldatamakan = new datamakananDAO();
        dmakan = impldatamakan.getALL();
    }
    public void isitabel(){
        dmakan = impldatamakan.getALL();
        modeltabeldatamakanan mtdmkn= new modeltabeldatamakanan(dmakan);
        frame.getTabelMakanan().setModel(mtdmkn);
    }
}

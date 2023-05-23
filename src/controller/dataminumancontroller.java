/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdata.dataminumanDAO;
import DAOimplement.dataminumanimplement;
import model.*;
import restaurant.menu2;
/**
 *
 * @author ASUS
 */
public class dataminumancontroller {
    menu2 frame;
    dataminumanimplement impldataminum;
    List<dataminuman> dminum;
    
    public dataminumancontroller(menu2 frame){
        this.frame = frame;
        impldataminum = new dataminumanDAO();
        dminum = impldataminum.getALL();
    }
    public void isitabel(){
        dminum = impldataminum.getALL();
        modeltabeldataminuman mtdmnn= new modeltabeldataminuman(dminum);
        frame.getTabelMinuman().setModel(mtdmnn);
    }
}

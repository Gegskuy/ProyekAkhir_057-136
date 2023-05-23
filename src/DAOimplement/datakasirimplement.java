/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplement;
import java.util.List;
import model.*;
/**
 *
 * @author ASUS
 */
public interface datakasirimplement {
    public void insert(datakasir dksr);
    public void update(datakasir dksr);
    public void delete(int idksr);
    public List<datakasir> getALL();
}

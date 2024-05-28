/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import javax.swing.JOptionPane;
import models.UserModel;
import views.AuthView;

/**
 *
 * @author Salma Hanifa
 */
public class AuthController {
    AuthView view;
     public void generateView(){
         view = new AuthView(this);
         view.setVisible(true);
     }
    
     public void runLogin(String uName, String pass){
         UserModel user = new UserModel();
         if(user.checkUser(uName, pass)){
             JOptionPane.showMessageDialog(null, "Berhasil Melakukan Login", "Sukses", JOptionPane.INFORMATION_MESSAGE);
         }else{
             JOptionPane.showMessageDialog(null, "Login gagal, username atau password salah", "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
     
     public void runRegist(String uName, String pass){
         UserModel user = new UserModel();
         if(user.addUser(uName, pass)){
             JOptionPane.showMessageDialog(null, "Berhasil Membuat Akun", "Sukses", JOptionPane.INFORMATION_MESSAGE);
         }else{
             JOptionPane.showMessageDialog(null, "Gagal membuat akun", "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
}

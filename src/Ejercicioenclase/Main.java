/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicioenclase;
import javax.swing.JFrame;
import java.awt.Graphics;
/**
 *
 * @author Estudiante
 */
public class Main  {
   
    public static void main(String[] args) throws Exception {
  TestPaintComponent frame=new TestPaintComponent();
  frame.setTitle("hombresito");
  frame.setSize(800, 500);
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setVisible(true);
    
    
    
    }
}

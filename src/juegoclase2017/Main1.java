/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoclase2017;

import javax.swing.JFrame;
import java.awt.Graphics;

/**
 *
 * @author Estudiante
 */
public class Main1 {

    public static void main(String[] args) throws Exception {
        TestPaintComponent1 juego = new TestPaintComponent1();
        juego.setTitle("Juego");
        juego.setSize(800, 500);
        juego.setLocationRelativeTo(null);
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        juego.setVisible(true);
    }

}

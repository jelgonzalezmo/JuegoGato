/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicioenclase;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author Estudiante
 */
// ActionListener  es para el movimiento, MouseListener es para saber lo que se hace con el mouse
public class NewPanel extends JPanel implements ActionListener, MouseListener{
private int x;
private Timer timer;
private int a=20;
//clic repetido
    private final Color color;

    public NewPanel() {
       this.addMouseListener(this);
       this.color=Color.PINK;
        timer=new Timer (a,this);//cunatos segudos, milisegundos
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
      
        g.drawRect(x, 90,80 ,50 );//dos primeras posiciones, sigyuiente tamaño 
        g.drawRoundRect(x+10, 140, 20, 20, 20, 20);
        g.drawRoundRect(x+60, 140, 20, 20, 20, 20);
        g.drawRect(x+70, 110, 40, 10);
        g.drawRect(x+20, 10, 10, 20);
        g.drawRect(x+90, 10, 10, 20);
       
        //dos
        int m=x+130;
        //dos primeras posiciones, siguiente es el tamaño 
        g.drawRect(m+150, 140, 20, 20);
        g.drawRoundRect(m+60, 60, 20, 20, 20, 20);
        g.drawString("puntos=xxx", 200, 10);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       x+=1;
       repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("dio click");
    Point mp=e.getPoint();
    if(getBounds().contains(mp))
    { this.timer.stop();}
    }

    public Rectangle getBounds(){
    return new Rectangle (x,90,80,50);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        }

    @Override
    public void mouseEntered(MouseEvent e) {
        }

    @Override
    public void mouseExited(MouseEvent e) {
         }
}

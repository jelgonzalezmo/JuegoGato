/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoclase2017;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author Isabel-Fabian
 */
public class NewPanel1 extends JPanel implements ActionListener, MouseListener{
private int x;
private int y;
private Timer tiempo;
private int a;
private int secuencia=0;
private Color color;

public NewPanel1() throws Exception {
        initBoard();
        this.addMouseListener(this);
        this.color = Color.PINK;
        tiempo = new Timer(a, this);//cunatos segudos, milisegundos
        tiempo.start();
    }

    private void initBoard() throws Exception {
        addKeyListener(new TAdapter());
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("blue_background.png");
        g.drawImage(fondo, x, y, x+22, y+800,  (this.secuencia * 22), 800, (this.secuencia * 22) + 22, 800, this);
        //Image heroe = loadImage("walking.png");
        //g.drawImage(heroe, 0, 0, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 2;
        //DetectarColision();
        if (this.secuencia == 2) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("dio click");
        Point mp = e.getPoint();
        if (getBounds().contains(mp)) {
            this.tiempo.stop();
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x - 5, 390, 90, 50);
    }

    public void DetectarColision() {
        Rectangle tanque = getBounds();
        Rectangle objeto = new Rectangle(170, 420, 40, 10);
        if (tanque.intersects(objeto)) {
            tiempo.stop();
        }
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

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                System.out.println("VK_SPACE");
            }
            if(key==KeyEvent.VK_RIGHT ){
                System.out.println("derecha"); 
            x+=50;
            }
         if(key==KeyEvent.VK_UP ){
            y=y-50;
             System.out.println("arriba");
         }
         if(key==KeyEvent.VK_LEFT){
            x-=50;
            }
        if (key==KeyEvent.VK_DOWN){
            y=y+50;}
        }
    }
    
    }

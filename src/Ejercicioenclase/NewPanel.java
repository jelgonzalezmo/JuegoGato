/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicioenclase;

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
 * @author Estudiante
 */
// ActionListener  es para el movimiento, MouseListener es para saber lo que se hace con el mouse
public class NewPanel extends JPanel implements ActionListener, MouseListener {

    private int x;
    private int y;
    private Timer timer;
    private int a = 20;
    private int secuencia = 0;
//clic repetido
    private final Color color;

    public NewPanel() throws Exception {
        initBoard();
        this.addMouseListener(this);
        this.color = Color.PINK;
        timer = new Timer(a, this);//cunatos segudos, milisegundos
        timer.start();
    }

    private void initBoard() throws Exception {
        addKeyListener(new TAdapter());
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        Image hombresitos = loadImage("free_radical_game_sprites.png");
        g.drawImage(hombresitos, x, y+380, x + 45, y+(380 + 45), 192 + (this.secuencia * 32), 192, 192 + (this.secuencia * 32) + 32, 192 + 32, this);

        /* g.fillRect(x, 390,80 ,50);//dos primeras posiciones, sigyuiente tamaño 
        g.drawRoundRect(x+10, 440, 20, 20, 20, 20);
        g.drawRoundRect(x+60, 440, 20, 20, 20, 20);
        g.drawRect(x+70, 410, 40, 10);
        g.drawRect(x+20, 310, 10, 20);
        g.drawRect(x+90, 310, 10, 20);
       g.setColor(Color.black);
        //dos
        int m=x+130;
        //dos primeras posiciones, siguiente es el tamaño 
        g.drawRect(m+150, 440, 20, 20);
        g.drawRoundRect(m+60, 460, 20, 20, 20, 20);
        g.drawString("puntos=xxx", 200, 10);
        g.drawRect(170, 420, 40, 10);
     g.setColor(Color.YELLOW);*/
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
            this.timer.stop();
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x - 5, 390, 90, 50);
    }

    public void DetectarColision() {
        Rectangle tanque = getBounds();
        Rectangle objeto = new Rectangle(170, 420, 40, 10);
        if (tanque.intersects(objeto)) {
            timer.stop();
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

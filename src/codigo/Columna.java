/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author xp
 */
public class Columna {
    
    Rectangle2D capitel, base;
    int hueco = 80;
    int altura_columna = 500;
    int ancho_columna = 79;
    private int ancho_pantalla;
    Image col_abajo, col_arriba;
        
    public Columna (int _ancho, int _anchoPantalla){
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(300);
        capitel = new Rectangle2D.Double(_ancho, -desplazamiento, ancho_columna, altura_columna);
        base = new Rectangle2D.Double(_ancho, 
                                      altura_columna + hueco - desplazamiento , 
                                      ancho_columna, 
                                      altura_columna);
        ancho_pantalla = _anchoPantalla;
        precargaImagenes();
    }
    
    private void precargaImagenes(){
         
        col_abajo = (new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/pipe_bottom.png")).
               getImage().getScaledInstance(79, 500, Image.SCALE_DEFAULT))).getImage();
    }
    
    public void mueve(Graphics2D g2){
        mueveColumna();
        //mueveColumna(base);

        g2.setColor(Color.BLUE);
        //g2.fill(capitel);
        
        //g2.fill(base);
        
        g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY(), null);

    }
    
    private void mueveColumna(){
        if (capitel.getX() + ancho_columna < 0){
            Random aleatorio = new Random();
            int desplazamiento = aleatorio.nextInt(300);
            capitel.setFrame(ancho_pantalla, 
                            -desplazamiento,
                            capitel.getWidth(), 
                            capitel.getHeight());
            base.setFrame(ancho_pantalla, 
                            altura_columna + hueco - desplazamiento,
                            base.getWidth(), 
                            base.getHeight());
        }
        else{
            capitel.setFrame(capitel.getX()-1, capitel.getY(),capitel.getWidth(), capitel.getHeight());
            base.setFrame(base.getX()-1, base.getY(),base.getWidth(), base.getHeight());
        }
    }
}

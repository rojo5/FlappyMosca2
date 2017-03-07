/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * @author xp
 */
public class Columna {
    
    Rectangle2D capitel, base;
    int hueco = 80;
    int altura_columna = 500;
    int ancho_columna = 40;
    private int ancho_pantalla;
    
    public Columna (int _ancho, int _anchoPantalla){
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(300);
        capitel = new Rectangle2D.Double(_ancho, -desplazamiento, ancho_columna, altura_columna);
        base = new Rectangle2D.Double(_ancho, 
                                      altura_columna + hueco - desplazamiento , 
                                      ancho_columna, 
                                      altura_columna);
        ancho_pantalla = _anchoPantalla;
    }
    
    
    
    public void mueve(Graphics2D g2){
        mueveColumna();
        //mueveColumna(base);

        g2.setColor(Color.BLUE);
        g2.fill(capitel);
        g2.fill(base);

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

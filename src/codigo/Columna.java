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

/**
 *
 * @author xp
 */
public class Columna {
    
    Rectangle2D capitel, base;
    int hueco = 80;
    int altura_columna = 300;
    int ancho_columna = 40;
    private int ancho_pantalla;
    
    public Columna (int _ancho){
        capitel = new Rectangle2D.Double(_ancho, 0, ancho_columna, altura_columna);
        base = new Rectangle2D.Double(_ancho, 
                                      altura_columna + hueco , 
                                      ancho_columna, 
                                      altura_columna);
        ancho_pantalla = _ancho;
    }
    
    
    
    public void mueve(Graphics2D g2){
        mueveColumna(capitel);
        mueveColumna(base);

        g2.setColor(Color.BLUE);
        g2.fill(capitel);
        g2.fill(base);

    }
    
    private void mueveColumna(Rectangle2D r){
        if (r.getX() + ancho_columna < 0){
            r.setFrame(ancho_pantalla, r.getY(),r.getWidth(), r.getHeight());
        }
        else{
            r.setFrame(r.getX()-1, r.getY(),r.getWidth(), r.getHeight());
        }
    }
}

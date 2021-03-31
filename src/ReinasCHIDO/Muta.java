/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinasCHIDO;

import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Muta {
    
    public static void mutarGenotipo(double probUSR, Individuo individuo) {

        // Generamos una probabilidad aleatoria entre 0-1
        Random aux = new Random();
        double probRandom = aux.nextDouble() * 1;

        if (probRandom <= probUSR) {

            // modificar una pos del genotipo
            Random ran = new Random();
            int reinaN = ran.nextInt(individuo.getGenotipo().length);
            int posYnueva = ran.nextInt(individuo.getGenotipo().length);
            individuo.getGenotipo()[reinaN] = posYnueva;

            // como actualizamos el genotipo, tambien hay que calcular el fitness de este genotipo nuevo
            individuo.actualizacionGenFit();

        }
    }
    
    
    
}

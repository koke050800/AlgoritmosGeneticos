/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATboolena;

import java.util.ArrayList;

/**
 *
 * @author KOKE
 */
public class Cruza {

    public static Individuo cruzar(Individuo padre, Individuo madre, int[] mascara, ArrayList<Instancias> instancias) {
        Individuo hijo1, hijo2;
        int[] genoitpoHijo1 = new int[padre.getGenotipo().length];
        int[] genotipoHijo2 = new int[padre.getGenotipo().length];

        // recorrer la mascara de cruza
        for (int x = 0; x < mascara.length; x++) {

            if (mascara[x] == 1) {
                genoitpoHijo1[x] = madre.getGenotipo()[x];
                genotipoHijo2[x] = padre.getGenotipo()[x];

            } else {
                genoitpoHijo1[x] = padre.getGenotipo()[x];
                genotipoHijo2[x] = madre.getGenotipo()[x];
            }
        }
        hijo1 = new Individuo(genoitpoHijo1, instancias);
        hijo2 = new Individuo(genotipoHijo2, instancias);

        if (hijo1.getFitness() > hijo2.getFitness()) {
            return hijo1;
        } else {
            return hijo2;
        }

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Seleccion {

    public static Individuo concualseleccion(boolean a, boolean b, Poblacion pob, LinkedList<int[]> m) {

        if (a && !b) {
            //System.out.println("Aleatoria");
            return seleccionAleatoria(pob, m);
        } else if (!a && b) {

            //System.out.println("Torneo");
            return seleccionTorneo(pob, m);
        } else {
            Random ran = new Random();
            if (ran.nextInt(2) == 0) {
               // System.out.println("Aleatoria");
                return seleccionAleatoria(pob, m);
            } else {
                //System.out.println("Torneo");
                return seleccionTorneo(pob, m);
            }

        }

    }

    public static Individuo seleccionAleatoria(Poblacion pob, LinkedList<int[]> m) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacionSAT().size());

        return new Individuo(pob.getPoblacionSAT().get(pos).getGenotipo(), m);
    }

    public static Individuo seleccionTorneo(Poblacion pob, LinkedList<int[]> m) {
        Individuo mejor = new Individuo(pob.getMejor().getGenotipo(), m);
        return mejor;
    }
}

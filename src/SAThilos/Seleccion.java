/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;

import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Seleccion {

    public static Individuo seleccionAleatoria(Poblacion pob) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getIndividuos().size());

        return new Individuo(pob.getIndividuos().get(pos));
    }

    public static Individuo seleccionRuleta(Poblacion pob) {
        int sumatotal = pob.getFitnessTotal();
        double[] probabilidad = new double[pob.getIndividuos().size()];
        double[] probacumulada = new double[pob.getIndividuos().size()];

        for (int i = 0; i < pob.getIndividuos().size(); i++) {
            probabilidad[i] = (double) pob.getIndividuos().get(i).getFitness() / sumatotal;
        }
        probacumulada[0] = probabilidad[0];

        for (int i = 1; i < pob.getIndividuos().size(); i++) {
            probacumulada[i] = probabilidad[i] + probacumulada[i - 1];
        }
        double numale = Math.random();
        int pos = 0;
        for (int i = 1; i < probacumulada.length; i++) {
            if (numale <= probacumulada[i] && numale > probacumulada[i - 1]) {
                pos = i;
                break;
            }
        }
        return pob.getIndividuos().get(pos);
    }

    public static Individuo seleccionTorneo(Poblacion pob) {

        return pob.getMejorIndividuo();
    }

}

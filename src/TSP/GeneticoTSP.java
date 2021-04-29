/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import Grafica.Histograma;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class GeneticoTSP {

    Poblacion poblacionActual;
    int numGeneraciones, tamPoblacion, nCiudades;
    double pMuta;
    int[] mejoresFitness;
    int ciudadInicial;
    int matrizCargada[][];
    Individuo mejorMejor;

    public GeneticoTSP() {
    }

    public GeneticoTSP(int numGeneraciones, int tamPoblacion, double pMuta, int ciudadInicial, int matrizCargada[][]) {
        this.poblacionActual = new Poblacion(tamPoblacion, ciudadInicial, matrizCargada);
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.pMuta = pMuta;
        this.mejoresFitness = new int[numGeneraciones];
        this.ciudadInicial = ciudadInicial;
        this.matrizCargada = matrizCargada;

    }

    public GeneticoTSP(int numGeneraciones, int tamPoblacion, double pMuta, int ciudadInicial, int nCiudades) {
        this.poblacionActual = new Poblacion(tamPoblacion, ciudadInicial, nCiudades);
        //poblacionActual.mostrarPob();
        this.matrizCargada = this.poblacionActual.getIndividuos().get(0).getDistanciasCaminos();
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.pMuta = pMuta;
        this.mejoresFitness = new int[numGeneraciones];
        this.ciudadInicial = ciudadInicial;
      

    }

    public void crearNuevasGeneraciones() {
        // Iteramos de acuerdo al numero de generaciones
        for (int generacion = 1; generacion <= this.numGeneraciones; generacion++) {

            // Creamos un ArrayList para la nueva poblacion
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();

            Individuo mejorIndividuo;

            if (generacion == 1) {
                mejorIndividuo = this.poblacionActual.getMejorIndividuo();
                mejorMejor = new Individuo(mejorIndividuo.getGenotipo(), mejorIndividuo.getDistanciasCaminos());
            }

            //this.poblacionActual.mostrarPob();
            //System.out.println("SOY EL MEJOR " + generacion + ">>>" + mejorMejor.getFitness());
            //System.out.println("");

            for (int individuo = 0; individuo < this.tamPoblacion; individuo++) {
                // seleccionamos aleatoriamente los padres
                Random ran = new Random();

                int posMadre = ran.nextInt(tamPoblacion - 1);
                int posPadre = ran.nextInt(tamPoblacion - 1);

                Individuo madre = this.poblacionActual.getIndividuos().get(posMadre);
                Individuo padre = this.poblacionActual.getIndividuos().get(posPadre);

                // Cruzamos para crear a los hijos
                Individuo hijo = Cruza.cruzaAsexual(padre, madre, matrizCargada);

                //Evaluamos si el hijo va mutar o no
                Muta.mutarGenotipo(pMuta, hijo);

                if (hijo.getFitness() < mejorMejor.getFitness()) {
                    nuevaPoblacion.add(hijo);
                    mejorMejor.setGenotipo(hijo.getGenotipo());
                    mejorMejor.actualizarIndividuo();
                } else {
                    nuevaPoblacion.add(new Individuo(mejorMejor.getGenotipo(), mejorMejor.getDistanciasCaminos()));
                }

            }

            Individuo mejorGeneracion = this.poblacionActual.getMejorIndividuo();
            System.out.println("SOY EL MEJOR DE LA GENERACION " + generacion + ">>>" + mejorGeneracion.getFitness());
            mejoresFitness[generacion - 1] = mejorGeneracion.getFitness();

            // actualizamos la nueva población
            this.poblacionActual = new Poblacion((ArrayList<Individuo>) nuevaPoblacion.clone());
            System.out.println("");

        }

        System.out.println("YO FUI EL MEJOR DE TODAS LAS GENERACIONES CON EL GENOTIPO: " + Arrays.toString(mejorMejor.getGenotipo()));
        System.out.println("Y EL FITNESS: " + mejorMejor.getFitness());
        mejorMejor.calcularFitness2();

        HerramientasTSP.escribir(mejorMejor.getDistanciasCaminos());

        Histograma h1 = new Histograma(mejoresFitness);
        h1.graficar();

    }

    public Poblacion getPoblacionActual() {
        return poblacionActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.poblacionActual = poblacionActual;
    }

}

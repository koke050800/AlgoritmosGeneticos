/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSPinclinaciones;


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
    double[] mejoresFitness2;
    int ciudadInicial;
    int matrizCargada[][];
    Individuo mejorMejor;
    int limiteinclinaciones;
    int inclinaciones[];

    public GeneticoTSP() {
    }

    public GeneticoTSP(int numGeneraciones, int tamPoblacion, double pMuta, int ciudadInicial, int matrizCargada[][], int[] inclinaciones) {
        this.poblacionActual = new Poblacion(tamPoblacion, ciudadInicial, matrizCargada,inclinaciones);
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.pMuta = pMuta;
        this.mejoresFitness = new int[numGeneraciones];
        this.mejoresFitness2 = new double[numGeneraciones];
        this.ciudadInicial = ciudadInicial;
        this.matrizCargada = matrizCargada;
        this.inclinaciones = inclinaciones;

    }

    public GeneticoTSP(int numGeneraciones, int tamPoblacion, double pMuta, int ciudadInicial, int nCiudades, int limiteinclinaciones) {
        this.poblacionActual = new Poblacion(tamPoblacion, ciudadInicial, nCiudades, limiteinclinaciones);
        //poblacionActual.mostrarPob();
        this.matrizCargada = this.poblacionActual.getIndividuos().get(0).getDistanciasCaminos();
        this.inclinaciones = this.poblacionActual.getIndividuos().get(0).getInclinaciones();
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.pMuta = pMuta;
        this.mejoresFitness = new int[numGeneraciones];
        this.mejoresFitness2 = new double[numGeneraciones];
        this.ciudadInicial = ciudadInicial;
        this.limiteinclinaciones = limiteinclinaciones;
      

    }

    public void crearNuevasGeneraciones() {
        // Iteramos de acuerdo al numero de generaciones
        for (int generacion = 1; generacion <= this.numGeneraciones; generacion++) {

            // Creamos un ArrayList para la nueva poblacion
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();

            Individuo mejorIndividuo;

            if (generacion == 1) {
                mejorIndividuo = this.poblacionActual.getMejorIndividuo();
                mejorMejor = new Individuo(mejorIndividuo.getGenotipo(), mejorIndividuo.getDistanciasCaminos(),mejorIndividuo.getInclinaciones() );
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
                Individuo hijo = Cruza.cruzaAsexual(padre, madre, matrizCargada, inclinaciones);

                //Evaluamos si el hijo va mutar o no
                Muta.mutarGenotipo(pMuta, hijo);

                if (hijo.getFitnessGeneral() < mejorMejor.getFitnessGeneral()) {
                    nuevaPoblacion.add(hijo);
                    mejorMejor.setGenotipo(hijo.getGenotipo());
                    mejorMejor.actualizarIndividuo();
                } else {
                    nuevaPoblacion.add(new Individuo(mejorMejor.getGenotipo(), mejorMejor.getDistanciasCaminos(), mejorMejor.getInclinaciones()));
                }

            }

            Individuo mejorGeneracion = this.poblacionActual.getMejorIndividuo();
            System.out.println("SOY EL MEJOR DE LA GENERACION " + generacion + ">>>" + mejorGeneracion.getFitnessGeneral());
            mejoresFitness[generacion - 1] = (int)mejorGeneracion.getFitnessGeneral();

            // actualizamos la nueva población
            this.poblacionActual = new Poblacion((ArrayList<Individuo>) nuevaPoblacion.clone());
            System.out.println("");

        }

        System.out.println("YO FUI EL MEJOR DE TODAS LAS GENERACIONES CON EL GENOTIPO: " + Arrays.toString(mejorMejor.getGenotipo()));
        System.out.println("Y EL FITNESS: " + mejorMejor.getFitnessGeneral());
        mejorMejor.calcularFitness2();

        HerramientasTSP.escribir(mejorMejor.getDistanciasCaminos(), mejorMejor.getInclinaciones());

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

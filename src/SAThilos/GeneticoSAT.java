/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;

import Grafica.Histograma;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author KOKE
 */

public class GeneticoSAT implements Runnable {

    private Poblacion poblacionActual;
    private int numGeneraciones, tamPoblacion, tamIndividuos;
    private double pMuta;
    private int[] mask;
    private ArrayList<Instancias> instancias;
    private int[] mejoresFitness;
    private int seleccion = 1;
    private JFrameCambios frameCambios;


    public GeneticoSAT(int numGeneraciones, int tamPoblacion, int tamIndividuos, double pMuta, int[] mask, ArrayList<Instancias> instancias, JFrameCambios frameCambios) {
        this.instancias = (ArrayList<Instancias>) instancias.clone();
        this.poblacionActual = new Poblacion(tamPoblacion, tamIndividuos, instancias);
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.tamIndividuos = tamIndividuos;
        this.pMuta = pMuta;
        this.mask = new int[mask.length];
        this.mask = mask.clone();
        this.mejoresFitness = new int[numGeneraciones];
        this.frameCambios = frameCambios;

    }

    public GeneticoSAT() {

    }

    public void crearNuevasGeneraciones() {
        ArrayList<Integer> datops = new ArrayList<>();

        // Iteramos de acuerdo al numero de generaciones
        for (int g = 1; g <= this.numGeneraciones; g++) {

            // Creamos un ArrayList para la nueva poblacion
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            for (int i = 0; i < this.tamPoblacion; i++) {

                Individuo madre = elegirTipoSeleccion(this.seleccion);
                Individuo padre = elegirTipoSeleccion(this.seleccion);

                // Cruzamos para crear a los hijos
                Individuo hijo = Cruza.cruzar(padre, madre, mask, instancias);

                //Evaluamos si el hijo va mutar o no
                Muta.mutarGenotipo(pMuta, hijo, instancias);

                // agregamos el hijo
                nuevaPoblacion.add(hijo);
            }

            // actualizamos la nueva población
            this.poblacionActual = new Poblacion(nuevaPoblacion);
            this.frameCambios.getjTextArea1().append("Generacion: " + g + " creada -- " + "Probabilidad de muta es: " + pMuta + "\n");
            System.out.println("Generacion: " + g + " creada -- " + "Probabilidad de muta es: " + pMuta);

            // pedimos el mejor de la generacion
            Individuo mejorIndividuo = this.poblacionActual.getMejorIndividuo();
            datops.add(mejorIndividuo.getFitness());
            mejoresFitness[g - 1] = mejorIndividuo.getFitness();
            this.frameCambios.actualizarGrafica(datops);

            System.out.println();

        }
        // pedimos el mejor a la poblacion 
        Individuo mejorIndividuo = this.poblacionActual.getMejorIndividuo();

        System.out.println("El mejor individuo tiene genotipo: " + Arrays.toString(mejorIndividuo.getGenotipo()));
        System.out.println("Con el fitness: " + mejorIndividuo.getFitness());
        this.frameCambios.getjTextArea1().append("El mejor individuo tiene genotipo: " + Arrays.toString(mejorIndividuo.getGenotipo()) + "\n"
                + "Con el fitness: " + mejorIndividuo.getFitness() + "\n");

        System.out.println();
        System.out.println();

//        Histograma h1 = new Histograma(mejoresFitness);
//        h1.graficar();
    }

    private Individuo elegirTipoSeleccion(int s) {
        Individuo i = null;
        switch (s) {
            case 1:
                i = Seleccion.seleccionAleatoria(this.poblacionActual);
                break;
            case 2:
                i = Seleccion.seleccionTorneo(this.poblacionActual);
                break;
            case 3:
                i = Seleccion.seleccionRuleta(this.poblacionActual);
                break;
            default:
                break;

        }
        return i;
    }

    @Override
    public void run() {
        crearNuevasGeneraciones();
    }

    public Poblacion getPoblacionActual() {
        return poblacionActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.poblacionActual = poblacionActual;
    }

    public int getNumGeneraciones() {
        return numGeneraciones;
    }

    public void setNumGeneraciones(int numGeneraciones) {
        this.numGeneraciones = numGeneraciones;
    }

    public int getTamPoblacion() {
        return tamPoblacion;
    }

    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }

    public int getTamIndividuos() {
        return tamIndividuos;
    }

    public void setTamIndividuos(int tamIndividuos) {
        this.tamIndividuos = tamIndividuos;
    }

    public double getpMuta() {
        return pMuta;
    }

    public void setpMuta(double pMuta) {
        this.pMuta = pMuta;
    }

    public int[] getMask() {
        return mask;
    }

    public void setMask(int[] mask) {
        this.mask = mask;
    }

    public ArrayList<Instancias> getInstancias() {
        return instancias;
    }

    public void setInstancias(ArrayList<Instancias> instancias) {
        this.instancias = instancias;
    }

    public int[] getMejoresFitness() {
        return mejoresFitness;
    }

    public void setMejoresFitness(int[] mejoresFitness) {
        this.mejoresFitness = mejoresFitness;
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    public JFrameCambios getFrameCambios() {
        return frameCambios;
    }

    public void setFrameCambios(JFrameCambios frameCambios) {
        this.frameCambios = frameCambios;
    }


    
    

}

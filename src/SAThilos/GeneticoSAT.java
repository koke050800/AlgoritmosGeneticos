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

public class GeneticoSAT implements Runnable{

    Poblacion poblacionActual;
    int numGeneraciones, tamPoblacion, tamIndividuos;
    double pMuta;
    int[] mask;
    ArrayList<Instancias> instancias;
    int[] mejoresFitness;
     private int seleccion=1;

    public GeneticoSAT(int numGeneraciones, int tamPoblacion, int tamIndividuos, double pMuta, int[] mask, ArrayList<Instancias> instancias) {
        this.instancias = (ArrayList<Instancias>) instancias.clone();
        this.poblacionActual = new Poblacion(tamPoblacion, tamIndividuos, instancias);
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.tamIndividuos = tamIndividuos;
        this.pMuta = pMuta;
        this.mask = new int[mask.length];
        this.mask = mask.clone();
        this.mejoresFitness = new int[numGeneraciones];
    }

    public GeneticoSAT() {
       
    }


    

    public void crearNuevasGeneraciones(){
        // Iteramos de acuerdo al numero de generaciones
        for (int g = 1; g <= this.numGeneraciones; g++) {
           
            // Creamos un ArrayList para la nueva poblacion
            ArrayList<Individuo> nuevaPoblacion = new ArrayList<>();
            for (int i = 0; i < this.tamPoblacion; i++) {
                
       
                
                Individuo madre = eligeSeleccion(this.seleccion);                    
                Individuo padre = eligeSeleccion(this.seleccion);
                
                
                // Cruzamos para crear a los hijos
                Individuo hijo = Cruza.cruzar(padre, madre, mask, instancias);
                
                //Evaluamos si el hijo va mutar o no
                Muta.mutarGenotipo(pMuta, hijo, instancias);
                
                // agregamos el hijo
                nuevaPoblacion.add(hijo);
            }
            
            // actualizamos la nueva población
            this.poblacionActual = new Poblacion(nuevaPoblacion);
            System.out.println("Generacion: "+g+" creada -- "+"Probabilidad de muta es: "+pMuta);
    
            // pedimos el mejor de la generacion
            Individuo mejorIndividuo = this.poblacionActual.getMejorIndividuo();

            mejoresFitness[g - 1] = mejorIndividuo.getFitness();
            System.out.println();

            
            
            
        }
        // pedimos el mejor a la poblacion 
        Individuo mejorIndividuo = this.poblacionActual.getMejorIndividuo();
        
        System.out.println("El mejor individuo tiene genotipo: "+Arrays.toString(mejorIndividuo.getGenotipo()));
        System.out.println("Con el fitness: "+mejorIndividuo.getFitness());
        System.out.println();
        System.out.println();
        
        Histograma h1 = new Histograma(mejoresFitness);
        h1.graficar();
    }
    
    private Individuo eligeSeleccion(int s) {
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

    public Poblacion getPoblacionActual() {
        return poblacionActual;
    }

    public void setPoblacionActual(Poblacion poblacionActual) {
        this.poblacionActual = poblacionActual;
    }

    public double getpMuta() {
        return pMuta;
    }

    public void setpMuta(double pMuta) {
        this.pMuta = pMuta;
    }

    @Override
    public void run() {
        crearNuevasGeneraciones();
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticos2021.pkg2;

import binario.Cruza;
import binario.GeneticoBinario;
import binario.Herramientas;
import binario.Individuo;
import binario.Muta;
import binario.Poblacion;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public class Geneticos20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Poblacion poblacionInicial = new Poblacion(10, 4);
        ArrayList<Individuo> individuos = new ArrayList<>();
       
        System.out.println("Lista");      
        for (Individuo aux : poblacionInicial.getIndividuos()) {

            System.out.println("Fenotipo: " + aux.getFenotipo() + "    Fitness: " + aux.getFitness());
        }
        System.out.println();
        
        

        System.out.println("Mejores");
        individuos = poblacionInicial.getNMejores(10);

        for (Individuo aux : individuos) {

            System.out.println("Fenotipo: " + aux.getFenotipo() + "    Fitness: " + aux.getFitness());
        }
        System.out.println();
        
        System.out.println("Fenotipo: " + individuos.get(0).getFenotipo() + "    Fitness: " + individuos.get(0).getFitness());
        Muta.mutarGenotipo(1, individuos.get(0));
        
        System.out.println("Fenotipo: " + individuos.get(0).getFenotipo() + "    Fitness: " + individuos.get(0).getFitness());*/
        
        int numGeneraciones = 100;
        int tamPoblacion = 10;
        int tamIndividuos = 10;
        double pMuta = 0.09;
        int[] mask = Herramientas.generarArregloBinarios(tamIndividuos);
                
        GeneticoBinario gb1 = new GeneticoBinario(numGeneraciones, tamPoblacion, tamIndividuos, pMuta, mask);
        gb1.evolucionar();
        
        
        

    }

}

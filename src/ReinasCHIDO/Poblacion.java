/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinasCHIDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Poblacion {
    private ArrayList<Individuo> individuos;

    public Poblacion(ArrayList<Individuo> aux) {
        this.individuos = (ArrayList<Individuo>) aux.clone();
    }

    public Poblacion(int tamPob, int tamIndividuo) {
        this.individuos = new ArrayList<>();
        for (int i = 0; i < tamPob; i++) {
            this.individuos.add(new Individuo(tamIndividuo));
        }
    }


    public ArrayList<Individuo> getMejoresIndividuos(int n) {
        // Validamos que n no sea mas grande que el tamaño de la población
        if (n <= this.individuos.size()) { //se modifico por <=
            // ordenar a la población
            ordenarPoblacionActual();
            // creamos un ArrayList nuevo de individuos
            ArrayList<Individuo> nMejores = new ArrayList<>();

            for (int x = this.individuos.size() - 1; x >= this.individuos.size() - n; x--) { //recorremos la lista ordenada de atras para delante

                Individuo e = new Individuo(this.individuos.get(x).getGenotipo());
                nMejores.add(e);
            }
            return nMejores;
        }

        return (ArrayList<Individuo>) this.individuos.clone();
    }

    public Individuo getMejorIndividuo() {
        int idMejor = 0;
        for (int x = 1; x < this.individuos.size(); x++) {
            if (this.individuos.get(x).getFitness() < this.individuos.get(idMejor).getFitness()) { //el mejor es el de menor fitness
                idMejor = x;
            }
        }
        return new Individuo(this.individuos.get(idMejor).getGenotipo());

    }

    public ArrayList<Individuo> getMuestraAleatoria(int n) {
        // validar que n <= tamaño de la población
        if (n < this.individuos.size()) {
            // creamos un coleccion nueva de individuos
            ArrayList<Individuo> muestra = new ArrayList<>();
            Random ran = new Random();
            for (int x = 0; x < n; x++) {
                int pos = ran.nextInt(this.individuos.size());
                Individuo e = new Individuo(this.individuos.get(pos).getGenotipo());
                muestra.add(e);
            }
            return muestra;
        }

        return (ArrayList<Individuo>) this.individuos.clone();
    }

    /**
     * @return the individuos
     */
    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    private void ordenarPoblacionActual() {
        for (int z = 1; z < this.individuos.size(); z++) {
            for (int v = 0; v < (this.individuos.size() - z); v++) {

                if (this.individuos.get(v).getFitness()
                        < this.individuos.get(v + 1).getFitness()) { 
                    Individuo aux = new Individuo(this.individuos.get(v).getGenotipo()); 
                    this.individuos.set(v, new Individuo(this.individuos.get(v + 1).getGenotipo())); 
                    this.individuos.set(v + 1, aux); 

                }
            }
        }

    }

    public int getFitnessTotal() {
        int acumulador = 0;

        for (int i = 0; i < individuos.size(); i++) {
            acumulador+= individuos.get(i).getFitness();

        }
        return acumulador;
    }

    public void mostrarPob() {
        System.out.println("Tengo " + individuos.size()+" individuos");
        for (int z = 0; z < individuos.size(); z++) {
            String aux = "Genotipo: ";
            aux += Arrays.toString(individuos.get(z).getGenotipo());            
            aux += " Fenotipo => " + individuos.get(z).getFitness();
            System.out.println(aux);
        }
    }




}

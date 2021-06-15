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
public class Poblacion {

    private LinkedList<Individuo> poblacion;
    private int i;
    private int tam;
    LinkedList<int[]> muestras;

    public Poblacion(int i, int tam, LinkedList<int[]> m) {
        this.i = i;
        this.tam = tam;
        this.poblacion = new LinkedList<>();
        this.muestras = m;
        inicializarAleatorimente(m);
    }

    public Poblacion(LinkedList<Individuo> muestra, int i, LinkedList<int[]> m) {
        this.poblacion = new LinkedList<>();
        this.muestras = m;
        for (int x = 0; x < muestra.size(); x++) {
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo(), this.muestras));
        }
    }

    public Poblacion() {
        this.poblacion = new LinkedList<>();

    }

    public Poblacion(Poblacion n, LinkedList<int[]> m) {
        this.poblacion = new LinkedList<>();
        this.muestras = m;

        for (Individuo aux : n.getPoblacionSAT()) {
            this.poblacion.add(new Individuo(aux.getGenotipo(), this.muestras));

        }

    }

    public void inicializarAleatorimente(LinkedList<int[]> m) {

        for (int x = 0; x < this.i; x++) {
            this.poblacion.add(new Individuo(this.tam, m));

        }

    }

    public Individuo getMejor() {
        int idMejor = 0;
        for (int x = 1; x < this.poblacion.size(); x++) {
            if (this.poblacion.get(x).getFitness() > this.poblacion.get(idMejor).getFitness()) {
                idMejor = x;
            }
        }
        return new Individuo(this.poblacion.get(idMejor).getGenotipo(), this.muestras);

    }

    public LinkedList<Individuo> getPoblacionSAT() {

        return poblacion;
    }
}

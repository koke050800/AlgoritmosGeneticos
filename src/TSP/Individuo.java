/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Individuo {

    private int[] genotipo;
    private int fitness;
    public int[][] distanciasCaminos;

    public Individuo() {
    }

    public Individuo(int ciudadInicial) {
        
        int matrizCargada[][] = HerramientasTSP.cargarMatrizDeDistancias();
        int nCiudades = matrizCargada[0].length;
        genotipo = new int[nCiudades];
        genotipo[0] = ciudadInicial;
        this.distanciasCaminos = matrizCargada;
        creaeGenotipoAleatorio();
        calcularFitness();

    }

    public Individuo(int ciudadInicial, int nCiudades) {
        genotipo = new int[nCiudades];
        genotipo[0] = ciudadInicial;        
        this.distanciasCaminos = HerramientasTSP.inicializaCaminos(nCiudades);
        creaeGenotipoAleatorio();
        calcularFitness();
        HerramientasTSP.escribir(distanciasCaminos);

    }

    public Individuo(int ciudadInicial, int matrizCargada[][]) {
        int nCiudades = matrizCargada[0].length;
        genotipo = new int[nCiudades];
        genotipo[0] = ciudadInicial;
        this.distanciasCaminos = matrizCargada;
        creaeGenotipoAleatorio();
        calcularFitness();

    }

    public void calcularFitness() {
        this.fitness = 0;
        if (distanciasCaminos != null) {
            this.fitness = 0;
            for (int j = 1; j < distanciasCaminos.length; j++) {
                this.fitness += distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]];
                System.out.println("Sumado: " + distanciasCaminos[this.genotipo[j - 1]][this.genotipo[j]]);

            }
            this.fitness += distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]];
            System.out.println("Sumado: " + distanciasCaminos[this.genotipo[0]][this.genotipo[distanciasCaminos.length - 1]]);

            System.out.println("Fitness: " + this.fitness);
        }

    }

    public void creaeGenotipoAleatorio() {
        ArrayList<Integer> ciudades = new ArrayList<>();
        for (int x = 0; x < genotipo.length; x++) {
            ciudades.add(x);
        }
        ciudades.remove(this.genotipo[0]);
        Random ran = new Random();
        // llenar los espacios vacios restantes del genotipo 
        for (int x = 1; x < genotipo.length; x++) {
            int pos = ran.nextInt(ciudades.size());
            int c = ciudades.get(pos);
            this.genotipo[x] = c;
            // eliminamos de las ciudades
            ciudades.remove(pos);
        }
        System.out.println(Arrays.toString(genotipo));

    }


 


    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public int[][] getDistanciasCaminos() {
        return distanciasCaminos;
    }

    public static void main(String[] args) {
        Individuo i1 = new Individuo(3, 4);
        System.out.println("FITNESS FINAL>> " + i1.getFitness());
        System.out.println();
        HerramientasTSP.imprimirMat(i1.getDistanciasCaminos());
        System.out.println("");
        System.out.println("***************************************************************");

       /*int matrizCargada[][] = new int[4][4];
        matrizCargada = HerramientasTSP.inicializaCaminos(4);
        Individuo i2 = new Individuo(3, matrizCargada);
        System.out.println("FITNESS FINAL>> " + i2.getFitness());
        System.out.println();
        HerramientasTSP.imprimirMat(i2.getDistanciasCaminos());*/
       
       
        Individuo i2 = new Individuo(3);
        System.out.println("FITNESS FINAL>> " + i2.getFitness());
        System.out.println();
        HerramientasTSP.imprimirMat(i2.getDistanciasCaminos());
       

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

public class Individuo implements Serializable {

    private int genotipo[];
    private long fenotipo;
    private long fitness;

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public long getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(int fenotipo) {
        this.fenotipo = fenotipo;
    }

    public long getFitness() {

        return fitness;
    }

    public void setFitness(long fitness) {
        this.fitness = fitness;
    }

    public Individuo(int n, LinkedList<int[]> muestras) {
        this.genotipo = new int[n];
        inicializarAleatoriamente();
        calcularFitness(muestras);
    }

    public Individuo(int aux[], LinkedList<int[]> muestras) {
        this.genotipo = aux.clone();
        calcularFitness(muestras);
    }
  

    public void calcularFitness(LinkedList<int[]> muestras) {
        this.fitness = 0;
        int cont=0;
        for (int i = 0; i < muestras.size(); i++) {
            int[] muestrita = muestras.get(i).clone();
            int[] binario = new int[muestrita.length];

            for (int k = 0; k < muestrita.length; k++) {
                if (muestrita[k] >= 0) {
                    binario[k] = 1;

                } else {
                    binario[k] = 0;
                    muestrita[k] = muestrita[k] * (-1);
                }
            }
            int[] operandos = new int[muestrita.length];

            for (int j = 0; j < muestrita.length; j++) {
                operandos[j] = this.genotipo[muestrita[j] - 1];

                if (binario[j] == 0) {
                    if (operandos[j] == 0) {
                        operandos[j] = 1;
                    } else {
                        operandos[j] = 0;
                    }
                }
                //   System.out.println("Vuelta: "+ i +" Gen: "+this.genotipo[muestrita[j]-1]+ " Muestra: "+ muestrita[j] +" Binario: "+ binario[j]+" Operando: "+operandos[j]);
            }
             cont = 0;
            for (int r = 0; r < operandos.length; r++) {
                if (operandos[r] == 1) {
                    cont++;
                }
            }
            if (cont > 0) {
                this.fitness++;
                //  System.out.println("Resultado: true");
            } else {
                // System.out.println("Resultado: false");
            }
        }
        //System.out.println("Fitness: " + this.fitness);
    }

    private void inicializarAleatoriamente() {
        Random ran = new Random();
        for (int x = 0; x < this.genotipo.length; x++) {
            this.genotipo[x] = ran.nextInt(2);
        }
    }

    public double torString() {
     /*   System.out.println("Genotipo: ");
        for (int i = 0; i < this.genotipo.length; i++) {
            System.out.print(this.genotipo[i] + ",");

        }
        System.out.println("\nFenotipo => " + this.fitness);*/
        return this.fitness;
    }
  public String tor2String() {
      String salida="";
       salida+="Genotipo: ";
        for (int i = 0; i < this.genotipo.length; i++) {
           salida+= this.genotipo[i] + ",";

        }
        salida+="\nFenotipo => " + this.fitness + "\n";
        return salida;
    }
   


}

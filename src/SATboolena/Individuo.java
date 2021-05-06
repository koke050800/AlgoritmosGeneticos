/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATboolena;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author KOKE
 */
public class Individuo {

    private int genotipo[];
    private int fitness;
    private ArrayList<Instancias> instancias;

    public Individuo(Individuo i) {
        this.genotipo = i.getGenotipo().clone();
        this.fitness = i.getFitness();
        this.instancias = (ArrayList<Instancias>) i.getInstancias().clone();
    }

    public Individuo(int n, ArrayList<Instancias> instancias) {
        // valorar su inicio aleatorio
        this.genotipo = HerramientasSAT.generarArregloBinarios(n);
        this.instancias = (ArrayList<Instancias>) instancias.clone();
        calcularFitness(instancias);
    }

    public Individuo(int[] gen, ArrayList<Instancias> instancias) {
        // valorar su inicio aleatorio
        this.genotipo = gen.clone();
        this.instancias = (ArrayList<Instancias>) instancias.clone();
        calcularFitness(instancias);
    }

    public void calcularFitness(ArrayList<Instancias> instancias) {

        this.fitness = 0;
        for (int i = 0; i < instancias.size(); i++) {
            if (instanciaIsTrue(instancias.get(i).getElementos())) {
                this.fitness++;
            }
        }
    }
    
    private boolean instanciaIsTrue(int[] elementos) {
        int ev, cont = 0;
        // System.out.println("PRUEBA ");
        for (int x = 0; x < elementos.length; x++) {
            // System.out.println("VALOR "+ x);
            ev = getGenotipo()[Math.abs(elementos[x]) - 1];
            // System.out.print("VALOR evaluado: "+(Math.abs(elementos[x])-1));
            // System.out.print(" VALOR: "+ elementos[x]+ " BINARIO: "+ev);
            if (elementos[x] * -1 == Math.abs(elementos[x])) {
                ev = ev - 1;
            }
            //System.out.print(" cambio?: "+ ev);
            //System.out.println(ev);
            if (Math.abs(ev) == 1) {
                cont++;
            }

            // System.out.print(" cambio a: "+ Math.abs(ev));
            //System.out.println();
        }
        if (cont != 0) {
            // System.out.println("----- CLARO QUE YES------");
            return true;
        } else {
            return false;
        }

    }

//    public boolean instanciaIsTrue(int[] instanciaEvaluando) {
//
//        for (int i = 0; i < instanciaEvaluando.length; i++) {
//
//            int posicion = instanciaEvaluando[i];
//            int posicion2 = Math.abs(posicion) - 1;
//            //System.out.print(""+this.genotipo[posicion2] +" , ");
//            
//            
//            if (posicion < 0) {
//                posicion = posicion * -1;
//                posicion--;
//                
//
//                if (this.genotipo[posicion] * -1 == 1) {
//                    
//                    //return true;
//                }
//
//            } else {
//                posicion--;
//                
//                if (this.genotipo[posicion] == 1) {
//                    //return true;
//                }
//
//            }
//            
//            
//            
//            
//
//        }
//        
//        System.out.println("");
//
//        //si al evaluar toda la instancia no obtenemos un 1, retornamos falso.
//        return false;
//
//    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public ArrayList<Instancias> getInstancias() {
        return instancias;
    }

    public void setInstancias(ArrayList<Instancias> instancias) {
        this.instancias = instancias;
    }
    
    
    public static void main(String[] args) throws IOException{
        int gen[] = { 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0};
        ArrayList<Instancias> instancias = ArchivosSAT.tokenizarDataSet();
        Individuo i1 =  new Individuo(gen, instancias);
        System.out.print("FIT>>> "+i1.getFitness());
    }

}

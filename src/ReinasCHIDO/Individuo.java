/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinasCHIDO;


/**
 *
 * @author KOKE
 */
public class Individuo {
    
    int n;
    int genotipo[];
    int fitness;

    public Individuo() {
    }

    public Individuo(int n) {
        this.n = n;
        this.genotipo = HerramientasReinas.crearGenotipoAleatorioReinas(n).clone();
        calcularFitness();
    }
    
    
    public Individuo(int genotipo[]) {
        this.n = genotipo.length;
        this.genotipo = genotipo.clone();
        calcularFitness();
    }

    public void calcularFitness() {
        this.fitness = 0;

        for (int columna = 0; columna < n; columna++) {//para situarnos en la pos X de la reina
            int posX = columna;
            int posY = genotipo[columna];//para sacar la fila en la que esta, nos la indica el genotipo

            //ahora si calculamos ataques
            for (int i = 0; i < genotipo.length; i++) {
                if (i != posX) {//para que no se ataque a si misma

                    if (genotipo[i] == posY) {//primero ataques horizontales
                        fitness++;
                        //System.out.println("reina " + posX + " fitness h: " + fitness);
                    }
                    //revisamos diagonales
                    if ((posX + posY) == i + genotipo[i] || (posX - posY) == i - genotipo[i]) {
                        fitness++;
                        //System.out.println("reina " + posX + " fitness d: " + fitness);
                    }

                }
            }

        }

        //System.out.println("fitness: " + fitness);
        

    }
    
    public void actualizacionGenFit(){
    
       calcularFitness();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

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
    

    
      public static void main(String[] args) {
        
          int genotipo[] = new int[]{2,5,7,1,3,0,6,2};
         
          Individuo i1= new Individuo(genotipo);
          
          
        
     }


    

}

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
                        System.out.println("reina " + posX + " fitness h: " + fitness);
                    }

                    if ((posX + posY) == i + genotipo[i] || (posX - posY) == i - genotipo[i]) {//revisamos diagonales
                        fitness++;
                        System.out.println("reina " + posX + " fitness d: " + fitness);
                    }

                }
            }

        }

        System.out.println("fitness: " + fitness);

    }

    

    
    
    
      public static void main(String[] args) {
        
          int genotipo[] = new int[9];
          genotipo[0]= 2;
          genotipo[1]= 8;
          genotipo[2]= 7;
          genotipo[3]= 8;
          genotipo[4]= 3;
          genotipo[5]= 7;
          genotipo[6]= 5;
          genotipo[7]= 0;
          genotipo[8]= 3;
          
          Individuo i1= new Individuo(genotipo);
          
          
        
     }


    

}

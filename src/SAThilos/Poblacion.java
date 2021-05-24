/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author KOKE
 */
public class Poblacion {

    private ArrayList<Individuo> individuos;
    ArrayList<Instancias> instancias;

    public Poblacion(ArrayList<Individuo> aux) {
        this.individuos = (ArrayList<Individuo>) aux.clone();
        this.instancias = individuos.get(0).getInstancias();
    }

    public Poblacion(int tamPob, int tamIndividuo, ArrayList<Instancias> instancias) {
        this.individuos = new ArrayList<>();
        this.instancias = (ArrayList<Instancias>) instancias.clone();

        for (int i = 0; i < tamPob; i++) {
            this.individuos.add(new Individuo(tamIndividuo, instancias));
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

                Individuo e = new Individuo(this.individuos.get(x).getGenotipo(), instancias);
                nMejores.add(e);
            }
            return nMejores;
        }

        return (ArrayList<Individuo>) this.individuos.clone();
    }

    public Individuo getMejorIndividuo() {
        int idMejor = 0;
        for (int x = 1; x < this.individuos.size(); x++) {
            if (this.individuos.get(x).getFitness() > this.individuos.get(idMejor).getFitness()) {
                idMejor = x;
            }
        }
        return new Individuo(this.individuos.get(idMejor).getGenotipo(), instancias);

    }

    public ArrayList<Individuo> getMuestraAleatoria(int n) {
        // validar que n <= tamaño de la población
        if (n < this.individuos.size()) {
            // creamos un coleccion nueva de individuos
            ArrayList<Individuo> muestra = new ArrayList<>();
            Random ran = new Random();
            for (int x = 0; x < n; x++) {
                int pos = ran.nextInt(this.individuos.size());
                Individuo e = new Individuo(this.individuos.get(pos).getGenotipo(), instancias);
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
                        > this.individuos.get(v + 1).getFitness()) { //si el individuo anterior es mayor que el siguiente
                    Individuo aux = new Individuo(this.individuos.get(v).getGenotipo(), instancias); //almacenamos el individuo anterior
                    this.individuos.set(v, new Individuo(this.individuos.get(v + 1).getGenotipo(), instancias)); //el individuo anterior se convierte en el siguiente
                    this.individuos.set(v + 1, aux); //y el individuo siguiente se convierte en el anterior

                }
            }
        }

    }
    
    public int getFitnessTotal() {
        int fitT = 0;

        for (int i = 0; i < this.individuos.size(); i++) {
            fitT += this.individuos.get(i).getFitness();

        }
        return fitT;
    }

    public ArrayList<Instancias> getInstancias() {
        return instancias;
    }

    public void setInstancias(ArrayList<Instancias> instancias) {
        this.instancias = instancias;
    }
    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOKE
 */
public class GeneticoSAT implements Runnable {

    private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;
    private LinkedList<int[]> muestras;
    ArrayList<Double> gens = new ArrayList<>();
    String salida = "";
    private int MaxNum;
    private int NumMuestras;
    private int version;
    private int tamg;
    boolean a;
    boolean b;
    InterfazPrincipal d;

    public GeneticoSAT(int num_G, double pMuta, int tamPob, int tamg, int MaxNum, int NumMuestras, int version) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.MaxNum = MaxNum;
        this.NumMuestras = NumMuestras;
        this.version = version;
        this.tamg = tamg;
        this.muestras = LeerArchivo.tokenizarDataSet(MaxNum, NumMuestras, version);
        this.pobActual = new Poblacion(tamPob, tamg, this.muestras);

    }

    public GeneticoSAT(InterfazPrincipal d, int num_G, double pMuta, int tamPob, int tamg, int MaxNum, int NumMuestras, int version) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.MaxNum = MaxNum;
        this.NumMuestras = NumMuestras;
        this.version = version;
        this.tamg = tamg;
        this.muestras = LeerArchivo.tokenizarDataSet(MaxNum, NumMuestras, version);
        this.pobActual = new Poblacion(tamPob, tamg, this.muestras);
        this.d = d;
    }

    public void evolucionar() throws IOException {

        int mascara[] = new int[this.pobActual.getPoblacionSAT().get(0).getGenotipo().length];
        Random ran = new Random();
        for (int x = 0; x < mascara.length; x++) {
            mascara[x] = ran.nextInt(2);
        }

        Individuo mejor;

        d.actualizarGrafica(gens);
        for (int g = 0; g < this.num_G; g++) {

            Poblacion nueva = new Poblacion();

            mejor = new Individuo(new int[mascara.length], this.muestras);

            for (int i = 0; i < this.tamPob; i++) {

                Individuo madre = Seleccion.concualseleccion(this.a, this.b, this.pobActual, this.muestras);
                Individuo padre = Seleccion.concualseleccion(this.a, this.b, this.pobActual, this.muestras);
                Individuo hijo = Cruza.op_cruza(madre, padre, mascara, this.muestras);

                if (Math.random() < this.pMuta) {
                    Muta.aplicarMutaAleatoria(hijo, this.muestras);
                }

                nueva.getPoblacionSAT().add(hijo);

                if (hijo.getFitness() > mejor.getFitness()) {
                    mejor = hijo;

                }
            }
            salida += ("\nSoy el mejor de la generacion " + g + " => ");
            salida += mejor.tor2String();

            gens.add(mejor.recuperaFitness());
            d.actualizarGrafica(gens);

            d.setSalida(salida);

            this.pobActual = new Poblacion(nueva, this.muestras);
            // System.out.println("Pmutaaaaaa:" + this.pMuta);
        }
        System.out.println();

    }

    @Override
    public void run() {
        try {
            evolucionar();
        } catch (IOException ex) {
            Logger.getLogger(GeneticoSAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedList<Individuo> getmuestraPob(int nmuestra) {
        LinkedList<Individuo> ordenada = (LinkedList<Individuo>) this.pobActual.getPoblacionSAT().clone();
        Collections.sort(ordenada, new Comparator<Individuo>() {

            @Override
            public int compare(Individuo p1, Individuo p2) {
                return (int) (p2.getFitness() - p1.getFitness());
            }
        });
        LinkedList<Individuo> muestras = new LinkedList<>();
        for (int i = 0; i < nmuestra; i++) {
            muestras.add(ordenada.get(i));

        }
        return muestras;
    }

    public void setmuestraPob(LinkedList<Individuo> LL) {
        LinkedList<Individuo> ordenada = (LinkedList<Individuo>) this.pobActual.getPoblacionSAT().clone();
        Collections.sort(ordenada, new Comparator<Individuo>() {

            @Override
            public int compare(Individuo p1, Individuo p2) {
                return (int) (p2.getFitness() - p1.getFitness());
            }
        });

        LinkedList<Individuo> muestras = new LinkedList<>();
        for (int i = this.tamPob - 1; i > this.tamPob - LL.size(); i--) {
            int r = 0;
            this.pobActual.getPoblacionSAT().set(i, LL.get(r));
            r++;
        }
    }

    

    public void setseleccion(boolean a, boolean b) {
        this.a = a;
        this.b = b;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public double getpMuta() {
        return pMuta;
    }

    public void setpMuta(double pMuta) {
        this.pMuta = pMuta;
    }

    public int getNum_G() {
        return num_G;
    }

    public void setNum_G(int num_G) {
        this.num_G = num_G;
    }

    public Poblacion getPobActual() {
        return pobActual;
    }

    public void setPobActual(Poblacion pobActual) {
        this.pobActual = new Poblacion(pobActual, pobActual.muestras);
        this.tamPob = pobActual.getPoblacionSAT().size();
    }

    public int getTamPob() {
        return tamPob;
    }

    public void setTamPob(int tamPob) {
        this.tamPob = tamPob;
    }

    public LinkedList<int[]> getMuestras() {
        return muestras;
    }

    public void setMuestras(LinkedList<int[]> muestras) {
        this.muestras = muestras;
    }

    public ArrayList<Double> getGens() {
        return gens;
    }

    public void setGens(ArrayList<Double> gens) {
        this.gens = gens;
    }

    public int getMaxNum() {
        return MaxNum;
    }

    public void setMaxNum(int MaxNum) {
        this.MaxNum = MaxNum;
    }

    public int getNumMuestras() {
        return NumMuestras;
    }

    public void setNumMuestras(int NumMuestras) {
        this.NumMuestras = NumMuestras;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) throws IOException {
        this.version = version;
        this.muestras = LeerArchivo.tokenizarDataSet(this.MaxNum, this.NumMuestras, this.version);
    }

    public int getTamg() {
        return tamg;
    }

    public void setTamg(int tamg) {
        this.tamg = tamg;
    }
}

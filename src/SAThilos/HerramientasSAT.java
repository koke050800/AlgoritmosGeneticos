/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;



import java.util.Random;

/**
 *
 * @author working
 */
public class HerramientasSAT {

    public static int[] generarArregloBinarios(int n) {
        int[] arreglo = new int[n];
        Random ran = new Random();
        for (int x = 0; x < n; x++) {
            arreglo[x] = ran.nextInt(2);
        }
        return arreglo;
    }

    public static int[] generarMascaraAleatoria(int dim) {
        int mask[] = new int[dim];
        Random ran = new Random();

        for (int x = 0; x < dim; x++) {
            mask[x] = ran.nextInt(2);
        }
        return mask;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSPinclinaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author KOKE
 */
public class HerramientasTSP {
    
    public static int distancias[][];
    public static int inclinaciones[];

    public static int[][] inicializaCaminos(int n) {
        int[][] caminos = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    caminos[i][j] = 0;
                } else if (caminos[i][j] == 0) {
                    int nuevo = generarCaminoNuevo();
                    caminos[i][j] = nuevo;
                    caminos[j][i] = nuevo;
                }

            }
        }
        return caminos;
    }

    public static void imprimirMat(int distancias[][]) {
        System.out.println("Matriz de distancias");
        for (int i = 0; i < distancias.length; i++) {
            for (int j = 0; j < distancias.length; j++) {

                if (j == distancias.length - 1) {
                    System.out.println(distancias[i][j]);

                } else {
                    System.out.print(distancias[i][j] + ",");
                }

            }
        }

    }

    public static int generarCaminoNuevo() {
        Random ran = new Random();
        int aux = ran.nextInt(10);
        return aux;
    }
    
    public static void generarInclinaciones(int numCiudades, int limInclinacion) {
        inclinaciones = new int[numCiudades];
        Random ran = new Random();

        for (int y = 0; y < numCiudades; y++) {

            int incli = ran.nextInt(limInclinacion) + 1;

            inclinaciones[y] = incli;

        }

    }

//    public static void escribirInclinaciones(int matrizInclinaciones[]) {
//
//        File carpetaGuardar = new File("MatricesTSP");
//        if (!carpetaGuardar.exists()) {
//            carpetaGuardar.mkdirs();
//        }
//        String carpeta = carpetaGuardar.getAbsolutePath();
//
//        //aqui vamos a escribir el archivo de inclinaciones
//        try {
//            FileWriter fileInclinaciones = new FileWriter(carpeta + "\\InclinacionesDeMatrizPrueba.txt");
//            BufferedWriter salidaInclinaciones = new BufferedWriter(fileInclinaciones);
//
//            String renglon = Arrays.toString(matrizInclinaciones);
//            char[] aux = renglon.substring(1, renglon.length() - 1).toCharArray();
//
//            for (int i = 0; i < aux.length; i++) {
//
//                if (aux[i] == 32 || aux[i] == 44) {
//                } else {
//                    salidaInclinaciones.append(aux[i]);
//                    if (i != aux.length - 1) {
//
//                        salidaInclinaciones.append(",");
//                    }
//                }
//
//            }
//            salidaInclinaciones.append("\n");
//            salidaInclinaciones.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(HerramientasTSP.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

            
    
    
    
    
    public static void escribir(int matrizEscribe[][], int matrizInclinaciones[]) {
        File carpetaGuardar = new File("MatricesTSP");
        if (!carpetaGuardar.exists()) {
            carpetaGuardar.mkdirs();
        }
        String carpeta = carpetaGuardar.getAbsolutePath();
        try {

            FileWriter filesin = new FileWriter(carpeta + "\\Matriz " + matrizEscribe[0].length + " x " + matrizEscribe[0].length + ".txt");
            BufferedWriter salida = new BufferedWriter(filesin);
            for (int i = 0; i < matrizEscribe[0].length; i++) {
                String renglon = Arrays.toString(matrizEscribe[i]);
                char[] aux = renglon.substring(1, renglon.length() - 1).toCharArray();
                for (int j = 0; j < aux.length - 1; j++) {
                    if (aux[j] == 32 || aux[j] == 44) {
                    } else {
                        salida.append(aux[j]);
                        salida.append(",");
                    }
                }
                salida.append(aux[aux.length - 1]);
                salida.append("\n");
            }
            salida.close();

            //aqui vamos a escribir el archivo de inclinaciones
            FileWriter fileInclinaciones = new FileWriter(carpeta + "\\InclinacionesDeMatriz " + matrizEscribe[0].length + " x " + matrizEscribe[0].length + ".txt");
            BufferedWriter salidaInclinaciones = new BufferedWriter(fileInclinaciones);

            String renglon = Arrays.toString(matrizInclinaciones);
            char[] aux = renglon.substring(1, renglon.length() - 1).toCharArray();

            for (int i = 0; i < aux.length; i++) {

                if (aux[i] == 32 || aux[i] == 44) {
                } else {
                    salidaInclinaciones.append(aux[i]);
                    if (i != aux.length - 1) {

                        salidaInclinaciones.append(",");
                    }
                }

            }
            salidaInclinaciones.append("\n");
            salidaInclinaciones.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static int[][] cargarMatrizDeDistancias() {
        FileReader archivos = null;
        try {
            String cadenaLeyendo;
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);
            ArrayList<ArrayList<Integer>> matriz = new ArrayList();
            if (abre != null) {
                int i = 0;

                while ((cadenaLeyendo = lee.readLine()) != null) {
                    String[] renglon = cadenaLeyendo.split(",");

                    ArrayList<Integer> renglonArrayList = new ArrayList();
                    for (int j = 0; j < renglon.length; j++) {
                        renglonArrayList.add(Integer.parseInt(renglon[j]));
                    }
                    matriz.add(renglonArrayList);

                    i++;
                }
                lee.close();

            }
            distancias = new int[matriz.size()][matriz.size()];
            for (int i = 0; i < matriz.size(); i++) {
                for (int j = 0; j < matriz.get(0).size(); j++) {
                    distancias[i][j] = matriz.get(i).get(j);
                }

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return distancias;

    }
    
    public static int[] cargarInclinaciones() {
        FileReader archivos = null;
        try {
            String cadenaLeyendo;
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();
            archivos = new FileReader(abre);
            BufferedReader lee = new BufferedReader(archivos);

            if (abre != null) {

                String[] valores = lee.readLine().split(",");
                inclinaciones = new int[valores.length];
                for (int x = 0; x < valores.length; x++) {
                    //System.out.println(valores[x]);
                    inclinaciones[x] = Integer.parseInt(valores[x]);
                }

                lee.close();

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                archivos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return inclinaciones;

    }
    

    

    public static int[] getInclinaciones() {
        return inclinaciones;
    }

    public static void setInclinaciones(int[] inclinaciones) {
        HerramientasTSP.inclinaciones = inclinaciones;
    }

    public static void main(String[] args) {

//        int[] inclinacionesPrueba = new int[]{1,2,3,5,8};
//        escribirInclinaciones(inclinacionesPrueba);
        
        int[] inclinacionesPrueba = cargarInclinaciones().clone();
        for (int i = 0; i < inclinacionesPrueba.length; i++) {
            System.out.println("" + inclinacionesPrueba[i]);

        }


    }


}

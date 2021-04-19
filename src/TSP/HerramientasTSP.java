/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

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
import javax.swing.JFileChooser;

/**
 *
 * @author KOKE
 */
public class HerramientasTSP {
    
    public static int distancias[][];

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
    
    public static void escribir(int matrizEscribe[][]) {
        File carpetaGuardar = new File("MatricesTSP");
        if (!carpetaGuardar.exists()) {
            carpetaGuardar.mkdirs();
        }        
        String carpeta = carpetaGuardar.getAbsolutePath();
        try {

            FileWriter filesin = new FileWriter(carpeta + "\\Matriz "+matrizEscribe[0].length+" x "+matrizEscribe[0].length+".txt");
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

}

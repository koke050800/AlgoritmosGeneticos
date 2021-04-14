/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuardarArchivos;

import ReinasCHIDO.Individuo;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 *
 * @author KOKE
 */
public class Archivo {

    public static void escribir(ArrayList<Individuo> poblacion) {
        File carpetaGuardar = new File("PoblacionAlmacenada");
        carpetaGuardar.mkdirs();
        String carpeta = carpetaGuardar.getAbsolutePath();
        try {
            //System.out.println("SIZE ACA>> "+poblacion.size());
            FileWriter filesin = new FileWriter(carpeta + "\\MejoresIndividuos_nGuardados" + poblacion.size() + "_tamIndividuos" + poblacion.get(0).getGenotipo().length + ".txt");
            BufferedWriter salida = new BufferedWriter(filesin);
            for (int i = 0; i < poblacion.size(); i++) {
                String individuo = Arrays.toString(poblacion.get(i).getGenotipo());
                char[] aux = individuo.substring(1, individuo.length() - 1).toCharArray();
                for (int j = 0; j < aux.length-1; j++) {
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

    public static ArrayList<Individuo> tokenizarDataSet() throws IOException {
        // ventana para abrir el txt

        String texto, aux;
        LinkedList<String> lista = new LinkedList();
        ArrayList<Individuo> reinas = new ArrayList<>();
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                String claseComp = "";
                int n = 0;
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    int[] vector = new int[lista2.size()];

                    for (int x = 0; x < lista2.size() - 1; x++) {
                        vector[x] = Integer.parseInt(lista2.get(x));
                    }

                    claseComp = clase;
                    clase = lista2.get(lista2.size() - 1);

                    reinas.add(new Individuo(vector));

                    lista2.clear();
                }

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return reinas;
    }

}
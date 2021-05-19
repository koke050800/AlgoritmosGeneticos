/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author KOKE
 */
public class ArchivosSAT {

    public static void escribir(ArrayList<Individuo> poblacion) {
        File carpetanueva = new File("PoblacionesSAT");
        carpetanueva.mkdirs();
        String carpeta = carpetanueva.getAbsolutePath();
        try {
            FileWriter filesin = new FileWriter(carpeta + "\\Poblacion_" + poblacion.size() + "Individuos_" + poblacion.get(0).getGenotipo().length + "Genes.txt");
            BufferedWriter salida = new BufferedWriter(filesin);
            for (int i = 0; i < poblacion.size(); i++) {
                String individuo = Arrays.toString(poblacion.get(i).getGenotipo());
                char[] aux = individuo.substring(1, individuo.length() - 1).toCharArray();
                for (int j = 0; j < aux.length - 1; j++) {
                    if (aux[j] == 32 || aux[j] == 44) {
                        //salida.append("horno");
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
            Logger.getLogger(ArchivosSAT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosSAT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Instancias> tokenizarDataSet() throws IOException {
        // ventana para abrir el txt

        String texto, aux;
        LinkedList<String> lista = new LinkedList();
        ArrayList<Instancias> individuos = new ArrayList<>();
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
                    StringTokenizer st = new StringTokenizer(lista.get(i), " ");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }

                    int[] vector = new int[lista2.size()];

                    for (int x = 0; x < lista2.size(); x++) {
                        vector[x] = Integer.parseInt(lista2.get(x));
                    }

                    claseComp = clase;
                    clase = lista2.get(lista2.size() - 1);

                    individuos.add(new Instancias(vector));                    
                    lista2.clear();
                }

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return individuos;
    }

}

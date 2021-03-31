/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.chart.plot.XYPlot;

/**
 *
 * @author KOKE
 */
public class Histograma {


    private int[] fitnessMejores;

    public Histograma(int fitnessMejores[]) {
        this.fitnessMejores = new int[fitnessMejores.length];
        this.fitnessMejores = fitnessMejores.clone();
    }

    public void graficar() {
        Grafica g1 = new Grafica("Numero de Generacion", "Fitness", "Fitness de por generacion del problema N Reinas");
        g1.crearSerie("Fitness", this.fitnessMejores);
        g1.mostrarGrafica();

    }

    public int[] getFitnessMejores() {
        return fitnessMejores;
    }

    public void setFitnessMejores(int[] fitnessMejores) {
        this.fitnessMejores = fitnessMejores;
    }
    
    



}

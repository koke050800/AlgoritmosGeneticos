/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;


import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author KOKE
 */
public class Grafica {

    private JFreeChart grafica;
    private XYSeriesCollection series;
    private String ejeX, ejeY, titulo;

    public Grafica(String ejeX, String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.titulo = titulo;
    }

    public void crearSerie(String nombre, int[] datos) {

        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x = 0; x < datos.length; x++) {
            serie.add(x, datos[x]);
        }
        // agregamos la serie que se generÃ³ 
        this.series.addSeries(serie);
    }

    public void crearSerie(String nombre, ArrayList<Integer> datos) {

        XYSeries serie = new XYSeries(nombre);
        // agregar cada uno de los datos en la serie 
        for (int x = 0; x < datos.size(); x++) {
            serie.add(x, datos.get(x));
        }
        // agregamos la serie que se generÃ³

        this.series.addSeries(serie);
    }

    public void crearGrafica() {
        this.grafica = ChartFactory.createXYLineChart(titulo, ejeX, ejeY, series, PlotOrientation.VERTICAL, true, true, true);
    }

    public void crearYmostrarGrafica() {

        this.grafica = ChartFactory.createXYLineChart(titulo, ejeX, ejeY, series);
        // crear un panel con la grafica
        ChartFrame panel = new ChartFrame(null, grafica);
        panel.pack();
        panel.setVisible(true);

    }

    public ChartPanel crearChartPanel(Dimension d) {
        ChartPanel chartpanel = new ChartPanel(grafica);
        chartpanel.setVisible(true);
        chartpanel.setSize(d);
        return chartpanel;
    }

    public JFreeChart getGrafica() {
        return this.grafica;
    }

}

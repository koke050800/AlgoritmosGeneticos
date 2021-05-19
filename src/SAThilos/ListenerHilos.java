/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author KOKE
 */
public class ListenerHilos implements ActionListener {

    private JFrameMuta frameMuta;
    private GeneticoSAT genetico;
    
    public ListenerHilos(JFrameMuta frameMuta, GeneticoSAT genetico) {
        this.frameMuta = frameMuta;
        this.genetico = genetico;
    }
    
    public void actionPerformed(ActionEvent e) {
        double muta = Double.parseDouble(frameMuta.getjTextFieldMuta().getText());

        // modificar los valores de la muta en el hilo
        genetico.setpMuta(muta);
    }
    
}

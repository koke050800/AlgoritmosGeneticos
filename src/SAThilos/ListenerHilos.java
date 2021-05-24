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

//    private JFrameMuta frameMuta;
    private JFrameCambios frameCambios;
    private GeneticoSAT genetico;
    
//    public ListenerHilos(JFrameMuta frameMuta, GeneticoSAT genetico) {
//        this.frameMuta = frameMuta;
//        this.genetico = genetico;
//    }
    public ListenerHilos(JFrameCambios frameCambios, GeneticoSAT genetico) {
        this.frameCambios = frameCambios;
        this.genetico = genetico;
    }

    public void actionPerformed(ActionEvent e) {

        // modificar los valores del hilo
        if (!frameCambios.getjTextFieldMuta().getText().isEmpty()) {
            double muta = Double.parseDouble(frameCambios.getjTextFieldMuta().getText());
            genetico.setpMuta(muta);
        } else {
            //no hacemos nada
        }

        if (!frameCambios.getjTextFieldTamPob().getText().isEmpty()) {
            int pob = Integer.parseInt(frameCambios.getjTextFieldTamPob().getText());
            genetico.setTamPoblacion(pob);
        } else {

            //no hacemos nada
        }

        if (!frameCambios.getjTextFieldNgen().getText().isEmpty()) {
            int generaciones = Integer.parseInt(frameCambios.getjTextFieldNgen().getText());
            genetico.setNumGeneraciones(generaciones);
        } else {
            //no hacemos nada
        }

        //para la seleccion
        if (this.frameCambios.getSeleccionAleatoria().isSelected()) {
            this.genetico.setSeleccion(1);
        } else if (this.frameCambios.getSeleccionTorneo().isSelected()) {
            this.genetico.setSeleccion(2);
        } else if (this.frameCambios.getSeleccionRuleta().isSelected()) {
            this.genetico.setSeleccion(3);
        } else {
            this.genetico.getSeleccion(); //si no se selecciona, que se quede en la que estaba
        }

    }
    
}

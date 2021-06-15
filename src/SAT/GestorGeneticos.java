/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author KOKE
 */
public class GestorGeneticos {

    private final ArrayList<InterfazPrincipal> iterfacesGeneticos = new ArrayList<>();

    public GestorGeneticos(int numGeneticos) throws IOException {
        for (int x = 0; x < numGeneticos; x++) {
            InterfazPrincipal interfazPrincipla = new InterfazPrincipal(x, this);
            interfazPrincipla.setVisible(true);
            iterfacesGeneticos.add(interfazPrincipla);
        }
    }

    public void intercambiarIndividuos(int origen, int destino, int muestra) {
        // el criterio de intercambio es el primero
        InterfazPrincipal geneticoDestino = this.iterfacesGeneticos.get(destino);
        InterfazPrincipal geneticoOrigen = this.iterfacesGeneticos.get(origen);
        geneticoDestino.geneticoSAT.setmuestraPob(geneticoOrigen.geneticoSAT.getmuestraPob(muestra));
        geneticoDestino.setjTextField2("" + geneticoOrigen.geneticoSAT.getTamPob());
        geneticoDestino.gestorGUI.setjTextFieldPoblacionTam("" + geneticoOrigen.geneticoSAT.getTamPob());
    }

}

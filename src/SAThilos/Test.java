/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAThilos;





import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author KOKE
 */
public class Test {

    public static void main(String[] args) throws IOException {

        int numGeneraciones = 200000;
        int tamPoblacion = 70;
        int tamIndividuos = 100;
        double pMuta = 0.20;
        
        

        int[] mask = HerramientasSAT.generarMascaraAleatoria(tamIndividuos);
        ArrayList<Instancias> instancias = ArchivosSAT.tokenizarDataSet();

        
        GeneticoSAT satBooleana = new GeneticoSAT(numGeneraciones, tamPoblacion, tamIndividuos, pMuta, mask, instancias);
        
        JFrameMuta frame = new JFrameMuta(satBooleana);
        frame.setVisible(true);

    }

}

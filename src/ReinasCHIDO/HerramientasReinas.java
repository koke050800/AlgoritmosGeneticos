/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinasCHIDO;

import java.util.Random;

/**
 *
 * @author working
 */
public class HerramientasReinas {

    public static int[] crearGenotipoAleatorioReinas(int n) {
        int[] temp = new int[n];
        Random ran = new Random();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ran.nextInt(n);
        }
        return temp;
    }

}

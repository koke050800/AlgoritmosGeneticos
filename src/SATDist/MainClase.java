/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class MainClase {
    
    public static void main(String[] args) throws IOException, RemoteException, NotBoundException {

    InterfazPrincipal GG = new InterfazPrincipal(1);
    GG.setVisible(true);
     
        
    }
    
    
}

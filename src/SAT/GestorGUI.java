/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import SAT.Grafica;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Dell
 */
public class GestorGUI extends javax.swing.JFrame {

    /**
     * Creates new form Data
     */
    GeneticoSAT geneticoSAT;

    public GestorGUI(GeneticoSAT geneticoSAT, int ident) throws IOException {
        initComponents();
        this.geneticoSAT = geneticoSAT;
        this.setTitle("Gestor del Genetico #" + ident);

        jTextFieldPoblacionTam.setText(String.valueOf(geneticoSAT.getTamPob()));

    }
    
    public int getjTextFieldMuestrasEnviar() {
        return Integer.parseInt(jTextFieldMuestrasEnviar.getText());
    }

    public void setjTextFieldMuestrasEnviar(JTextField jTextFieldMuestrasEnviar) {
        this.jTextFieldMuestrasEnviar = jTextFieldMuestrasEnviar;
    }
    
    public JTextField getjTextFieldPoblacionTam() {
        return jTextFieldPoblacionTam;
    }

    public void setjTextFieldPoblacionTam(String jTextFieldPoblacionTam) {
        this.jTextFieldPoblacionTam.setText(jTextFieldPoblacionTam);
    }

    public int getdestino() {

        return Integer.parseInt(this.jTextFieldDestinito.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDestino = new javax.swing.JLabel();
        jTextFieldDestinito = new javax.swing.JTextField();
        jLabelPob = new javax.swing.JLabel();
        jTextFieldPoblacionTam = new javax.swing.JTextField();
        jTextFieldMuestrasEnviar = new javax.swing.JTextField();
        jLabelMuestras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor Gen#");

        jLabelDestino.setText("Genético de destino:");

        jLabelPob.setText("Tamaño de la Población:");

        jTextFieldPoblacionTam.setEditable(false);
        jTextFieldPoblacionTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPoblacionTamActionPerformed(evt);
            }
        });

        jLabelMuestras.setText(" Miuestras a enviar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMuestras)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelPob, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelDestino)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldMuestrasEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jTextFieldPoblacionTam, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDestinito, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPob)
                    .addComponent(jTextFieldPoblacionTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMuestrasEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMuestras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDestino)
                    .addComponent(jTextFieldDestinito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPoblacionTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPoblacionTamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPoblacionTamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDestino;
    private javax.swing.JLabel jLabelMuestras;
    private javax.swing.JLabel jLabelPob;
    private javax.swing.JTextField jTextFieldDestinito;
    private javax.swing.JTextField jTextFieldMuestrasEnviar;
    private javax.swing.JTextField jTextFieldPoblacionTam;
    // End of variables declaration//GEN-END:variables

}

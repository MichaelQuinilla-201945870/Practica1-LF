    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.monterroso.pract1.analizador;
import com.monterroso.pract1.analizador.frontend.VentanaPrincipal;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author seo
 */
public class Practica1LF {
    
    public static void main(String[] args) {
        
        
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored) {
                }
                break;
            }
        }
        
        
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

}

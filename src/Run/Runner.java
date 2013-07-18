/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import main_package.LoginUI;
import main_package.MainUI;

/**
 *
 * @author yajnesh
 */
public class Runner {

    public dbConnect dbConObj;
    public MainUI MainUIObj;
    public LoginUI LoginUIObj;
    public static Runner RunnerObj;
    //
    public String prevDirectory;
    //

    public Runner() {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */



        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                // Create a new Connection to database
                dbConObj = new dbConnect();
                //Create Login Window
                LoginUIObj = new LoginUI();
                LoginUIObj.setVisible(true);
            }
        });
    }

    public static void main(String args[]) {

        RunnerObj = new Runner();

    }
}

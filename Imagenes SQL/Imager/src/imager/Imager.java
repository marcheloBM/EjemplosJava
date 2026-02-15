package imager;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class Imager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PopupDatos dialog = new PopupDatos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });               
            }
        });
        
         
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeerClientes().setVisible(true);
            }
        });*/
    }
}

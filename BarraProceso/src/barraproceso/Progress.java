/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barraproceso;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Marchelo
 */
public class Progress extends SwingWorker<Integer, String>{

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the jpbar
     */
    public JProgressBar getJpbar() {
        return jpbar;
    }

    /**
     * @param jpbar the jpbar to set
     */
    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }

    /**
     * @return the txtArea
     */
    public JTextArea getTxtArea() {
        return txtArea;
    }

    /**
     * @param txtArea the txtArea to set
     */
    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    private JLabel label;
    private JProgressBar jpbar;
    private JTextArea txtArea;

    public Progress(JLabel label, JProgressBar jpbar, JTextArea txtArea) {
        this.label = label;
        this.jpbar = jpbar;
        this.txtArea = txtArea;
    }
    
    
    @Override
    protected Integer doInBackground() throws Exception {
        getLabel().setVisible(true);
        getJpbar().setIndeterminate(true);
        //tenemos que poner nuestro proceso
        try {
            for (int i = 0; i < 100; i++) {
                getTxtArea().append("Proceso en: "+i+"\n");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        
        
        
        getLabel().setVisible(false);
        getJpbar().setIndeterminate(false);
       return 0;
    }
    
}

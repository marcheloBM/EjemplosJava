/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout; 
import java.awt.Container; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.lang.reflect.InvocationTargetException; 

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JProgressBar; 
import javax.swing.SwingUtilities; 
/**
 *
 * @author Marchelo
 */
public class Main { 
    
    // Hace trabajar a la barra 
    static class HiloDeLaBarra extends Thread { 
        private static int RETARDO = 500; 
        JProgressBar Barra; 
            
        // Constructor 
        public HiloDeLaBarra(JProgressBar barra) { 
            Barra = barra; 
        } 

        // Subrutina que incrementa la barra de progreso 
        public void run() { 
            int minimo = Barra.getMinimum(); 
            int maximo = Barra.getMaximum(); 
            
            Runnable Incrementa = new Runnable() 
            { 
                public void run() { 
                    int valor = Barra.getValue(); 
                    Barra.setValue(valor + 1); 
                } 
            }; 

            for (int i = minimo; i < maximo; i++) { 
                try { 
                    SwingUtilities.invokeAndWait(Incrementa); 
                    Thread.sleep(RETARDO); 
                } catch (InterruptedException ignoredException) {} catch (InvocationTargetException ignoredException) {} 
            } 
        } 
    } 
    
    /** 
     * @param args the command line arguments 
     */ 
    public static void main(String[] args) { 
        
        // Creamos una barra de progreso 
        final JProgressBar BarraDeProgreso = new JProgressBar(0, 100); 
        BarraDeProgreso.setStringPainted(true); 

        // Creamos un boton 
        final JButton Boton = new JButton("Comenzar!!"); 

        // Creamos un evento pulsar para el boton 
        ActionListener actionListener = new ActionListener() { 
          public void actionPerformed(ActionEvent e) { 
            Boton.setEnabled(false); 
            Thread Hilo = new HiloDeLaBarra(BarraDeProgreso); 
            Hilo.start(); // Lo ejecuta 
          } 
        }; 
        Boton.addActionListener(actionListener); 
        
        // Creamos un formulario que contendrá un panel 
        String titulo = (args.length == 0 ? "Barra de progreso (DEMO)" : args[0]); 
        JFrame formulario = new JFrame(titulo);        
        
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // creamos y añadimos un panel que contenga el boton y la barra de progreso 
        Container panel = formulario.getContentPane(); 
        panel.add(BarraDeProgreso, BorderLayout.NORTH); 
        panel.add(Boton, BorderLayout.SOUTH); 
        panel.setSize(300, 200); 
        panel.setVisible(true); 

        formulario.setBounds(0, 0, 300, 300); 
        formulario.setVisible(true); 
        
    }  
}
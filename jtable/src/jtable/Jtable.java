/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jtable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.TableCellRenderer;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author march
 */
public class Jtable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JTable table = new JTable( new ExampleTableModel() ); 
        TableCellRenderer renderer = new CustomTableCellRenderer();

		try
		{
			table.setDefaultRenderer( Class.forName( "java.lang.Integer" ), renderer );
		}
		catch( ClassNotFoundException ex )
		{	
			System.exit( 0 );
		}

		JFrame frame = new JFrame();
		frame.addWindowListener( 
			new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) 
				{
					System.exit(0);
				}
			}
		);

		frame.getContentPane().add( table );
		frame.pack();
		frame.setVisible( true );
    }
    
}

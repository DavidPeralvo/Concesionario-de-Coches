package gui;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Abrir extends JDialog {
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
	JComponent contentPanel;

	
	public Abrir() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
        
	}

}

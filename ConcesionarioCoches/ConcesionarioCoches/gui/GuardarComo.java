package gui;

import java.io.File;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GuardarComo extends JDialog {
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
	private final JPanel contentPanel = new JPanel();
	
	public GuardarComo() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showSaveDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	Principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
	}

}

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PanelOptions extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private InterfazPolynomial main;

	public PanelOptions(InterfazPolynomial main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
	}

}

package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String CLEAN = "clean";
	public static final String READY = "ready";
	public static final String GENERATE = "generate";
	
	private InterfazPolynomial main;
	private JButton clean;
	private JButton ready;
	private JButton generate;

	public PanelOptions(InterfazPolynomial main) {
		this.main = main;
		
		clean = new JButton("Clean");
		ready = new JButton("Ready");
		generate = new JButton("Generate");
		
		setLayout(new GridLayout(1,3,5,5));
		
		
		add(clean);
		add(ready);
		add(generate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(CLEAN)){
			
		}

		else if(command.equals(READY)){
			
		}

		else if(command.equals(GENERATE)){
			
        }
	}
}

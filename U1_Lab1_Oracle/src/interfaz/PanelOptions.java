package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
		clean.addActionListener(this);
		clean.setActionCommand(CLEAN);
		
		ready = new JButton("Ready");
		ready.addActionListener(this);
		ready.setActionCommand(READY);
		
		generate = new JButton("Generate");
		generate.addActionListener(this);
		generate.setActionCommand(GENERATE);
		
		setLayout(new GridLayout(1,3,5,5));
		
		
		add(clean);
		add(ready);
		add(generate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(CLEAN)){
			main.Clean();
		}

		else if(command.equals(READY)){
			main.Solution();
		}

		else if(command.equals(GENERATE)){
			try{
		    	String grade = JOptionPane.showInputDialog("Insert Grade of Polynomial to generate");
		    	
		    	int gra = Integer.parseInt(grade);
		    	if(gra>10){
//     JOptionPane.showMessageDialog(null, "the program only accep");
		    	}
		    	else{
			    main.Generate(gra);
		    	}
			}
			catch(Exception ex){
	    		ex.printStackTrace();
	    	}
        }
	}
}

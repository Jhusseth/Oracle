package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	public static final String WRITE = "write";
	
	private InterfazPolynomial main;
	private JButton clean;
	private JButton ready;
	private JButton generate;
	private JButton write;
	
	
	int grado = 0;

	public PanelOptions(InterfazPolynomial main) {
		this.main = main;
		grado =0;
		
		clean = new JButton("Clean");
		clean.addActionListener(this);
		clean.setActionCommand(CLEAN);
		
		ready = new JButton("Ready");
		ready.addActionListener(this);
		ready.setActionCommand(READY);
		
		generate = new JButton("Generate");
		generate.addActionListener(this);
		generate.setActionCommand(GENERATE);
		
		write = new JButton("Write");
		write.addActionListener(this);
		write.setActionCommand(WRITE);
		
		setLayout(new GridLayout(1,6,5,15));
		
		add(new JLabel("  "));
		add(clean);
		add(write);
		add(ready);
		add(generate);
		add(new JLabel("  "));
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals(CLEAN)){
			main.Clean();
		}

		else if(command.equals(READY)){
			if(main.getArray().isEmpty()){
				JOptionPane.showMessageDialog(null, "there aren't polynomials to solve");
			}
			else{
				main.Solution();
			}
		}

		else if(command.equals(GENERATE)){
			try{
		    	String grade = JOptionPane.showInputDialog("Insert Grade of Polynomial to generate");
		    	
		    	 grado = Integer.parseInt(grade);
		    	if(grado>10){
                   JOptionPane.showMessageDialog(null, "the program only accepts \n         up to grade 10");
		    	}
		    	else{
			    main.Generate(grado);
			    main.disableWrite();
		    	}
			}
			catch(Exception ex){
	    		ex.printStackTrace();
	    	}
        }
		
		else  if(command.equals(WRITE)){
			main.activeWrite();
		}
	}
}

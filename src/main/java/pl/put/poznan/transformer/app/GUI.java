import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frmTextTransformer;
	private JTextArea txtrTextField;
	private JPanel panel;
	private JButton btnUpper;
	private JButton btnLower;
	private JButton btnCapital;
	private JLabel label;
	private JPanel panel_1;
	private JButton btnFull;
	private JButton btnAbbr;
	private JLabel lblAbbreviation;
	private JLabel lblTextTransformer;
	private JPanel panel_2;
	private JButton btnToLatex;
	private JButton btnNoRepeats;
	private JButton btnInverse;
	private JLabel lblOther;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		frmTextTransformer = new JFrame();
		frmTextTransformer.setTitle("Text transformer");
		frmTextTransformer.setBounds(100, 100, 1170, 823);
		frmTextTransformer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextTransformer.getContentPane().setLayout(null);
		
		txtrTextField = new JTextArea();
		txtrTextField.setFont(new Font("Lato", Font.PLAIN, 15));
		txtrTextField.setBounds(32, 296, 1102, 490);
		frmTextTransformer.getContentPane().add(txtrTextField);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.select"));
		panel.setBounds(32, 209, 403, 57);
		frmTextTransformer.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnUpper = new JButton("UPPER");
		btnUpper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(UpperTransformer(txtrTextField.getText()));
			}
		});
		btnUpper.setToolTipText("Change every letter of sentences to big size");
		btnUpper.setBounds(12, 12, 117, 25);
		panel.add(btnUpper);
		
		btnLower = new JButton("lower");
		btnLower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(LowerTransformer(txtrTextField.getText()));
			}
		});
		btnLower.setToolTipText("Change every letter of sentences to small size");
		btnLower.setBounds(141, 12, 117, 25);
		panel.add(btnLower);
		
		btnCapital = new JButton("Capital");
		btnCapital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(CapitalizeTransformer(txtrTextField.getText()));
			}
		});
		btnCapital.setToolTipText("Change every first letter of sentences to big size");
		btnCapital.setBounds(270, 12, 117, 25);
		panel.add(btnCapital);
		
		label = new JLabel("Letter's size:");
		label.setFont(new Font("DialogInput", Font.BOLD, 20));
		label.setBounds(32, 182, 177, 15);
		frmTextTransformer.getContentPane().add(label);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(UIManager.getColor("Button.select"));
		panel_1.setBounds(447, 209, 272, 57);
		frmTextTransformer.getContentPane().add(panel_1);
		
		btnFull = new JButton("No Abbreviation");
		btnFull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(AbbrevivationToTextTransformer(txtrTextField.getText()));
			}
		});
		btnFull.setToolTipText("Expands abbreviation (prof. -> profesor)");
		btnFull.setBounds(12, 12, 117, 25);
		panel_1.add(btnFull);
		
		btnAbbr = new JButton("Abbr.");
		btnAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(TextToAbbrevivationTransformer(txtrTextField.getText()));
			}
		});
		btnAbbr.setToolTipText("Сuts words to abbreviation (profesor -> prof. )");
		btnAbbr.setBounds(141, 12, 117, 25);
		panel_1.add(btnAbbr);
		
		lblAbbreviation = new JLabel("Abbreviation:");
		lblAbbreviation.setFont(new Font("DialogInput", Font.BOLD, 20));
		lblAbbreviation.setBounds(447, 182, 177, 15);
		frmTextTransformer.getContentPane().add(lblAbbreviation);
		
		lblTextTransformer = new JLabel("Text transformer");
		lblTextTransformer.setFont(new Font("Liberation Sans Narrow", Font.BOLD | Font.ITALIC, 71));
		lblTextTransformer.setBounds(381, 56, 493, 70);
		frmTextTransformer.getContentPane().add(lblTextTransformer);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(UIManager.getColor("Button.select"));
		panel_2.setBounds(731, 209, 403, 57);
		frmTextTransformer.getContentPane().add(panel_2);
		
		btnToLatex = new JButton("To Latex");
		btnToLatex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(LatexTransformer(txtrTextField.getText()));
			}
		});
		btnToLatex.setToolTipText("Transform text to LateX format");
		btnToLatex.setBounds(12, 12, 117, 25);
		panel_2.add(btnToLatex);
		
		btnNoRepeats = new JButton("No Repeats");
		btnNoRepeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(RepetitionTransformer(txtrTextField.getText()));
			}
		});
		btnNoRepeats.setToolTipText("Delete all repeats");
		btnNoRepeats.setBounds(141, 12, 117, 25);
		panel_2.add(btnNoRepeats);
		
		btnInverse = new JButton("Inverse");
		btnInverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtrTextField.setText(InverseTransformer(txtrTextField.getText(), txtrTextField.getSelectionStart(), txtrTextField.getSelectionEnd()-1));
			}
		});
		btnInverse.setToolTipText("Inverts chosen text");
		btnInverse.setBounds(270, 12, 117, 25);
		panel_2.add(btnInverse);
		
		lblOther = new JLabel("Other:");
		lblOther.setBounds(731, 182, 177, 15);
		frmTextTransformer.getContentPane().add(lblOther);
		lblOther.setFont(new Font("DialogInput", Font.BOLD, 20));
		frmTextTransformer.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtrTextField, panel, btnUpper, btnLower, btnCapital, label, panel_1, btnFull, btnAbbr, lblAbbreviation, lblTextTransformer}));
		frmTextTransformer.setVisible(true);
	}
	
}

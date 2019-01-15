import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

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
				choose("upper");
			}
		});
		btnUpper.setToolTipText("Change every letter of sentences to big size");
		btnUpper.setBounds(12, 12, 117, 25);
		panel.add(btnUpper);
		
		btnLower = new JButton("lower");
		btnLower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose("lower");
			}
		});
		btnLower.setToolTipText("Change every letter of sentences to small size");
		btnLower.setBounds(141, 12, 117, 25);
		panel.add(btnLower);
		
		btnCapital = new JButton("Capital");
		btnCapital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose("capitalize");
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
				choose("abbrevivationtotext");
			}
		});
		btnFull.setToolTipText("Expands abbreviation (prof. -> profesor)");
		btnFull.setBounds(12, 12, 117, 25);
		panel_1.add(btnFull);
		
		btnAbbr = new JButton("Abbr.");
		btnAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose("texttoabbrevivation");
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
				choose("latex");
			}
		});
		btnToLatex.setToolTipText("Transform text to LateX format");
		btnToLatex.setBounds(12, 12, 117, 25);
		panel_2.add(btnToLatex);
		
		btnNoRepeats = new JButton("No Repeats");
		btnNoRepeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose("repetition");
			}
		});
		btnNoRepeats.setToolTipText("Delete all repeats");
		btnNoRepeats.setBounds(141, 12, 117, 25);
		panel_2.add(btnNoRepeats);
		
		btnInverse = new JButton("Inverse");
		btnInverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose("inverse");
			}
		});
		btnInverse.setToolTipText("Inverts chosen text");
		btnInverse.setBounds(270, 12, 117, 25);
		panel_2.add(btnInverse);
		
		lblOther = new JLabel("Other:");
		lblOther.setBounds(731, 182, 177, 15);
		frmTextTransformer.getContentPane().add(lblOther);
		lblOther.setFont(new Font("DialogInput", Font.BOLD, 20));
		frmTextTransformer.setVisible(true);
	}
	
	public String Get(String txt, String transforms) {
		
		String text = txt.replace("\\",",,,,,,,,,,,");
		text = text.replace("?","%3F");
		//text = text.replace("/","%2F");
		
		String query = "http://localhost:8080/"+text.replace(" ", "%20")+"?transforms="+transforms+"&";
		
		StringBuilder sb = new StringBuilder();
		
		HttpURLConnection con = null;
		
		try {
			con = (HttpURLConnection) new URL(query).openConnection();
			
			con.setRequestMethod("GET");
			con.setUseCaches(false);
			con.setConnectTimeout(250);
			con.setReadTimeout(250);
			
			con.connect();
			
			
			if (HttpURLConnection.HTTP_OK == con.getResponseCode() ) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String line;
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
				text = sb.toString();
				
			}else {
				System.out.println("fail: " + con.getResponseCode() + ", " + con.getResponseMessage());
				sb.append(txt);
			}
		}catch (Throwable cause) {
			cause.printStackTrace();
		}finally {
			if(con != null)
				con.disconnect();
		}
		return text.replace(",,,,,,,,,,,","\\");
	}
	public String lines(String txt, String transforms) {
		String[] lines = txt.split(System.getProperty("line.separator"));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < lines.length - 1; i++)
		{
			sb.append(Get(lines[i], transforms));
			sb.append("\n");
		}
		sb.append(Get(lines[lines.length - 1], transforms));
		
		return sb.toString();
	}
	
	public void choose(String transforms) {
		int strt = txtrTextField.getSelectionStart();
		int fnsh = txtrTextField.getSelectionEnd();
		String txt = txtrTextField.getSelectedText();
		if(txt != null)
		{
			txtrTextField.setSelectionStart(strt);
			txtrTextField.setSelectionEnd(fnsh);
			txtrTextField.replaceSelection(lines(txtrTextField.getSelectedText(), transforms));
		}
		else
			txtrTextField.setText(lines(txtrTextField.getText(), transforms));
	}
	
}

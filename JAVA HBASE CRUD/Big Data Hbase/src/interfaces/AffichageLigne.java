package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AffichageLigne extends JFrame {

	private JPanel contentPane;
	private JTextField tableName;
	private JTextField id;
	private JTextField FC;
	private JTextField qualifier;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageLigne frame = new AffichageLigne();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AffichageLigne() {
		setBackground(Color.LIGHT_GRAY);
		setType(Type.UTILITY);
		setTitle("AFFICHAGE LIGNE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 519);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillezEntrerLa = new JLabel("Veuillez Entrer la Table \u00E0 Afficher");
		lblVeuillezEntrerLa.setBounds(0, 0, 0, 0);
		lblVeuillezEntrerLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezEntrerLa.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		contentPane.add(lblVeuillezEntrerLa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom de la Table");
		lblNewLabel_1_1.setBounds(0, 0, 0, 0);
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblVeuillezEntrerLa_2 = new JLabel("Veuillez Entrer la Ligne \u00E0 Afficher");
		lblVeuillezEntrerLa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezEntrerLa_2.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblVeuillezEntrerLa_2.setBounds(135, 50, 364, 36);
		contentPane.add(lblVeuillezEntrerLa_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom de la Table");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(98, 132, 188, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		tableName = new JTextField();
		tableName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		tableName.setColumns(10);
		tableName.setBounds(296, 132, 203, 34);
		contentPane.add(tableName);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Identifiant");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(98, 179, 190, 32);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		id = new JTextField();
		id.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		id.setColumns(10);
		id.setBounds(296, 179, 203, 34);
		contentPane.add(id);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Famille de Colonne");
		lblNewLabel_1_1_1_2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(98, 227, 191, 32);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		FC = new JTextField();
		FC.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		FC.setColumns(10);
		FC.setBounds(296, 227, 203, 34);
		contentPane.add(FC);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Qualifier");
		lblNewLabel_1_1_1_3.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_3.setBounds(98, 279, 193, 32);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		qualifier = new JTextField();
		qualifier.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		qualifier.setColumns(10);
		qualifier.setBounds(296, 279, 203, 34);
		contentPane.add(qualifier);
		
		JButton btnRetourMenu = new JButton("Retour");
		btnRetourMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Menu menu=new Menu();
			menu.show();
			dispose();
			}
		});
		btnRetourMenu.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnRetourMenu.setBounds(188, 346, 122, 30);
		contentPane.add(btnRetourMenu);
		
		JButton btnValiderCreation = new JButton("Valider");

		JButton btnValiderAl = new JButton("Valider");
		btnValiderAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HBaseFonctions t=new HBaseFonctions();
				try {
					AffichageLigne frame = new AffichageLigne();
					String val=t.recuperer(tableName.getText(),id.getText(),FC.getText(),qualifier.getText());
					text.setText(id.getText()+"  "+FC.getText()+":"+qualifier.getText()+"="+val);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		btnValiderAl.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderAl.setBounds(377, 346, 122, 30);
		contentPane.add(btnValiderAl);
		btnValiderCreation.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderCreation.setBounds(377, 346, 122, 30);
		contentPane.add(btnValiderCreation);
		
		text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		text.setBounds(45, 415, 616, 43);
		contentPane.add(text);
		text.setColumns(10);
	}
}

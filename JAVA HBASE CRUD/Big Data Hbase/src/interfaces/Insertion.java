package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Insertion extends JFrame {

	private JPanel contentPane;
	private JTextField tableName;
	private JTextField id;
	private JTextField FC;
	private JTextField Q;
	private JTextField valeur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertion frame = new Insertion();
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
	public Insertion() {
		setBackground(Color.LIGHT_GRAY);
		setType(Type.UTILITY);
		setTitle("INSERTION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillezEntrerLa_2 = new JLabel("Veuillez Entrer la Cellule \u00E0 Ins\u00E9rer");
		lblVeuillezEntrerLa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezEntrerLa_2.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblVeuillezEntrerLa_2.setBounds(157, 35, 364, 36);
		contentPane.add(lblVeuillezEntrerLa_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom de la Table");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(120, 117, 188, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		tableName = new JTextField();
		tableName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		tableName.setColumns(10);
		tableName.setBounds(318, 117, 203, 34);
		contentPane.add(tableName);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Identifiant");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(120, 164, 190, 32);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		id = new JTextField();
		id.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		id.setColumns(10);
		id.setBounds(318, 164, 203, 34);
		contentPane.add(id);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Famille de Colonne");
		lblNewLabel_1_1_1_2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(120, 212, 191, 32);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		FC = new JTextField();
		FC.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		FC.setColumns(10);
		FC.setBounds(318, 212, 203, 34);
		contentPane.add(FC);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Qualifier");
		lblNewLabel_1_1_1_3.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_3.setBounds(120, 264, 193, 32);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		Q = new JTextField();
		Q.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		Q.setColumns(10);
		Q.setBounds(318, 264, 203, 34);
		contentPane.add(Q);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Valeur");
		lblNewLabel_1_1_1_3_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_3_1.setBounds(120, 314, 193, 32);
		contentPane.add(lblNewLabel_1_1_1_3_1);
		
		valeur = new JTextField();
		valeur.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		valeur.setColumns(10);
		valeur.setBounds(318, 314, 203, 34);
		contentPane.add(valeur);
		
		JButton btnRetourMenu = new JButton("Retour");
		btnRetourMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Menu menu=new Menu();
			menu.show();
			dispose();
			}
		});
		btnRetourMenu.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnRetourMenu.setBounds(210, 384, 122, 30);
		contentPane.add(btnRetourMenu);
		
		JButton btnValiderInsertion = new JButton("Valider");
		btnValiderInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HBaseFonctions t=new HBaseFonctions();
				try {
					Insertion frame = new Insertion();
					if(t.addUser(tableName.getText(),id.getText(),FC.getText(),Q.getText(),valeur.getText()))
						JOptionPane.showMessageDialog(frame, "Insertion Reusiie");
					else
							JOptionPane.showMessageDialog(frame, "Table Inexistante");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		btnValiderInsertion.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderInsertion.setBounds(399, 384, 122, 30);
		contentPane.add(btnValiderInsertion);
	}

}

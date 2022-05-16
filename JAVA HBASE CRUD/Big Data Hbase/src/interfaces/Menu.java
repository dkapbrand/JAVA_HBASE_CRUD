package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setLocationRelativeTo(null);
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
	public Menu() {
		setBackground(Color.LIGHT_GRAY);
		setType(Type.UTILITY);
		setTitle("MENU PRINCIPAL");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 782, 467);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btncreation = new JButton("Cr\u00E9er une table");
		btncreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creation creation=new Creation() ;
				creation.show();
				dispose();	
			}
		});
		btncreation.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		btncreation.setBounds(280, 114, 202, 37);
		contentPane.add(btncreation);
		
		JButton btnSupprimerUneTable = new JButton("Supprimer une table");
		btnSupprimerUneTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Suppression suppression=new Suppression();
			suppression.show();
			dispose();
			
			}
		});
		btnSupprimerUneTable.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		btnSupprimerUneTable.setBounds(280, 164, 202, 37);
		contentPane.add(btnSupprimerUneTable);
		
		JButton btnInsertionValeur = new JButton("Insertion Valeur");
		btnInsertionValeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Insertion insertion=new Insertion();
			insertion.show();
			dispose();
			}
		});
		btnInsertionValeur.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		btnInsertionValeur.setBounds(280, 214, 202, 37);
		contentPane.add(btnInsertionValeur);
		
		JButton btnAffichageLigne = new JButton("Affichage Ligne");
		btnAffichageLigne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AffichageLigne affichageligne=new AffichageLigne();
			affichageligne.show();
			dispose();
			}
		});
		btnAffichageLigne.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		btnAffichageLigne.setBounds(280, 264, 202, 37);
		contentPane.add(btnAffichageLigne);
		
		JButton btnAffichageTable = new JButton("Affichage Table");
		btnAffichageTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AffichageTable affichagetable=new AffichageTable();
			affichagetable.show();
			dispose();
			}
		});
		btnAffichageTable.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		btnAffichageTable.setBounds(280, 314, 202, 37);
		contentPane.add(btnAffichageTable);
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir une Op\u00E9ration");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(210, 70, 347, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BIENVENUE");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(288, 19, 174, 35);
		contentPane.add(lblNewLabel_1);
		
		JButton btnValiderCreation = new JButton("QUITTER");
		btnValiderCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnValiderCreation.setBackground(UIManager.getColor("Button.shadow"));
		btnValiderCreation.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderCreation.setBounds(318, 374, 122, 32);
		contentPane.add(btnValiderCreation);
	}
}

package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Creation extends JFrame {

	private JPanel contentPane;
	private JTextField tableName;
	private JTextField FC1;
	private JTextField FC2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creation frame = new Creation();
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
	public Creation() {
		setBackground(Color.LIGHT_GRAY);
		setType(Type.UTILITY);
		setTitle("CREATION TABLE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(7, 7, 7, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnValiderCreation = new JButton("Valider");
		btnValiderCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HBaseFonctions t=new HBaseFonctions();
				try {
					Creation frame = new Creation();
					if(t.createHbaseTable(tableName.getText(),FC1.getText(),FC2.getText())){
						
						JOptionPane.showMessageDialog(frame, "Creation Table Reussie");
					}else
						JOptionPane.showMessageDialog(frame, "Table existe deja");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		btnValiderCreation.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderCreation.setBounds(374, 267, 122, 30);
		contentPane.add(btnValiderCreation);
		
		JLabel lblVeuillezEntrerLa_2 = new JLabel("Veuillez Entrer la Table \u00E0 cr\u00E9er");
		lblVeuillezEntrerLa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezEntrerLa_2.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblVeuillezEntrerLa_2.setBounds(152, 22, 364, 36);
		contentPane.add(lblVeuillezEntrerLa_2);
		
		tableName = new JTextField();
		tableName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		tableName.setColumns(10);
		tableName.setBounds(293, 102, 203, 34);
		contentPane.add(tableName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom de la Table");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(95, 102, 188, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Famille de colonne 1");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(95, 149, 190, 32);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		FC1 = new JTextField();
		FC1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		FC1.setColumns(10);
		FC1.setBounds(293, 149, 203, 34);
		contentPane.add(FC1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Famille de Colonne 2");
		lblNewLabel_1_1_1_2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(95, 191, 191, 32);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		FC2 = new JTextField();
		FC2.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		FC2.setColumns(10);
		FC2.setBounds(293, 197, 203, 34);
		contentPane.add(FC2);
		
		JButton btnRetourMenu = new JButton("Retour");
		btnRetourMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu=new Menu();
				menu.show();
				dispose();
			}
		});
		btnRetourMenu.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnRetourMenu.setBounds(185, 267, 122, 30);
		contentPane.add(btnRetourMenu);
	}

}

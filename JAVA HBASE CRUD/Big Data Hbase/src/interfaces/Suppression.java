package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Suppression extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Veuillez Entrer la Table \u00E0 Supprimer");
	private JTextField tableName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppression frame = new Suppression();
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
	public Suppression() {
		setType(Type.UTILITY);
		setTitle("SUPPRESSION TABLE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblNewLabel.setBounds(144, 57, 364, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnValiderSuppression = new JButton("Valider");
		btnValiderSuppression.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			HBaseFonctions t=new HBaseFonctions();
			try {
				Suppression frame = new Suppression();
				if(t.supprimerUser(tableName.getText())){
					
					JOptionPane.showMessageDialog(frame, "Suppression Reussie");
				}else
					JOptionPane.showMessageDialog(frame, "La Table n'existe pas");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}});
		btnValiderSuppression.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderSuppression.setBounds(354, 236, 122, 32);
		contentPane.add(btnValiderSuppression);
		
		tableName = new JTextField();
		tableName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		tableName.setColumns(10);
		tableName.setBounds(312, 171, 203, 34);
		contentPane.add(tableName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom de la Table");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(110, 170, 188, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Menu menu=new Menu();
			menu.show();
			dispose();
			}
		});
		btnRetour.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnRetour.setBounds(200, 237, 122, 30);
		contentPane.add(btnRetour);
	}

}

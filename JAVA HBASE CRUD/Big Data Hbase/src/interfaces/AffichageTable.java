package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AffichageTable extends JFrame {

	private JPanel contentPane;
	private JTextField tableName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageTable frame = new AffichageTable();
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
	public AffichageTable() {
		setBackground(Color.LIGHT_GRAY);
		setType(Type.UTILITY);
		setTitle("AFFICHAGE TABLE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVeuillezEntrerLa = new JLabel("Veuillez Entrer la Table \u00E0 Afficher");
		lblVeuillezEntrerLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezEntrerLa.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		lblVeuillezEntrerLa.setBounds(139, 58, 364, 36);
		contentPane.add(lblVeuillezEntrerLa);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nom de la Table");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(110, 171, 188, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		tableName = new JTextField();
		tableName.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 13));
		tableName.setColumns(10);
		tableName.setBounds(312, 172, 203, 34);
		contentPane.add(tableName);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Menu menu=new Menu();
			menu.show();
			dispose();
			}
		});
		btnRetour.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnRetour.setBounds(200, 238, 122, 30);
		contentPane.add(btnRetour);
		
		JButton btnValiderAt = new JButton("Valider");
		btnValiderAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				affiche();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnValiderAt.setFont(new Font("Engravers MT", Font.PLAIN, 13));
		btnValiderAt.setBounds(354, 237, 122, 32);
		contentPane.add(btnValiderAt);
	}
public void affiche() throws IOException{
		
		HBaseFonctions t = new HBaseFonctions();
    	ResultScanner res = t.afficherUser(tableName.getText());
    	String[] columnNames = { "Famille Colonne","Colonne","Valeur"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		 for (Result r = res.next(); r != null; r = res.next()){
	        	
	        	byte [] value = r.getValue(Bytes.toBytes("info_maj"),Bytes.toBytes("ename"));											
	        	byte [] value1 = r.getValue(Bytes.toBytes("info_sup"),Bytes.toBytes("manager"));
	        	String valueStr = Bytes.toString(value);							
	        	String fam = "info_maj";
	        	String col = "ename";
	        	String valueStr1 = Bytes.toString(value1);							
	        	String fam1 = "info_sup";
	        	String col1 = "manager";	        	
	        	model.addRow(new Object[]{fam,col,valueStr});
	         	model.addRow(new Object[]{fam1,col1,valueStr1});
	        }
		
		
		JTable j = new JTable();
	    j.setModel(model);
	    JScrollPane scrollPane = new JScrollPane(j);
	    scrollPane.setBounds(0,250,800, 1000);
	    add(scrollPane);
	}

}

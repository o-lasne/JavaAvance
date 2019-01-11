package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ConnexionBDD;

public class Formulaire extends JFrame {
				
	public static void affichage()
	{
		JPanel container = new JPanel();
		JPanel top = new JPanel();
		JPanel midle = new JPanel();
		JPanel bottom = new JPanel();
		JPanel pButton = new JPanel();
		
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Merci de remplir");
		fenetre.setSize(400,400);
		
		JLabel lNom = new JLabel("Nom");
		lNom.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(lNom);
		
		JLabel lPrenom = new JLabel("Prénom");
		lPrenom.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(lPrenom);
		
		JLabel lNote = new JLabel("Note");
		lNote.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(lNote);
		
		JTextField txNom = new JTextField();
		txNom.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(txNom);
		
		JTextField txPrenom = new JTextField();
		txPrenom.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(txPrenom);
		
		JTextField txNote = new JTextField();
		txNote.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(txNote);
		
		JButton bValider = new JButton ("Valider");
		bValider.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(bValider);
		
		JButton bAnnuler = new JButton ("Annuler");
		bAnnuler.setPreferredSize(new Dimension(150, 30));
		fenetre.getContentPane().add(bAnnuler);
		
		top.add(lNom);
	 	midle.add(lPrenom);
	 	midle.add(txPrenom);
	 	bottom.add(lNote);
	 	bottom.add(txNote);
	 	pButton.add(bValider);
	 	pButton.add(bAnnuler);
	 	container.add(top,BorderLayout.NORTH);
	 	container.add(midle,BorderLayout.NORTH);
	 	container.add(bottom,BorderLayout.NORTH);
	 	container.add(pButton,BorderLayout.NORTH);
		
		JPanel pan = new JPanel();
		pan.add(lNom);
		pan.add(txNom);
		pan.add(lPrenom);
		pan.add(txPrenom);
		pan.add(lNote);
		pan.add(txNote);
		pan.add(bAnnuler);
		pan.add(bValider);

		class Validate extends JFrame implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				ConnexionBDD conn = new ConnexionBDD();
				try {
					System.out.println("/*****************************************************/");
					System.out.println("Avant l'ajout");
					System.out.println("/*****************************************************/");
					conn.readDataBase();
					conn.addValueInDataBase(txNom.getText(), txPrenom.getText() , Integer.parseInt(txNote.getText()));
					System.out.println("\n/*****************************************************/");
					System.out.println("Après l'ajout");
					System.out.println("/*****************************************************/");
					conn.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		class Clear extends JFrame implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				txNom.setText("");
				txPrenom.setText("");
				txNote.setText("");
			}
		}
		
		bValider.addActionListener(new Validate());
		
		bAnnuler.addActionListener(new Clear());
		
		fenetre.setContentPane(pan);
		fenetre.setVisible(true);
	}
}

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.FileDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DictioUI dictioUI = new DictioUI();
		dictioUI.display();
		// JFrame frame = new JFrame("Dictio");
		// JButton btnCharger = new JButton("Charger");// creating instance of JButton
		// JButton btnEnregistrer = new JButton("Enregistrer");//creating instance of JButton 
		// JTextField txfSearch = new JTextField();
		// JTextField txfRelated = new JTextField();
		// JTextField txfDescription = new JTextField();
		// JLabel labelSearch = new JLabel("Search");
		
		// labelSearch.setBounds(10, 20, 100, 20);
		// btnCharger.setBounds(395,10,100, 30);//x axis, y axis, width, height  
		// btnEnregistrer.setBounds(505,10,100, 30);//x axis, y axis, width, height  
		// txfSearch.setBounds(10,50,300,30);  
		// txfRelated.setBounds(10,80,300,90);
		// txfDescription.setBounds(310,50,400,120);
		// frame.add(btnCharger);//adding button in Jframerame  
		// frame.add(btnEnregistrer);//adding button in JFrame  
		// frame.add(txfSearch);  
		// frame.add(labelSearch);
		// frame.add(txfDescription);
		// frame.add(txfRelated);
		// frame.setSize(1000,600);//400 width and 500 height  
		// frame.setLayout(null);//using no layout managers  
		// frame.setVisible(true);//making the frame visible 
		

		// btnCharger.addActionListener(new ActionListener() { 
		// 	public void actionPerformed(ActionEvent e) { 
		// 		openFile();
		// 	} 
		//   });
	}

	// private static void openFile() {
	// 	FileDialog fd = new FileDialog(new JFrame(), "Selectionner un fichier a ouvrir", FileDialog.LOAD);
	// 	fd.setMultipleMode(false);
	// 	fd.setVisible(true);
	// 	String f = fd.getFile();
	// 	System.out.println(f);
	// }

}

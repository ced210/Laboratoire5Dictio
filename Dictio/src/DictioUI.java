import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.FileDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DictioUI {
    
    JFrame frame;
    JButton btnCharger;
    JButton btnEnregistrer;
    JTextField txfSearch;
    JTextField txfRelated;
    JTextField txfDescription;
    JLabel labelSearch;
    
    Dictionary dictionary;

    public DictioUI() {
        dictionary = new Dictionary();
    }

    public void display() {
        frame = new JFrame("Dictio");
		btnCharger = new JButton("Charger");// creating instance of JButton
		btnEnregistrer = new JButton("Enregistrer");//creating instance of JButton 
		txfSearch = new JTextField();
		txfRelated = new JTextField();
		txfDescription = new JTextField();
		labelSearch = new JLabel("Search");
		
		labelSearch.setBounds(10, 20, 100, 20);
		btnCharger.setBounds(395,10,100, 30);//x axis, y axis, width, height  
		btnEnregistrer.setBounds(505,10,100, 30);//x axis, y axis, width, height  
		txfSearch.setBounds(10,50,300,30);  
		txfRelated.setBounds(10,80,300,90);
		txfDescription.setBounds(310,50,400,120);
		frame.add(btnCharger);//adding button in Jframerame  
		frame.add(btnEnregistrer);//adding button in JFrame  
		frame.add(txfSearch);  
		frame.add(labelSearch);
		frame.add(txfDescription);
		frame.add(txfRelated);
		frame.setSize(1000,600);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible 
		

		btnCharger.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				openFile();
			} 
		  });
    }

    private void openFile() {
		FileDialog fileDialog = new FileDialog(new JFrame(), "Selectionner un fichier a ouvrir", FileDialog.LOAD);
		fileDialog.setMultipleMode(false);
		fileDialog.setVisible(true);
        System.out.println(fileDialog.getFiles()[0].getAbsolutePath());
        dictionary.loadFile(fileDialog.getFile());
	}
}
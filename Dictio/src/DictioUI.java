import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DictioUI {
    JFrame frame;
    JButton btnCharger;
    JButton btnEnregistrer;
    JTextField txfSearch;
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
		txfDescription = new JTextField();
		labelSearch = new JLabel("Search");
        
        JList list = new JList(new String[] {"asd", "qwe", "qwesd"}); //data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

		labelSearch.setBounds(10, 20, 100, 20);
		btnCharger.setBounds(395,10,100, 30);//x axis, y axis, width, height  
		btnEnregistrer.setBounds(505,10,100, 30);//x axis, y axis, width, height  
		txfSearch.setBounds(10,50,300,30);  
		list.setBounds(10,80,300,90);
		txfDescription.setBounds(310,50,400,120);
		frame.add(btnCharger);//adding button in Jframerame  
		frame.add(btnEnregistrer);//adding button in JFrame  
		frame.add(txfSearch);  
		frame.add(labelSearch);
		frame.add(txfDescription);
        frame.add(list);
		frame.setSize(1000,600);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible 
        
        

        list.addListSelectionListener(new SharedListSelectionHandler());


		btnCharger.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                loadFile();
            } 
        });
          
        btnEnregistrer.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                saveFile();
            } 
        });
    }

    private void loadFile() {
        try {
            FileDialog fileDialog = new FileDialog(new JFrame(), "Selectionner un fichier a ouvrir", FileDialog.LOAD);
            fileDialog.setMultipleMode(false);
            fileDialog.setVisible(true);
            System.out.println(fileDialog.getFiles()[0].getAbsolutePath());
            if (fileDialog.getFile() != null) {
                dictionary.loadFile(fileDialog.getFile());
            }
        } catch (Exception e) {
            showErrorDialog("erreur lors de l'ouverture du fichier");
        }
    }
    
    private void saveFile() {
        try {
            dictionary.saveFile();
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }
    
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error",
        JOptionPane.ERROR_MESSAGE);
    }

    class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
    
            int firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting();
            // output.append("Event for indexes "
            //               + firstIndex + " - " + lastIndex
            //               + "; isAdjusting is " + isAdjusting
            //               + "; selected indexes:");
    
            if (lsm.isSelectionEmpty()) {
                //output.append(" <none>");
            } else {
                // Find out which indexes are selected.
                // int minIndex = lsm.getMinSelectionIndex();
                // int maxIndex = lsm.getMaxSelectionIndex();
                // for (int i = minIndex; i <= maxIndex; i++) {
                //     if (lsm.isSelectedIndex(i)) {
                //         output.append(" " + i);
                //     }
                // }
            }
            // output.append(newline);
        }
    }
}
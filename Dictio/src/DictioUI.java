import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.*;
import java.security.InvalidParameterException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//TODO double check
/**
 * Classe DictioUI contenant les differentes composantes de JSwing pour l'interface 
*/
public class DictioUI {
    JFrame frame;
    JButton btnLoad;
    JButton btnSave;
    JButton btnAddEdit;
    JTextField txfSearch;
    JTextArea txfDescription;
    JLabel labelSearch;
    JList<Word> searchJList;
    JList<Word> dictionnaryJList;
<<<<<<< HEAD
    JScrollPane dictionnaryListScroller;
    JScrollPane searchListScroller;
    JScrollPane descriptionListScroller;
=======
>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
    Dictionary dictionary;
    JScrollPane scrollPane;

    //TODO double check 
    /**
	 * Constructeur de la classe DictioUI
     * instancie tous les composantes de l'interface
	*/
    public DictioUI() {
        dictionary = new Dictionary();
        frame = new JFrame("Dictio");
        btnLoad = new JButton("Charger");
        btnSave = new JButton("Enregistrer");
        btnAddEdit = new JButton("Ajouter / Modifier");
        txfSearch = new JTextField();
        txfDescription = new JTextArea();
        labelSearch = new JLabel("Search");
        searchJList = new JList<Word>();
        dictionnaryJList = new JList<Word>();
<<<<<<< HEAD
        searchListScroller = new JScrollPane(searchJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        dictionnaryListScroller = new JScrollPane(dictionnaryJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        descriptionListScroller = new JScrollPane(txfDescription, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
=======
        scrollPane = new JScrollPane(dictionnaryJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
    }

    ////TODO double check 
    /**
     * Initialise la position et les paramètres des composantes de l'interface.
     */
    public void display() {

    	dictionnaryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    	dictionnaryJList.setLayoutOrientation(JList.VERTICAL);
    	dictionnaryJList.setVisibleRowCount(-1);
<<<<<<< HEAD
    	dictionnaryJList.setCellRenderer(new WordCellRenderer());
        
=======
        dictionnaryJList.setCellRenderer(new WordCellRenderer());
        
        scrollPane.setPreferredSize(new Dimension(250, 80));

>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
        searchJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    	searchJList.setLayoutOrientation(JList.VERTICAL);
    	searchJList.setVisibleRowCount(-1);
    	searchJList.setCellRenderer(new WordCellRenderer());

<<<<<<< HEAD
    	descriptionListScroller.setBounds(310, 50, 400, 120);
    	searchListScroller.setBounds(10, 80, 300, 90);
    	dictionnaryListScroller.setBounds(710,50,265,120);
=======
        txfDescription.setLineWrap(true);
        txfDescription.setWrapStyleWord(true);

>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
        labelSearch.setBounds(10, 20, 100, 20);
        btnLoad.setBounds(395, 10, 100, 30);
        btnSave.setBounds(505, 10, 100, 30);
        btnAddEdit.setBounds(300, 200, 200, 50);
        txfSearch.setBounds(10, 50, 300, 30);
        searchJList.setBounds(10, 80, 300, 90);
        
        dictionnaryJList.setBounds(710,50,265,120);
        txfDescription.setBounds(310, 50, 400, 120);
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
        frame.add(btnLoad);
        frame.add(btnSave);
        frame.add(btnAddEdit);
        frame.add(txfSearch);
        frame.add(labelSearch);
<<<<<<< HEAD
        frame.add(descriptionListScroller);
        frame.add(searchListScroller);
        frame.setSize(1000, 400);
        frame.add(dictionnaryListScroller);
     

=======
        frame.add(txfDescription);
        frame.add(searchJList);
        frame.add(dictionnaryJList);
        dictionnaryJList.add(scrollPane);
        
>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
        setDictionaryListData();
        addEventListener();
<<<<<<< HEAD

=======
        
        frame.setSize(1000, 400);
>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //TODO double check 
    /**
     * Ajoute les actions des interactions avec les composantes du menu.
     */
    private void addEventListener() {
        dictionnaryJList.addListSelectionListener(new SharedListSelectionHandler());
        
        searchJList.addListSelectionListener(new SharedListSelectionHandler());

        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { loadFile(); }
        });

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { saveFile(); }
        });

        btnAddEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { addEditWord(); }
        });

        txfSearch.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) { }
        
            public void keyReleased(KeyEvent keyEvent) { 
                try {
                    String criteria = txfSearch.getText().toString();
                    if(criteria != null) setSearchListData(criteria);
                }
                catch(Exception e) {
                    txfSearch.setText("");
                    showErrorDialog(e.getMessage());
                }
             }
        
            public void keyTyped(KeyEvent e) { /* ... */ }
        });
    }

    //TODO double check 
    /**
     * Affecte à la liste de données, tous les mots trouvés du dictionnaire.
     */
    private void setDictionaryListData(){
        var al = dictionary.getAllWords();
        Word[] arr = new Word[al.size()]; 
        arr = al.toArray(arr);
        dictionnaryJList.setListData(arr);
    }

    //TODO double check 
    /**
     * Affecte à la liste de données, tous les mots correspondant à la recherche.
     */
    private void setSearchListData(String criteria){
        var al = dictionary.searchWords(criteria);
        Word[] arr = new Word[al.size()]; 
        arr = al.toArray(arr);
        searchJList.setListData(arr);
    }

    //TODO double check 
    /**
     * Ouvre l'explorateur de fichier pour permettre de sélectionner un fichier à ouvrir.
     */
    private void loadFile() {
        try {
            FileDialog fileDialog = new FileDialog(new JFrame(), "Selectionner un fichier a ouvrir", FileDialog.LOAD);
            fileDialog.setMultipleMode(false);
            fileDialog.setVisible(true);
            System.out.println(fileDialog.getFiles()[0].getAbsolutePath());
            if (fileDialog.getFile() != null) {
                dictionary.loadFile(fileDialog.getFile());
            }
            setDictionaryListData();
        } catch (Exception e) {
            if(e.getMessage() != null ) showErrorDialog(e.getMessage());
            else showErrorDialog("Erreur lors de l'ouverture du fichier");
        }
    }

    //TODO double check 
    /*
     * Appel la fonction de sauvegarde de fichier du Dictionnaire.
     */
    private void saveFile() {
        try {
            FileDialog fileDialog = new FileDialog(new JFrame(), "Selectionner un fichier a enregistrer", FileDialog.SAVE);
            fileDialog.setMultipleMode(false);
            fileDialog.setVisible(true);
            System.out.println(fileDialog.getFiles()[0].getAbsolutePath());
            if (fileDialog.getFile() != null) {
                dictionary.saveFile(fileDialog.getFile());
            }
        } catch (IOException ioe) {
            showErrorDialog(ioe.getMessage());
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }

    //TODO double check 
    /*
     * Ajoute ou Modifie un mot selon le mot inscrit dans la boîte de recherche
     * et les mots inscrit dans la boite de définition
     */
    private void addEditWord() {
        try {
            if(txfSearch.getText() == null)
                throw new InvalidParameterException("Word object should not be null");
            if(txfDescription.getText() == null)
			    throw new InvalidParameterException("Definition object should not be null");
            dictionary.addWord(new Word(txfSearch.getText(), txfDescription.getText()));
            setDictionaryListData();
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }

    //TODO leurs préconditions/postconditions, leurs paramètres, valeurs de retour et la raison des exceptions qu’ils envoient 
    /**
     * Ouvre ledialogue d'erreur pour afficher l'erreur à l'usagé
     * @param message le message d'erreur à afficher
     */
    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    //TODO Javadoc, reponsabilite de classe, collaborateurs, 
    class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                JList list = (JList) e.getSource();
                if (list.getSelectedIndex() != -1) {
                    txfDescription.setText(((Word)list.getSelectedValue()).getDefinition());
                }
            }
        }
    }

    //TODO Javadoc, reponsabilite de classe, collaborateurs, 
    class WordCellRenderer extends JLabel implements ListCellRenderer<Object> {
        public WordCellRenderer() {
            setOpaque(true);
        }
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Word word = (Word)value;
            setText(word.getWord());

            Color background;
            Color foreground;

            if (isSelected) {
                background = Color.BLUE;
                foreground = Color.WHITE;
            } else {
                background = Color.WHITE;
                foreground = Color.BLACK;
            }
            setBackground(background);
            setForeground(foreground);
            return this;
        }
    }
}
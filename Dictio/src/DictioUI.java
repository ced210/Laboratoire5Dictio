import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DictioUI {
    JFrame frame;
    JButton btnLoad;
    JButton btnSave;
    JButton btnAddEdit;
    JTextField txfSearch;
    JTextField txfDescription;
    JLabel labelSearch;
    JList<Word> searchJList;
    JScrollPane listScroller;

    Dictionary dictionary;

    public DictioUI() {
        dictionary = new Dictionary();
        frame = new JFrame("Dictio");
        btnLoad = new JButton("Charger");// creating instance of JButton
        btnSave = new JButton("Enregistrer");// creating instance of JButton
        btnAddEdit = new JButton("Ajouter / Modifier");// creating instance of JButton
        txfSearch = new JTextField();
        txfDescription = new JTextField();
        labelSearch = new JLabel("Search");
        searchJList = new JList<Word>();// data
        listScroller = new JScrollPane(searchJList);
    }

    public void display() {

        searchJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        searchJList.setLayoutOrientation(JList.VERTICAL);
        searchJList.setVisibleRowCount(-1);
        searchJList.setCellRenderer(new WordCellRenderer());
        listScroller.setPreferredSize(new Dimension(250, 80));

        labelSearch.setBounds(10, 20, 100, 20);
        btnLoad.setBounds(395, 10, 100, 30);// x axis, y axis, width, height
        btnSave.setBounds(505, 10, 100, 30);
        btnAddEdit.setBounds(300, 200, 200, 50);
        txfSearch.setBounds(10, 50, 300, 30);
        searchJList.setBounds(10, 80, 300, 90);
        txfDescription.setBounds(310, 50, 400, 120);
        frame.add(btnLoad);// adding button in Jframerame
        frame.add(btnSave);
        frame.add(btnAddEdit);
        frame.add(txfSearch);
        frame.add(labelSearch);
        frame.add(txfDescription);
        frame.add(searchJList);
        frame.setSize(1000, 600);

        setSearchListData();
        addEventListener();

        frame.setLayout(null);// using no layout managers
        frame.setVisible(true);// making the frame visible
    }

    private void addEventListener() {
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
    }

    private void setSearchListData(){
        var al = dictionary.getAllWords();
        Word[] arr = new Word[al.size()]; 
        arr = al.toArray(arr);
        searchJList.setListData(arr);
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
            setSearchListData();
        } catch (Exception e) {
            showErrorDialog("Erreur lors de l'ouverture du fichier");
        }
    }

    private void saveFile() {
        try {
            dictionary.saveFile();
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }

    private void addEditWord() {
        try {
            dictionary.addWord(new Word(txfSearch.getText(), txfDescription.getText()));
            setSearchListData();
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

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
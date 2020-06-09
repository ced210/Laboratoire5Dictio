import javax.swing.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {  
<<<<<<< HEAD
		JFrame frame = new JFrame("Dictio");
		
		JButton btnCharger = new JButton("Charger");//creating instance of JButton  
		JButton btnEnregistrer = new JButton("Enregistrer");//creating instance of JButton 
		JTextField txfSearch = new JTextField();
		JTextField txfRelated = new JTextField();
		JTextField txfDescription = new JTextField();
		JLabel labelSearch = new JLabel("Search");
		
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
=======
		JFrame f=new JFrame();//creating instance of JFrame  
		          
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		          
		f.add(b);//adding button in JFrame  
		          
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible 
>>>>>>> branch 'master' of https://github.com/ced210/Laboratoire5Dictio.git
	}
}

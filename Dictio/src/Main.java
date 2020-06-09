import javax.swing.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {  
		JFrame f=new JFrame("Dictio");//creating instance of JFrame  
		          
		JButton b = new JButton("Charger");//creating instance of JButton  
		JButton b2 = new JButton("Enregistrer");//creating instance of JButton  
		b.setBounds(395,10,100, 30);//x axis, y axis, width, height  
		b2.setBounds(505,10,100, 30);//x axis, y axis, width, height  
		         
		f.add(b);//adding button in JFrame  
		f.add(b2);//adding button in JFrame  
		   
		f.setSize(1000,600);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible 
	}
}

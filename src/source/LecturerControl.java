package source;

	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
	import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONObject;
	import org.json.simple.parser.ParseException;

public class LecturerControl extends JFrame {
	


	public static int point=0,failPoint=0;	
	private JPanel	RatePanel;
	
	public static JTable studentsRate;
	

	
	private JLabel rateLabel;

	private JButton buttonBack;

		

	public LecturerControl() throws ParseException{
		
		createTeacherControl();
		
		
	}


	public void createTeacherControl() throws ParseException{
		
		
		
		setLocation(0,0);
		setSize(1100,470);
		setTitle("Успеваемость студентов");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);	
		
		
		
		
		
		RatePanel = new JPanel();
		RatePanel.setLayout(null);
		
	    
		
		rateLabel= new JLabel("Статистика");
		rateLabel.setLocation(460,0);
		rateLabel.setFont(new Font("Verdana",Font.ITALIC,20));
		rateLabel.setSize(200,20);
		RatePanel.add(rateLabel);
		
		
		buttonBack=new JButton("Выход");
		buttonBack.setFont(new Font("Verdana",Font.ITALIC,16));
		buttonBack.setLocation(460,400);
		buttonBack.setSize(200,30);
		RatePanel.add(buttonBack);
		
		
		
		
		
		//studentsRate.setEnabled(false);
		
		
		Lecturer.createRateTable();
		
		
		
		
		
		JScrollPane scrolTable = new JScrollPane(studentsRate);

		scrolTable.setLocation(250,40);
		scrolTable.setSize(600,350);


		RatePanel.add(scrolTable);
		
		scrolTable.setEnabled(false);
		
		
		
		ActionListener listenerButton = new listenerButton();
		buttonBack.addActionListener(listenerButton);
		setContentPane(RatePanel);

	}

	
	
	


	
	
	
	
	
	
	public class listenerButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==buttonBack){
			setVisible(false);	
			Main.mainFrame.setVisible(true);
				
			}
			
			
			
			
			
			
		}
		
		
		
	}

	



}

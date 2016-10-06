package source;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

public class QUESTION extends JFrame {
	private JLabel labelQ,labelAnswer1,labelAnswer2,labelAnswer3,labelAnswer4,labelReightAnswer;
	public static JPanel QUE_FRAME;
	private JButton CONFIRM,CANCEL;
	private JTextArea Question;
	public static JTextField Answer1,Answer2,Answer3,Answer4, RightAnswer;
	private JScrollPane scrollQuest;
	
	public static ButtonGroup variants = new ButtonGroup();
	public static JRadioButton radio1, radio2, radio3, radio4;
	
	public QUESTION() 
	{
		
		createQUESTION();
		
	}
	
	
	
	public void createQUESTION(){
		setLocation(50,50);
		setSize(830,600);
		setTitle("Добавить вопрос");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		QUE_FRAME = new JPanel();
		QUE_FRAME.setLayout(null);
		
		labelQ = new JLabel();
		labelQ.setFont(new Font("Verdana",Font.ITALIC,12));
		labelQ.setSize(770,20);
		labelQ.setLocation(30,0);
		QUE_FRAME.add(labelQ);
		
		//boxChooseTest = new JComboBox(MaterialsEdit.massMaterials);
		//boxChooseTest.setSize(400,30);
		
		
		
		
		
		
		
		labelAnswer1 = new JLabel("а:");
		labelAnswer1.setFont(new Font("Verdana",Font.ITALIC,12));
		labelAnswer1.setSize(170,20);
		labelAnswer1.setLocation(30,150);
		QUE_FRAME.add(labelAnswer1);
		
		Answer1 = new JTextField();
		Answer1.setFont(new Font("Verdana", Font.ITALIC,14));
		Answer1.setSize(770,30);
		Answer1.setLocation(30, 180);
		QUE_FRAME.add(Answer1);
		
		radio1 = new JRadioButton();
		radio1.setLocation(0,180);
		radio1.setSize(30,20);
		radio1.setFont(new Font("Verdana", Font.ITALIC,12));
		QUE_FRAME.add(radio1);

		labelAnswer2 = new JLabel("б:");
		labelAnswer2.setFont(new Font("Verdana",Font.ITALIC,12));
		labelAnswer2.setSize(170,20);
		labelAnswer2.setLocation(30,220);
		QUE_FRAME.add(labelAnswer2);
		
		Answer2 = new JTextField();
		Answer2.setFont(new Font("Verdana", Font.ITALIC,14));
		Answer2.setSize(770,30);
		Answer2.setLocation(30, 250);
		QUE_FRAME.add(Answer2);
		
		radio2 = new JRadioButton();
		radio2.setLocation(0,250);
		radio2.setSize(30,20);
		radio2.setFont(new Font("Verdana", Font.ITALIC,12));
		QUE_FRAME.add(radio2);
		
		
		labelAnswer3 = new JLabel("в:");
		labelAnswer3.setFont(new Font("Verdana",Font.ITALIC,12));
		labelAnswer3.setSize(170,20);
		labelAnswer3.setLocation(30,290);
		QUE_FRAME.add(labelAnswer3);
		
		
		Answer3 = new JTextField();
		Answer3.setFont(new Font("Verdana", Font.ITALIC,14));
		Answer3.setSize(770,30);
		Answer3.setLocation(30, 320);
		QUE_FRAME.add(Answer3);
		
		
		radio3 = new JRadioButton();
		radio3.setLocation(0,320);
		radio3.setSize(30,20);
		radio3.setFont(new Font("Verdana", Font.ITALIC,12));
		QUE_FRAME.add(radio3);
		
		
		
		
		
		labelAnswer4 = new JLabel("г:");
		labelAnswer4.setFont(new Font("Verdana",Font.ITALIC,12));
		labelAnswer4.setSize(170,20);
		labelAnswer4.setLocation(30,360);
		QUE_FRAME.add(labelAnswer4);
		
		Answer4 = new JTextField();
		Answer4.setFont(new Font("Verdana", Font.ITALIC,14));
		Answer4.setSize(770,30);
		Answer4.setLocation(30, 390);
		QUE_FRAME.add(Answer4);
		
		radio4 = new JRadioButton();
		radio4.setLocation(0,390);
		radio4.setSize(30,20);
		radio4.setFont(new Font("Verdana", Font.ITALIC,12));
		QUE_FRAME.add(radio4);
		
		
		
		variants.add(radio1);
		variants.add(radio2);
		
		variants.add(radio3);
		variants.add(radio4);
		
		
		CONFIRM = new JButton("Создать");
		CONFIRM.setFont(new Font("Verdana",Font.ITALIC,12));
		CONFIRM.setSize(250,30);
		CONFIRM.setLocation(30,500);
		QUE_FRAME.add(CONFIRM);
		
	
		
		
		CANCEL = new JButton("Отменить");
		CANCEL.setFont(new Font("Verdana",Font.ITALIC,12));
		CANCEL.setSize(250,30);
		CANCEL.setLocation(550,500);
		QUE_FRAME.add(CANCEL);
		
		
		Question = new JTextArea();
		Question.setFont(new Font("Verdana", Font.ITALIC,14));
		
		
		scrollQuest = new JScrollPane(Question);
		scrollQuest.setLocation(30,40);
		scrollQuest.setSize(770,90);
		QUE_FRAME.add(scrollQuest);
		
		
		
		
		
		
		
		
		
		
		
		JSONObject CHECK_OBJ = (JSONObject)MaterialsEdit.JSONThemesListARRAY.get(ThemeFrame.INDEX_ITEM);
		Question.setText(CHECK_OBJ.get("Question").toString());
		Answer1.setText(CHECK_OBJ.get("Answer1").toString());
		Answer2.setText(CHECK_OBJ.get("Answer2").toString());
		Answer3.setText(CHECK_OBJ.get("Answer3").toString());
		Answer4.setText(CHECK_OBJ.get("Answer4").toString());
		
		labelQ.setText("Вопрос к теме '"+CHECK_OBJ.get("Theme").toString()+"'.");
		
		setContentPane(QUE_FRAME);
		ActionListener LISTENER_BUTTONS = new LISTENER_BUTTONS();
		CONFIRM.addActionListener(LISTENER_BUTTONS);
		CANCEL.addActionListener(LISTENER_BUTTONS);
		
		
	}
	
	public class LISTENER_BUTTONS implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		
		{
		if(e.getSource()==CONFIRM)
		{
		if(variants.getSelection()!=null){
		boolean VIS=TestControl.createTest(Question.getText(), Answer1.getText(), Answer2.getText(), Answer3.getText(), Answer4.getText());
		setVisible(VIS);}
			
			
			
		}
		
		if(e.getSource()==CANCEL)
		{
			
		setVisible(false);	
			
		}
		
		
		
	
		
		
	}
}
	

}

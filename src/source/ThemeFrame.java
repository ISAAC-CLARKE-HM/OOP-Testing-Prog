package source;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionListener;


public class ThemeFrame extends JFrame {
	public static String THEME_DEL;
	
	public static String Time= FunctionsOnFiles.TIME;
	
	
	public static boolean DEL;
	
	
	
	public static Timer timer;
	public static int sec = 0;
	private JLabel labelSec;
	
	static public int countChosenThemes=0;
	
	public static int INDEX_ITEM=0;
	public static JTextField textFieldNewTheme;
	public static JButton buttonBACK, buttonCreate,buttonDelete, buttonSave,buttonConfirmAdd,buttonCancelAdd,buttonSaveChanges,addQuestion;
	public static JLabel materialHelp, themeHelp;
	private JButton  buttonNextTHEME, buttonPreviousTHEME;
	public static JButton includeInTest,deleteFromTest;
	public static JTextArea THEME1;
	private JComboBox boxChooseTheme;
	private JScrollPane scrolTHEME;
	public static JPanel panelMain2;	
	
	
	 private JLabel confirm;
	 private JButton YES;
	 
	private String THEMES_LIST = new String(); 
	
	

	
	
	
	
	
	
	public ThemeFrame() throws ParseException
	{
		
		createThemeFrame();
		student.startTimer();
	}
	
	public void createThemeFrame() throws ParseException{
		
		
	
		//TestControl.TEST();
		//TestControl.USR_TEST();   
		//
		//if(MainMenuFrame.TEACHER!=true){
			
			
			//TestControl.addNewTest();
			//}
		
		
MaterialsEdit.ParseMaterial();  
	    
	
		
		setLocation(50,50);
		setSize(750,600);
		setTitle("ТЕМЫ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);	
	
		
		panelMain2 = new JPanel();
		panelMain2.setLayout(null);
	
		
		labelSec = new JLabel();
		labelSec.setLocation(10, 10);
		
		themeHelp = new JLabel("Назад");
		themeHelp.setSize(0,0);
		themeHelp.setLocation(10,35);
		
		
		textFieldNewTheme = new JTextField();
		textFieldNewTheme.setSize(400,20);
		textFieldNewTheme.setLocation(150, 50);
		
		
		
		materialHelp =new JLabel("Выберите подтему:");
		materialHelp.setSize(150,20);
		materialHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		
		includeInTest = new JButton("Р”РѕР±Р°РІРёС‚СЊ РІ С‚РµСЃС‚");
		includeInTest.setFont(new Font("Verdana",Font.ITALIC,12));
		includeInTest.setSize(150,30);
		includeInTest.setLocation(0,0);
		
		boxChooseTheme = new JComboBox(MaterialsEdit.massMaterials);
		boxChooseTheme.setSize(400,30);
	
		
		deleteFromTest = new JButton("РџСЂРёР±СЂР°С‚Рё Р· С‚РµСЃС‚Сѓ");
		deleteFromTest.setFont(new Font("Verdana",Font.ITALIC,12));
		deleteFromTest.setSize(0,0);
		
		
		buttonCreate = new JButton("Создание темы");
		buttonCreate.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonCreate.setSize(150,30);
		buttonCreate.setLocation(560, 10);
		
		buttonConfirmAdd = new JButton("Создать");
		buttonConfirmAdd.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonConfirmAdd.setSize(150,30);
		buttonConfirmAdd.setLocation(360, 85);
		
		buttonCancelAdd = new JButton("РќР°Р·Р°Рґ");
		buttonCancelAdd.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonCancelAdd.setSize(150,30);
		buttonCancelAdd.setLocation(180, 85);
		
		buttonDelete = new JButton("Р’Р�Р”РђР›Р�РўР� РџР†Р”РўР•РњРЈ");
		buttonDelete.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonDelete.setSize(150,30);
		buttonDelete.setLocation(550, 530);
		
		
		addQuestion = new JButton ("Добавить тест");
		addQuestion.setFont(new Font("Verdana", Font.ITALIC,12));
		addQuestion.setSize(150,30);
		addQuestion.setLocation(180, 85);
	
		
		buttonSave = new JButton("Р Р•Р”РђР“РЈР’РђРўР�");
		buttonSave.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonSave.setSize(150,30);
		buttonSave.setLocation(840, 530);
		
		buttonSaveChanges = new JButton("РЎРѕС…СЂР°РЅРёС‚СЊ");
		buttonSaveChanges.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonSaveChanges.setSize(150,30);
		buttonSaveChanges.setLocation(700, 300);		
		
		buttonNextTHEME = new JButton("Следующая");
		buttonNextTHEME.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonNextTHEME.setSize(150,30);
		buttonNextTHEME.setLocation(5,85);
		
		buttonPreviousTHEME = new JButton("РџСЂРµРґС‹РґСѓС‰Р°СЏ");
		buttonPreviousTHEME.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonPreviousTHEME.setSize(0,0);
		buttonPreviousTHEME.setLocation(10,85);
		
		
		THEME1 = new JTextArea();
		//THEME1.setSize(1250,450);
		THEME1.setFont(new Font("Verdana", Font.ITALIC,14));
		//THEME1.setEditable(true);
		
		
		buttonBACK = new JButton("Выход");
		buttonBACK.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonBACK.setSize(150,30);
		buttonBACK.setLocation(560,85);
		panelMain2.add(buttonBACK);


		scrolTHEME = new JScrollPane(THEME1);
		scrolTHEME.setLocation(5,150);
		scrolTHEME.setSize(700,300);
		//THEME1.setLocation(10,60);

		panelMain2.add(scrolTHEME);
		
		
		materialHelp.setLocation(10,10);
		panelMain2.add(materialHelp);

		boxChooseTheme.setLocation(155,10);
		panelMain2.add(boxChooseTheme);

		
		
		
		deleteFromTest.setLocation(710,530);
		
		
	    
		YES = new JButton("Р’Р�Р”РђР›Р�РўР�");
		YES.setFont(new Font("Verdana",Font.ITALIC,12));
		YES.setLocation(700, 530);
		YES.setSize(200,30);
	    
	     
	     
	     
		
	     confirm = new JLabel("Р’РёРґР°Р»РёС‚Рё С‚РµРјСѓ '"+THEME_DEL+"'?");
	     confirm.setSize(500,20);
	     confirm.setFont(new Font("Verdana",Font.ITALIC,12));
	     confirm.setLocation(70,10);
	     
		
		
		
	    //dure
		
		
	    
		
		
		ActionListener listenerButton= new listenerButton();
		
		boxChooseTheme.addActionListener(listenerButton);
		
		buttonBACK.addActionListener(listenerButton);
		
		buttonNextTHEME.addActionListener(listenerButton);
		buttonPreviousTHEME.addActionListener(listenerButton);
		buttonCreate.addActionListener(listenerButton);
		
		addQuestion.addActionListener(listenerButton);
		
		 YES.addActionListener(listenerButton);
		
		buttonSave.addActionListener(listenerButton);
		buttonSaveChanges.addActionListener(listenerButton);
		
		
		buttonDelete.addActionListener(listenerButton);
		
		buttonConfirmAdd.addActionListener(listenerButton);
		buttonCancelAdd.addActionListener(listenerButton);
		
		
		includeInTest.addActionListener(listenerButton);
		
		deleteFromTest.addActionListener(listenerButton);
		
		
		
		setContentPane(panelMain2);
		
		if(MainMenuFrame.TEACHER==true)
		{
			panelMain2.add(buttonCreate);
			//THEME1.setEditable(true);
		
		
		}
		else THEME1.setEditable(false);
		
		System.out.println("TEACHER:"+MainMenuFrame.TEACHER);
		
		
		
	}
	
	public void RemoveButtons(){
		panelMain2.add(themeHelp);
		panelMain2.add(textFieldNewTheme);
		
		panelMain2.add(buttonCancelAdd);
		
		remove(buttonCreate);
		remove(buttonDelete);
		remove(buttonSave);
		
		remove(buttonNextTHEME);
		remove(buttonPreviousTHEME);
		remove(boxChooseTheme);
		
		
		remove(addQuestion);
		
		repaint();	
	}
	
	public void AddButtons(){
		remove(buttonConfirmAdd);
		remove(buttonCancelAdd);
		remove(YES);
		
		panelMain2.add(buttonCreate);
		panelMain2.add(buttonDelete);	
		panelMain2.add(buttonSave);	
		
	    panelMain2.add(boxChooseTheme);
	    panelMain2.add(addQuestion);
	    
	    materialHelp.setText("Р’С‹Р±РµСЂРёС‚Рµ С‚РµРјСѓ");
	    
	   
		
		
		repaint();
	}
	
	
	
	
	
	
	
	public void addButtons()
	{
		
		remove(buttonPreviousTHEME);
		remove(buttonNextTHEME);
		
		if(INDEX_ITEM<MaterialsEdit.JSONThemesListARRAY.size()-1)
			
			panelMain2.add(buttonNextTHEME);
		
		if(INDEX_ITEM>0)
			panelMain2.add(buttonPreviousTHEME);
		
			
		System.out.println(INDEX_ITEM);
		
	}
	
	
	public class listenerButton implements ActionListener{
		
		
		
		
		public void actionPerformed(ActionEvent e){
			
			
			//dura
			
			
			THEME1.setEditable(false);
		    textFieldNewTheme.setEditable(false);
			
			if(e.getSource() == boxChooseTheme )
			{
				
				remove(buttonPreviousTHEME);
				remove(buttonNextTHEME);
				
				INDEX_ITEM=boxChooseTheme.getSelectedIndex();
				if(INDEX_ITEM<MaterialsEdit.JSONThemesListARRAY.size()-1)
					
					panelMain2.add(buttonNextTHEME);
				
				if(INDEX_ITEM>0)
					panelMain2.add(buttonPreviousTHEME);
				
				
				
				System.out.println(INDEX_ITEM);
				
				
				
				MaterialsEdit.checkMaterial(boxChooseTheme.getSelectedIndex());
				
				//dura
				
			}
			
			
			
			
			
		if(e.getSource() == buttonBACK)
		{ 
		
			
			timer.cancel();
			

			
			if(MainMenuFrame.TEACHER==false)
			{
				
				/*try{
					student.addTime();
					}
					catch(ParseException f){ f.getStackTrace();}*/
				
				int countRead=0;
			try {
				countRead=TestControl.ReadyThemes();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
				
			System.out.println(countRead);
			if(countRead!=0){
			

			try {
				TestFrame TestFr;
				TestFr=new TestFrame();
				TestFr.setVisible(true);	
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
			
			
			
			
			
			
			}
			
			
			
			if(MainMenuFrame.TEACHER==true )
			{	
		Main.mainFrame.setVisible(true);}
			
			
			if(countChosenThemes==0 && MainMenuFrame.TEACHER==false){
				
				
				Document DocFrame;
				try {
					DocFrame=new Document();
					DocFrame.setVisible(true);	
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		dispose();
		}
		
		
		if(e.getSource() == buttonNextTHEME ){
		
			
			
			
			INDEX_ITEM++;
			addButtons();
			
			
			boxChooseTheme.setSelectedIndex(INDEX_ITEM);
			MaterialsEdit.checkMaterial(INDEX_ITEM);	
			
			}
			
		if(e.getSource() == buttonPreviousTHEME ){
		
			INDEX_ITEM--;
			addButtons();
		
		
		
		boxChooseTheme.setSelectedIndex(INDEX_ITEM);
		MaterialsEdit.checkMaterial(INDEX_ITEM);	
		
		}
		
		
		if(e.getSource() == buttonCreate ){
			
			
			THEME1.setEditable(true);
			textFieldNewTheme.setEditable(true);
			
			RemoveButtons();
			
			
			
			panelMain2.add(buttonConfirmAdd);
			
			materialHelp.setText("");
			
			textFieldNewTheme.setText("");
			THEME1.setText("");
			
		}
		
		if(e.getSource() == buttonDelete ){
			THEME_DEL=boxChooseTheme.getSelectedItem().toString();
			System.out.print("DELETE"+boxChooseTheme.getSelectedItem());
			
			MaterialsEdit.checkMaterial(boxChooseTheme.getSelectedIndex());
			RemoveButtons();
			materialHelp.setText("Р’РёРґР°Р»РµРЅРЅСЏ С‚РµРјРё.");
			
			panelMain2.add(YES);
			
			
			
			
		}
			
		
		
		if(e.getSource() == buttonConfirmAdd ){
			
			if(!textFieldNewTheme.getText().equals("") && !THEME1.getText().equals("") ){
				MaterialsEdit.addTheme(textFieldNewTheme.getText(), THEME1.getText());
				
				
				//TestControl.created(textFieldNewTheme.getText());
				
				
				 //panelMain2.add(buttonNextTHEME);	
					panelMain2.add(buttonPreviousTHEME);
					
					
		    boxChooseTheme.addItem(textFieldNewTheme.getText());
		    boxChooseTheme.setSelectedIndex(MaterialsEdit.JSONThemesListARRAY.size()-1);
		    INDEX_ITEM=MaterialsEdit.JSONThemesListARRAY.size()-1;
		    
		    
		    
			AddButtons();
			
			
			
			
			}
			
		}
		
		
		if(e.getSource() == buttonCancelAdd ){
			
			AddButtons();	
			remove(buttonSaveChanges);
			
		}
		
		if(e.getSource() == YES )
		{
			
			
			
			
		
			INDEX_ITEM=boxChooseTheme.getSelectedIndex();
			int ind =boxChooseTheme.getSelectedIndex();
			
		//	TestControl.deleted(boxChooseTheme.getSelectedItem().toString());
			
			
			boxChooseTheme.removeItemAt(INDEX_ITEM);
			
			System.out.println("ITEM:"+INDEX_ITEM);
			
			
			
			
			 MaterialsEdit.deleteTheme(ind);
			
			

			
			
			
			
			
			
			AddButtons();
			THEME1.setText("");
			textFieldNewTheme.setText("");
		}
		
		
		
		
		
		
		if(e.getSource() == buttonSave ){
			THEME1.setEditable(true);
			textFieldNewTheme.setEditable(true);
			MaterialsEdit.checkMaterial(boxChooseTheme.getSelectedIndex());
			
			RemoveButtons();
			materialHelp.setText("Р РµРґР°РєС‚РёСЂРѕРІР°РЅРёРµ С‚РµРјС‹.");
 panelMain2.add(buttonSaveChanges);			
			
			
		}
		
		if(e.getSource() == buttonSaveChanges){
			
			INDEX_ITEM= boxChooseTheme.getSelectedIndex();
			String OLD = new String(); 
			OLD = boxChooseTheme.getSelectedItem().toString();
			
			if(!textFieldNewTheme.getText().equals("") && !THEME1.getText().equals("") ){
				
				
				MaterialsEdit.editTheme(textFieldNewTheme.getText(),THEME1.getText(),INDEX_ITEM);
			
				
				
			
				try {
					TestControl.edit(OLD, textFieldNewTheme.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				// boxChooseTheme.set
			
			
				boxChooseTheme.insertItemAt(textFieldNewTheme.getText(), INDEX_ITEM);
				boxChooseTheme.removeItemAt(INDEX_ITEM+1);
		}
			
			
			AddButtons();
			remove(buttonSaveChanges);
		
		}
		
		
		
		if(e.getSource() == addQuestion){
			THEME1.setEditable(true);
			textFieldNewTheme.setEditable(true);
			QUESTION QUE_FRAME;

			QUE_FRAME=new QUESTION();
			QUE_FRAME.setVisible(true);
			//QUE_FRAME
			
			
			
			
		}
		
		
		
		
		if(e.getSource() == includeInTest)
		{
			
			countChosenThemes++;
			INDEX_ITEM= boxChooseTheme.getSelectedIndex();
			
		TestControl.changeThemeMark(boxChooseTheme.getSelectedItem().toString(), INDEX_ITEM, "READY");
			

	    	
		remove(includeInTest); 
		panelMain2.add(deleteFromTest);	
		
	}
		
		
		
		
		
		if(e.getSource() == deleteFromTest)
		{
			countChosenThemes--;
			INDEX_ITEM= boxChooseTheme.getSelectedIndex();
			
			TestControl.changeThemeMark(boxChooseTheme.getSelectedItem().toString(), INDEX_ITEM, "");
			
			
			remove(deleteFromTest);
			panelMain2.add(includeInTest);
			
		}
		
	}
	
	
	





	}

	
}

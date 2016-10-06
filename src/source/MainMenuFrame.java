package source;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MainMenuFrame extends JFrame 
{

	static public boolean TEACHER;
	
	static public int USER_IND;
	static public String TestMaterials[];
	
	static public String login;
	static public ThemeFrame mainFRAME;
	
	private static final long serialVersionUID = 1L;
	public static JPanel panelMain;
	public static JButton buttonAuthorization, buttonRegistration,buttonChooseTheme,buttonMarks, buttonRate, buttonReg, buttonBackToMain, buttonBackToAutorisation,buttonBackToMain1;
	public static JTextField textFieldLogin,textFieldName,textFieldSurname,textFieldFatherName,textFieldGroup, textFieldNewLogin;
	public static JLabel loginHelp,passwordHelp, entryHelp, nameHelp,surnameHelp, fathernameHelp, groupHelp,newLoginHelp, newPasswordHelp, newPasswordVerHelp, regHelp, ENThelp, enterHelp, NL,SL,FL,GL ;
	public static JLabel loginHelp1,passwordHelp1, entryHelp1, nameHelp1,surnameHelp1, fathernameHelp1, groupHelp1,newLoginHelp1, newPasswordHelp1, newPasswordVerHelp1, regHelp1, ENThelp1, enterHelp1, NL1,SL1,FL1,GL1 ;
	public static JPasswordField textFieldPassword,textFieldNewPassword,textFieldNewPasswordVer;
	public static JRadioButton radioStudent, radioTeacher;
	
	
	

	
	
	
	
	public MainMenuFrame() throws ParseException
	{
		
		createMainMenuFrame();	
	
	}

	public void createMainMenuFrame() throws ParseException 
	{
	
		
		

		FunctionsOnFiles.parseAllUsers();

		
		
		
		
		
		
		
		
	   
		
		

		setLocation(50,50);
		setSize(500,600);
		setTitle("Обучающая программа.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		panelMain = new JPanel();
		panelMain.setLayout(null);
		
		entryHelp =new JLabel("Введите логин и пароль");
		entryHelp.setSize(330,20);
		entryHelp.setLocation(165,135);
		entryHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(entryHelp);
		
		/*ENThelp =new JLabel("Увійти як: ");
		ENThelp.setSize(85,20);
		ENThelp.setLocation(72,120);
		ENThelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(ENThelp);*/
		

		
		
		radioStudent = new JRadioButton("Студент");
		radioStudent.setLocation(150,170);
		radioStudent.setSize(80,20);
		radioStudent.setFont(new Font("Verdana", Font.ITALIC,12));
		radioStudent.setSelected(true);
		panelMain.add(radioStudent);


		radioTeacher = new JRadioButton("Преподаватель");
		radioTeacher.setLocation(235,170);
		radioTeacher.setSize(150,20);
		radioTeacher.setFont(new Font("Verdana", Font.ITALIC,12));
		panelMain.add(radioTeacher);


		ButtonGroup studentOrTeacher = new ButtonGroup();
		studentOrTeacher.add(radioStudent);
		studentOrTeacher.add(radioTeacher);
		
		loginHelp =new JLabel("Логин: ");
		loginHelp.setSize(70,20);
		loginHelp.setLocation(85,200);
		loginHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(loginHelp);
		
		passwordHelp =new JLabel("Пароль: ");
		passwordHelp.setSize(65,20);
		passwordHelp.setLocation(85,250);
		passwordHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(passwordHelp);
		
		textFieldLogin =new JTextField();
		textFieldLogin.setSize(200,20);
		textFieldLogin.setLocation(150,200);
		panelMain.add(textFieldLogin);
		
		textFieldPassword =new JPasswordField();
		textFieldPassword.setSize(200,20);
		textFieldPassword.setLocation(150,250);
		panelMain.add(textFieldPassword);
		
	
		
		buttonAuthorization = new JButton("Войти");
	    buttonAuthorization.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonAuthorization.setSize(200,30);
		buttonAuthorization.setLocation(150,300);
		panelMain.add(buttonAuthorization);


		buttonBackToMain = new JButton("Назад");
		
		buttonBackToMain.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonBackToMain.setSize(200,30);
	
		buttonBackToMain1 = new JButton("Зарегестрироваться");
		
		buttonBackToMain1.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonBackToMain1.setSize(200,30);
		
		buttonRegistration = new JButton("Регистрация");
		buttonRegistration.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonRegistration.setSize(200,30);
		buttonRegistration.setLocation(150,350);
		panelMain.add(buttonRegistration);



		//************************************************************************************************************************************************************
		//****************************************************ENTRY INFORMATION***************************************************************************************

		enterHelp =new JLabel();
		enterHelp.setSize(280,20);
		enterHelp.setFont(new Font("Verdana", Font.ITALIC,14));

		NL =new JLabel();
		NL.setSize(280,20);
		NL.setFont(new Font("Verdana", Font.ITALIC,14));


		SL =new JLabel();
		SL.setSize(280,20);
		SL.setFont(new Font("Verdana", Font.ITALIC,14));


		FL =new JLabel();
		FL.setSize(280,20);
		FL.setFont(new Font("Verdana", Font.ITALIC,14));
		
		
		GL =new JLabel();
		GL.setSize(280,20);
		GL.setFont(new Font("Verdana", Font.ITALIC,14));



		//************************************************************************************************************************************************************
		//****************************************************THEME BUTTONS*******************************************************************************************




		buttonBackToAutorisation = new JButton("Выход");
		buttonBackToAutorisation.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonBackToAutorisation.setSize(200,30);







		//************************************************************************************************************************************************************
		//****************************************************TEXT AREAS**********************************************************************************************




		setContentPane(panelMain); //відображення

		ActionListener listenerButtonsMain= new listenerButtonsMain();
		ActionListener listenerRadioButtons= new listenerRadioButtons();
		buttonAuthorization.addActionListener(listenerButtonsMain);
		buttonRegistration.addActionListener(listenerButtonsMain);
		buttonBackToMain.addActionListener(listenerButtonsMain);
		buttonBackToMain1.addActionListener(listenerButtonsMain);



		radioTeacher.addActionListener(listenerRadioButtons);
		radioStudent.addActionListener(listenerRadioButtons);



	}

	public class listenerRadioButtons implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{

		if(e.getSource() == radioTeacher)
		{
		

		
		    //buttonAuthorization.setLocation(550,300);
			//buttonRegistration.setLocation(550,350);

			repaint();



		}

		if(e.getSource() == radioStudent)
		{
			
			
			//buttonAuthorization.setLocation(550,250);
			//buttonRegistration.setLocation(550,300);

			repaint();
		


		}
		}




	}

public class listenerButtonsMain implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		
	if(e.getSource() == buttonRegistration)
	{ 	
		panelMain.removeAll();
	     
	     regHelp =new JLabel("Заполните поля: ");
	     regHelp.setSize(320,20);
	     regHelp.setLocation(200,70);
		 regHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		 panelMain.add(regHelp); 
	     
	    nameHelp =new JLabel("Имя: ");
	 	nameHelp.setSize(50,20);
	 	nameHelp.setLocation(60,100);
	 	nameHelp.setFont(new Font("Verdana", Font.ITALIC,14));
	 	panelMain.add(nameHelp);
	     
		textFieldName =new JTextField();
		textFieldName.setSize(200,20);
		textFieldName.setLocation(150,100);
		panelMain.add(textFieldName);			
		
		surnameHelp =new JLabel("Фамилия: ");
		surnameHelp.setSize(100,20);
		surnameHelp.setLocation(60,150);
		surnameHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(surnameHelp);
		
		textFieldSurname =new JTextField();
		textFieldSurname.setSize(200,20);
		textFieldSurname.setLocation(150,150);
		panelMain.add(textFieldSurname);				
		
		fathernameHelp =new JLabel("Отчество: ");
		fathernameHelp.setSize(130,20);
		fathernameHelp.setLocation(60,200);
		fathernameHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(fathernameHelp);
		
		textFieldFatherName =new JTextField();
		textFieldFatherName.setSize(200,20);
		textFieldFatherName.setLocation(150,200);
		panelMain.add(textFieldFatherName);				
		
		groupHelp =new JLabel("Группа: ");
		groupHelp.setSize(80,20);
		groupHelp.setLocation(60,250);
		groupHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(groupHelp);
		
		textFieldGroup =new JTextField();
		textFieldGroup.setSize(200,20);
		textFieldGroup.setLocation(150,250);
		panelMain.add(textFieldGroup);				
		
		newLoginHelp =new JLabel("Логин: ");
		newLoginHelp.setSize(170,20);
		newLoginHelp.setLocation(60,300);
		newLoginHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(newLoginHelp);
		
		textFieldNewLogin =new JTextField();
		textFieldNewLogin.setSize(200,20);
		textFieldNewLogin.setLocation(150,300);
		panelMain.add(textFieldNewLogin);				
		
		newPasswordHelp =new JLabel("Придумайте пароль: ");
		newPasswordHelp.setSize(170,20);
		newPasswordHelp.setLocation(0,350);
		newPasswordHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(newPasswordHelp);
		
		textFieldNewPassword =new JPasswordField();
		textFieldNewPassword.setSize(200,20);
		textFieldNewPassword.setLocation(150,350);
		panelMain.add(textFieldNewPassword);				
		
		newPasswordVerHelp =new JLabel("Повторите пароль: ");
		newPasswordVerHelp.setSize(170,20);
		newPasswordVerHelp.setLocation(0,400);
		newPasswordVerHelp.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(newPasswordVerHelp);
		
		textFieldNewPasswordVer =new JPasswordField();
		textFieldNewPasswordVer.setSize(200,20);
		textFieldNewPasswordVer.setLocation(150,400);
		panelMain.add(textFieldNewPasswordVer);
				
		buttonReg = new JButton("Зарегестрироваться");
		buttonReg.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonReg.setLocation(150,450);
		buttonReg.setSize(200,30);
	    panelMain.add(buttonReg); 
	    buttonReg.setVisible(false);
	    
	    buttonBackToMain.setLocation(150,500);
	    panelMain.add(buttonBackToMain);
	    
	    buttonBackToMain1.setLocation(150,450);
	    panelMain.add(buttonBackToMain1);
	    
	    ActionListener listenerButtonReg= new listenerButtonReg();
	    buttonReg.addActionListener(listenerButtonReg);
	   
	     repaint();
	    
	}
	
	if(e.getSource() == buttonRegistration && radioTeacher.isSelected())
	{ 	
		panelMain.removeAll();
	     
	     regHelp1 =new JLabel("Заполните поля: ");
	     regHelp1.setSize(320,20);
	     regHelp1.setLocation(200,70);
		 regHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		 panelMain.add(regHelp1); 
	     
	    nameHelp1 =new JLabel("Имя: ");
	 	nameHelp1.setSize(50,20);
	 	nameHelp1.setLocation(60,100);
	 	nameHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
	 	panelMain.add(nameHelp1);
	     
		textFieldName =new JTextField();
		textFieldName.setSize(200,20);
		textFieldName.setLocation(150,100);
		panelMain.add(textFieldName);
			
		
		surnameHelp1 =new JLabel("Фамилия: ");
		surnameHelp1.setSize(100,20);
		surnameHelp1.setLocation(60,150);
		surnameHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(surnameHelp1);
		
		textFieldSurname =new JTextField();
		textFieldSurname.setSize(200,20);
		textFieldSurname.setLocation(150,150);
		panelMain.add(textFieldSurname);
				
		
		fathernameHelp1 =new JLabel("Отчество: ");
		fathernameHelp1.setSize(130,20);
		fathernameHelp1.setLocation(60,200);
		fathernameHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(fathernameHelp1);
		
		textFieldFatherName =new JTextField();
		textFieldFatherName.setSize(200,20);
		textFieldFatherName.setLocation(150,200);
		panelMain.add(textFieldFatherName);
				
		
		groupHelp1 =new JLabel("Кафедра: ");
		groupHelp1.setSize(80,20);
		groupHelp1.setLocation(60,250);
		groupHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(groupHelp1);
		
		textFieldGroup =new JTextField();
		textFieldGroup.setSize(200,20);
		textFieldGroup.setLocation(150,250);
		panelMain.add(textFieldGroup);
				
		
		newLoginHelp1 =new JLabel("Логин: ");
		newLoginHelp1.setSize(170,20);
		newLoginHelp1.setLocation(60,300);
		newLoginHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(newLoginHelp1);
		
		textFieldNewLogin =new JTextField();
		textFieldNewLogin.setSize(200,20);
		textFieldNewLogin.setLocation(150,300);
		panelMain.add(textFieldNewLogin);
				
		
		newPasswordHelp1 =new JLabel("Придумайте пароль: ");
		newPasswordHelp1.setSize(170,20);
		newPasswordHelp1.setLocation(0,350);
		newPasswordHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(newPasswordHelp1);
		
		textFieldNewPassword =new JPasswordField();
		textFieldNewPassword.setSize(200,20);
		textFieldNewPassword.setLocation(150,350);
		panelMain.add(textFieldNewPassword);
				
		
		newPasswordVerHelp1 =new JLabel("Повторите пароль: ");
		newPasswordVerHelp1.setSize(170,20);
		newPasswordVerHelp1.setLocation(0,400);
		newPasswordVerHelp1.setFont(new Font("Verdana", Font.ITALIC,14));
		panelMain.add(newPasswordVerHelp1);
		
		textFieldNewPasswordVer =new JPasswordField();
		textFieldNewPasswordVer.setSize(200,20);
		textFieldNewPasswordVer.setLocation(150,400);
		panelMain.add(textFieldNewPasswordVer);
			
	
		/*buttonReg = new JButton("ЗАРЕЄСТРУВАТИСЬ");
		buttonReg.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonReg.setLocation(550,450);
		buttonReg.setSize(200,30);
	    panelMain.add(buttonReg); */ 
	    
	    buttonBackToMain.setLocation(150,500);
	    panelMain.add(buttonBackToMain);
	    
	    buttonBackToMain1.setLocation(150,450);
	    panelMain.add(buttonBackToMain1);
	    
	    ActionListener listenerButtonReg= new listenerButtonReg();
	    buttonReg.addActionListener(listenerButtonReg);
	   
	     repaint();
	    
	}
	
	
	if(e.getSource() == buttonAuthorization)
	{ 	
		int numberInList;
		try {
			numberInList = FunctionsOnFiles.checkAuthorization(textFieldLogin.getText(), textFieldPassword.getPassword(),radioTeacher.isSelected());
		
		if(numberInList>=0)
		{
			panelMain.removeAll();
		     
			
			JSONObject userIn = (JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(numberInList);
			enterHelp.setLocation(30,20);
			
			System.out.println("teacher: "+radioTeacher.isSelected()+"\nstudent:"+radioStudent.isSelected());

			if(radioTeacher.isSelected()&&numberInList==0)
			{
				
				//GL.setText("Кафедра: ".concat((String)userIn.get("Kafedra")));
				//enterHelp.setText("Ви увійшли до системи як: Вчитель");
				TEACHER=true;
			}
			else
			{
				
				/*login=textFieldLogin.getText();
				GL.setText("Група: ".concat((String)userIn.get("Group")));
				enterHelp.setText("Ви увійшли до системи як: Студент");*/
				TEACHER=false;
			}

			/*GL.setLocation(30,100);
			panelMain.add(GL);
			panelMain.add(enterHelp);

			NL.setLocation(30,40);
			NL.setText("Iм'я: ".concat((String)userIn.get("Name")));
			panelMain.add(NL);

			
			SL.setLocation(30,60);
			SL.setText("Прізвище: ".concat((String) userIn.get("Surname")));
			panelMain.add(SL);
			
			
			FL.setLocation(30,80);
			FL.setText("По батькові: ".concat((String)userIn.get("Father_name")));
			panelMain.add(FL);*/
			
	
		     buttonChooseTheme = new JButton("Темы");
		     buttonChooseTheme.setFont(new Font("Verdana",Font.ITALIC,12));
		     buttonChooseTheme.setLocation(150,200);
		     buttonChooseTheme.setSize(200,30);
		     panelMain.add(buttonChooseTheme);
		     
		     buttonMarks = new JButton("Успеваемость студента");
		     buttonMarks.setFont(new Font("Verdana",Font.ITALIC,12));
		     buttonMarks.setLocation(150,250);
		     buttonMarks.setSize(200,30);
		     
		     buttonRate = new JButton("Успеваемость студентов");
		     buttonRate.setFont(new Font("Verdana",Font.ITALIC,12));
		     buttonRate.setLocation(150,250);
		     buttonRate.setSize(200,30);
		     
		    // panelMain.add(buttonMarks);
		     if(TEACHER==false){
		 		panelMain.add(buttonMarks);
		 		remove(buttonRate);
		     }
		 	else {remove(buttonMarks);
		 	panelMain.add(buttonRate);}
		     		     
		     ActionListener listenerButtonsAuthorizations = new listenerButtonsAuthorizations();

		     buttonChooseTheme.addActionListener(listenerButtonsAuthorizations);
		     buttonMarks.addActionListener(listenerButtonsAuthorizations);
		     
		     buttonRate.addActionListener(listenerButtonsAuthorizations);
		     buttonBackToMain.setLocation(150,300);
		     panelMain.add(buttonBackToMain);
		     
		
		     
		     repaint();
		
		     
		   
		    
		}
		
		else
		{
			JLabel errors = new JLabel("Неправильно введен логин или пароль!");
			errors.setSize(1280,120);
			errors.setLocation(750,100);
			errors.setForeground(Color.RED);
			errors.setFont(new Font("Times new Roman", Font.ITALIC, 15));
			panelMain.add(errors);
			repaint();
			
		}
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
if(MainMenuFrame.TEACHER!=true){
			
			
			try {
				TestControl.addNewTest();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		
		
	}
		
	
	
	
	
	
	if(e.getSource() == buttonBackToMain || e.getSource() == buttonBackToMain1 )
	{
	panelMain.removeAll();

	panelMain.add(entryHelp);
	panelMain.add(radioStudent);
	panelMain.add(radioTeacher);
	//panelMain.add(ENThelp);
	panelMain.add(loginHelp);
	
	if(radioTeacher.isSelected()){
	}
	panelMain.add(passwordHelp);
	textFieldPassword.setText("");
	textFieldLogin.setText("");
	
	panelMain.add(textFieldLogin);
	panelMain.add(textFieldPassword);
	
	panelMain.add(buttonAuthorization);
	panelMain.add(buttonRegistration);

	repaint();

	}
	}
			
	
} 

public class listenerButtonsAuthorizations implements ActionListener{

@Override
public void actionPerformed(ActionEvent e) {

	
	
	ActionListener listenerButtonsMarks = new listenerButtonsMarks();
	buttonBackToAutorisation.addActionListener(listenerButtonsMarks);
	
if(e.getSource() == buttonChooseTheme)
{
	setVisible(false);
	

		try {
			mainFRAME =new ThemeFrame();
			mainFRAME.setVisible(true);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	
	
	

repaint();

}





if(e.getSource() ==buttonRate){
	
	LecturerControl teacherCtrl;
	try {
		teacherCtrl=new LecturerControl();
		teacherCtrl.setVisible(true);	
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	







setVisible(false);	
	
}


if(e.getSource() == buttonMarks)
{

//panelMain.removeAll();



	Document DocFr;
	try {
		DocFr=new Document();
		DocFr.setVisible(true);	
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	



//buttonBackToAutorisation.setLocation(150,500);
//panelMain.add(buttonBackToAutorisation);



//repaint();
setVisible(false);
}



}

}

public class listenerButtonsMarks implements ActionListener{

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == buttonBackToAutorisation)
	{
		panelMain.removeAll();	
		
		panelMain.add(enterHelp);
		panelMain.add(NL);

		panelMain.add(SL);
		
		panelMain.add(FL);
		
		panelMain.add(buttonChooseTheme);		
		
		  buttonBackToMain.setLocation(150,300);
		     panelMain.add(buttonBackToMain);
		repaint();
		}
	
	
}}





public class listenerButtonReg implements ActionListener{

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == buttonReg)
	{

		JLabel errors = new JLabel();
		errors.setSize(1280,120);
		errors.setLocation(0,0);
		errors.setFont(new Font("Verdana", Font.ITALIC, 15));
		panelMain.add(errors);
		
		if(!student.checkFieldsRegistration(textFieldName.getText(),
				textFieldSurname.getText(), textFieldFatherName.getText(), textFieldGroup.getText(),
					textFieldNewLogin.getText(), new String(textFieldNewPassword.getPassword()),
					new String(textFieldNewPasswordVer.getPassword()),errors ))
		{
			
			repaint();
			
			student.registration(textFieldName.getText(), textFieldSurname.getText(), textFieldFatherName.getText(), textFieldGroup.getText(), textFieldNewLogin.getText(), new String(textFieldNewPassword.getPassword()));

			
			
			
			
		}
			
	}
}


}

}
	
	






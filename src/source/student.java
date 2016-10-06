package source;

import java.awt.Color;
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

import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class student {
	
	
	
	
	public static void registration(String name, String surname, String fathername, String group, String login, String pasw){
		
		for(int j=0;j<FunctionsOnFiles.JSONTeacherListARRAY.size();j++)
		{
			JSONObject usersTeacher = new JSONObject();
			usersTeacher = (JSONObject)FunctionsOnFiles.JSONTeacherListARRAY.get(j);
			System.out.println(usersTeacher.get("Name"));
			
			if(usersTeacher.get("Name").equals(name))
				if(usersTeacher.get("Surname").equals(surname))
					if(usersTeacher.get("Father_name").equals(fathername))
						if(usersTeacher.get("Group").equals(group))
						{
							boolean userInDB=false;
							for(int i=0;i<FunctionsOnFiles.JSONUsersListARRAY.size();i++)
							{
								FunctionsOnFiles.CurrentUser = (JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(i);
								if((login).equals(FunctionsOnFiles.CurrentUser.get("Login")))
									userInDB = true;
							}
							
							
							if(!userInDB)
							{
								
							
								MainMenuFrame.USER_IND=j;
								
								
								System.out.println("TIPO DOBAVLENIE");
								JSONObject userAdd = new JSONObject();
								userAdd.put("Name", name);
								userAdd.put("Surname", surname);
								userAdd.put("Father_name", fathername);
								userAdd.put("Group", group);
								userAdd.put("Login", login);
								userAdd.put("Password", pasw);
								
								userAdd.put("Time",0);
								userAdd.put("MARKS", 0);
								
								userAdd.put("BADMARKS", 0);
								
								FunctionsOnFiles.JSONUsersListARRAY.add(userAdd);
								
								JSONArray ARRtest = new JSONArray();
								
								  for(int i=0;i<MainMenuFrame.TestMaterials.length;i++)
								    {
								    
									  JSONObject obj = new JSONObject();
								  
									  obj.put("Theme", MainMenuFrame.TestMaterials[i]);
									  obj.put("Mark", "");
									  ARRtest.add(obj);
								    }
								
								  
									try (FileWriter file = new FileWriter("D:\\КурсоваяТХТ\\"+name+surname+login+".txt")) {
										file.write(ARRtest.toJSONString());
										System.out.println("Successfully Copied JSON Object to File...");
										
									} catch (IOException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
								
								
								
							
								
								
								File fileUsersList = new File("D:\\КурсоваяТХТ\\UsersList.txt");
								try 
								{
									PrintWriter pw = new PrintWriter(fileUsersList);
									pw.print(FunctionsOnFiles.jsonObjUsersList.toString());
									pw.close();
								} 
								catch (FileNotFoundException e1) 
								{
									e1.printStackTrace();
								}
								FunctionsOnFiles.JSONTeacherListARRAY.remove(j);
								
								File fileTeacherList = new File("D:\\КурсоваяТХТ\\TeacherList.txt");
								try 
								{
									PrintWriter pw = new PrintWriter(fileTeacherList);
									pw.print(FunctionsOnFiles.jsonObjTeacherList.toString());
									pw.close();
								} 
								catch (FileNotFoundException e1) 
								{
									e1.printStackTrace();
								}
								
								
								
								
								
								
								MainMenuFrame.panelMain.removeAll();
								
								MainMenuFrame.panelMain.add(MainMenuFrame.entryHelp);
								MainMenuFrame.panelMain.add(MainMenuFrame.radioStudent);
								MainMenuFrame.panelMain.add(MainMenuFrame.radioTeacher);
								MainMenuFrame.panelMain.add(MainMenuFrame.ENThelp);
								MainMenuFrame.panelMain.add(MainMenuFrame.loginHelp);
							
								if(MainMenuFrame.radioTeacher.isSelected())
								{
								
									
								
								}
								MainMenuFrame.panelMain.add(MainMenuFrame.passwordHelp);
								MainMenuFrame.textFieldPassword.setText("");
								MainMenuFrame.textFieldLogin.setText("");
							
								MainMenuFrame.panelMain.add(MainMenuFrame.textFieldLogin);
								MainMenuFrame.panelMain.add(MainMenuFrame.textFieldPassword);
								
								MainMenuFrame.panelMain.add(MainMenuFrame.buttonAuthorization);
								MainMenuFrame.panelMain.add(MainMenuFrame.buttonRegistration);
								MainMenuFrame.panelMain.repaint();
							
							}
						}
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void USR_TEST(String usrname, String surname, String login) throws ParseException{
		
		if(MainMenuFrame.TEACHER==false){
		String bufferStudent = new String();
		

		
			    try {
			        //Объект для чтения файла в буфер
			    	
			    	FileInputStream fileStudList = new FileInputStream("D:\\КурсоваяТХТ\\"+usrname+surname+login+".txt");
			    	
			        BufferedReader inStudListBuf = new BufferedReader(new InputStreamReader(fileStudList, "Cp1251"));
			        
			        
			        
			        try {
			            //В цикле построчно считываем файл
			            String ss;
			            while ((ss = inStudListBuf.readLine()) != null) 
			            {
			            	bufferStudent = new String(bufferStudent.concat("\n"));
			            	bufferStudent = new String(bufferStudent.concat(ss));
			            }
			           
			        }
			      finally {
			            //Также не забываем закрыть файл
			    	  inStudListBuf.close();
			           
			        }
			    } catch(IOException eee) 
			        {
			        	throw new RuntimeException(eee);
			    	}
			    
			    JSONParser parserStudList = new JSONParser();
			    

			    Object objectParseStud = parserStudList.parse(bufferStudent);
			    
			    
			   TestControl.JSONStudListARRAY = (JSONArray) objectParseStud;
			   
			   

			    	
				
				
			    
			    System.out.println( TestControl.JSONStudListARRAY);
		}
		
		
	}
	
	
	
	public static void startTimer()
	{
		ThemeFrame.sec=0;
	ThemeFrame.timer = new Timer();
	ThemeFrame.timer.schedule(new TimerTask(){

	@Override
	public void run()
	{
		ThemeFrame.sec++;
	//labelSec.setText("Sec :"+sec);
	ThemeFrame.panelMain2.repaint();
	//System.out.println(sec);
	}

	}, 1000, 1000);

	}


	public static void addTime() throws ParseException
	{

	String buffer = new String();

	try
	{
	//Объект для чтения файла в буфер

	FileInputStream fileUsersList = new FileInputStream("D:\\КурсоваяТХТ\\UsersList.txt");
	BufferedReader inUsersList = new BufferedReader(new InputStreamReader(fileUsersList, "Cp1251"));


	try
	{
	//В цикле построчно считываем файл
	String s;
	while ((s = inUsersList.readLine()) != null)
	{
	buffer = new String(buffer.concat("\n"));
	buffer = new String(buffer.concat(s));
	}
	}
	finally
	{
	//Также не забываем закрыть файл
	inUsersList.close();
	}
	}
	catch(IOException e)
	{
	throw new RuntimeException(e);
	}

	//JSONParser parser = new JSONParser();
	//Object obj = parser.parse(buffer);
	//JSONObject jsonObj = (JSONObject)obj;
	//JSONArray jsonArray = (JSONArray)jsonObj.get("Users");
	for(int i=0;i<FunctionsOnFiles.JSONUsersListARRAY.size();i++)
	if(MainMenuFrame.login.equals(((JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(i)).get("Login").toString())){
	((JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(i)).replace("Time",((JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(i)).get("Time").hashCode()+ThemeFrame.sec);
	JSONObject time= (JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(i);
	ThemeFrame.Time=time.get("Time").toString();
	
	}
	
	File fileUsersList = new File("D:\\КурсоваяТХТ\\UsersList.txt");
	try
	{
	PrintWriter pw = new PrintWriter(fileUsersList);
	pw.print(FunctionsOnFiles.jsonObjUsersList.toString());
	pw.close();
	}
	catch (FileNotFoundException e1)
	{
	e1.printStackTrace();
	}

	}
	
	
	
	
	
	public static boolean checkFieldsRegistration(String name, String surname, String father_name, String group,
			  String login, String passwordNew,String passwordVer, JLabel errors)
{

boolean checkFieldsErrors = false;

errors.setText("");
errors.setForeground(Color.RED);

if(name.equals(""))
{
errors.setText(" |Поле 'ім'я' пусте| \n");
checkFieldsErrors = true;
}
if(surname.equals(""))
{
errors.setText((errors.getText()).concat(" |Поле 'прізвище' пусте| \n"));
checkFieldsErrors = true;
}
if(father_name.equals(""))
{
errors.setText((errors.getText()).concat(" |Поле 'по батькові' пусте| \n"));
checkFieldsErrors = true;
} 

if(group.equals(""))
{
errors.setText((errors.getText()).concat(" |Поле 'група' пусте| \n"));
checkFieldsErrors = true;
}

if(login.equals(""))
{
errors.setText((errors.getText()).concat(" |Поле 'логін' пусте| \n"));
checkFieldsErrors = true;
}

if(passwordNew.equals(""))
{
errors.setText((errors.getText()).concat(" |Поле 'пароль' пусте| \n"));
checkFieldsErrors = true;
}

if(!passwordNew.equals(passwordVer))
{
errors.setText((errors.getText()).concat(" |Паролі не співпадають| \n"));
checkFieldsErrors = true;
}

return checkFieldsErrors;

}

}

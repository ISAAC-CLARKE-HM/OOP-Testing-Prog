package source;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FunctionsOnFiles {
	static public String USRNAME;
	static public String SURNAME;
	static public String FATHER_NAME;
	
	static public String LOGIN;
	
	static public String GROUP;
	static public String TIME;
	
	static public int usr_num;
	static public int TEACH;
	static public int count_themes;
	
	public static JSONArray JSONUsersListARRAY,JSONTeacherListARRAY;
	public static JSONObject jsonObjUsersList;

	static JSONObject jsonObjTeacherList;

	public static JSONObject CurrentUser;
	
	
	
	public static void parseAllUsers() throws ParseException{
		String buffer = new String();
		String buffer1 = new String();
		
	    try {
	        //Объект для чтения файла в буфер
	    	
	    	FileInputStream fileUsersList = new FileInputStream("D:\\КурсоваяТХТ\\UsersList.txt");
	    	FileInputStream fileTeacherList = new FileInputStream("D:\\КурсоваяТХТ\\TeacherList.txt");
	    	
	        BufferedReader inUsersList = new BufferedReader(new InputStreamReader(fileUsersList, "Cp1251"));
	        BufferedReader inTeacherList = new BufferedReader(new InputStreamReader(fileTeacherList, "Cp1251"));
	        
	        
	        try {
	            //В цикле построчно считываем файл
	            String s;
	            while ((s = inUsersList.readLine()) != null) 
	            {
	            	buffer = new String(buffer.concat("\n"));
	                buffer = new String(buffer.concat(s));
	            }
	            while ((s = inTeacherList.readLine()) != null) 
	            {
	            	buffer1 = new String(buffer1.concat("\n"));
	                buffer1 = new String(buffer1.concat(s));
	            }
	        }
	      finally {
	            //Также не забываем закрыть файл
	            inUsersList.close();
	            inTeacherList.close();
	        }
	    } catch(IOException e) 
	        {
	        	throw new RuntimeException(e);
	    	}
	    
	    JSONParser parserUsersList = new JSONParser();
	    JSONParser parserTeacherList = new JSONParser();

	    Object objectParseUsers = parserUsersList.parse(buffer);
	    Object objectParseTeacher = parserTeacherList.parse(buffer1);
	    
	    jsonObjUsersList = (JSONObject) objectParseUsers;
	    jsonObjTeacherList = (JSONObject) objectParseTeacher;
	   

	    JSONUsersListARRAY = (JSONArray) jsonObjUsersList.get("Users");
	    JSONTeacherListARRAY = (JSONArray) jsonObjTeacherList.get("Users");
		
		
		
		
	}
	
	
	public static int checkAuthorization(String login, char[] password, boolean isTeacher) throws ParseException 
	{
		for(int i=0; i< JSONUsersListARRAY.size(); i++)
		{
			
			JSONObject users = (JSONObject)JSONUsersListARRAY.get(i);
			System.out.println(users.get("Login"));
			System.out.println(users.get("Password"));
			
		
			
			if(users.get("Login").equals(login)&&users.get("Password").equals(new String(password)))
			{
				
				USRNAME=users.get("Name").toString();
				SURNAME=users.get("Surname").toString();
				FATHER_NAME=users.get("Father_name").toString();
				LOGIN=users.get("Login").toString();
				
				if(i!=0){
				usr_num=i;
				TIME=users.get("Time").toString();
				GROUP=users.get("Group").toString();}
				count_themes=0;
				
				
				
				if(i==0&&!isTeacher)
					return -1;
				if(i!=0&&isTeacher)
						return -1;
				
				return i;
			}
		}
		
		return -1;

	}
	
	

	


}

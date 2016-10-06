package source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestControl {
	
	public static JSONArray JSONCreateListARRAY;
	public static JSONObject jsonObjCreateList;
	
	public static JSONArray JSONDeleteListARRAY;
	public static JSONObject jsonObjDeleteList;
	
	public static JSONArray JSONEditListARRAY;
	public static JSONObject jsonObjEditList;
	
	public static JSONArray JSONStudListARRAY;
	
	
	public static int index_test;
	
	//public static  String THM[];
	

	
	
	
	
	

	
	
	
	public static void TEST__EDIT() throws ParseException{
		


////////////////////////////////////////////////////////////////////////////////////////////		
		
String bufferEdit = new String();
		
	    try {
	        //Объект для чтения файла в буфер
	    	
	    	FileInputStream fileEditList = new FileInputStream("D:\\КурсоваяТХТ\\EDIT.txt");
	    	
	        BufferedReader inEditListBuf = new BufferedReader(new InputStreamReader(fileEditList, "Cp1251"));
	        
	        
	        
	        try {
	            //В цикле построчно считываем файл
	            String ss;
	            while ((ss = inEditListBuf.readLine()) != null) 
	            {
	            	bufferEdit = new String(bufferEdit.concat("\n"));
	            	bufferEdit = new String(bufferEdit.concat(ss));
	            }
	           
	        }
	      finally {
	            //Также не забываем закрыть файл
	    	  inEditListBuf.close();
	           
	        }
	    } catch(IOException e) 
	        {
	        	throw new RuntimeException(e);
	    	}
	    
	    JSONParser parserEditList = new JSONParser();
	    
	    Object objectParseEdit = parserEditList.parse(bufferEdit);
	    	    
	    jsonObjEditList = (JSONObject) objectParseEdit;
	   	   

	    JSONEditListARRAY = (JSONArray) jsonObjEditList.get("Edit");
	
		
//////////////////////////////////////////////////////////////////////////////////////		
		
		

		
	}

	
	public static void edit(String oldTHEME, String newTHEME ) throws ParseException{
		
		
		TEST__EDIT();
		
		JSONObject editAdd = new JSONObject();
		editAdd.put("OldTheme", oldTHEME); 
		editAdd.put("NewTheme", newTHEME);
		TestControl.JSONEditListARRAY.add(editAdd);
		
		
		System.out.print(TestControl.JSONEditListARRAY.toJSONString());
		File fileEditList = new File("D:\\КурсоваяТХТ\\EDIT.txt");
		try 
		{
			PrintWriter printEdit = new PrintWriter(fileEditList);
			printEdit.print(TestControl.jsonObjEditList.toString());
			printEdit.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		
	}
	
	
public static void giveMark(JSONObject TEST, String MARK){
	
	for(int i=0;i<JSONStudListARRAY.size();i++)
    {
		JSONObject tempTheme = (JSONObject) TestControl.JSONStudListARRAY.get(i);
		
	if(TEST.get("Theme").toString().equals(tempTheme.get("Theme").toString()))	{
		TestControl.changeThemeMark(TEST.get("Theme").toString(),i,MARK);
		
		
	}
		
		
		
    }
	
	
	
	
}
	
	
	
	public static void changeThemeMark(String THEME, int INDEX, String mark ){
		JSONObject studThemeAdd = new JSONObject();
		studThemeAdd.put("Theme", THEME); 
		studThemeAdd.put("Mark", mark);
		JSONStudListARRAY.set(INDEX,studThemeAdd);
		
		
		System.out.print(JSONStudListARRAY.toJSONString());
		File fileStudList = new File("D:\\КурсоваяТХТ\\"+FunctionsOnFiles.USRNAME+FunctionsOnFiles.SURNAME+FunctionsOnFiles.LOGIN+".txt");
		try 
		{
			PrintWriter printStud = new PrintWriter(fileStudList);
			printStud.print(JSONStudListARRAY.toString());
			printStud.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	public static String complete(){
		
		String complBUF = new String();

		
		
		 Document.numCompl=0;
		
		for(int i=0;i<TestControl.JSONStudListARRAY.size();i++)
	    {
			
			JSONObject READY=(JSONObject)TestControl.JSONStudListARRAY.get(i);	
			if(READY.get("Mark").toString().equals("COMPL")){
				Document.numCompl++;
				LecturerControl.point++;
				complBUF = new String(complBUF.concat(Document.numCompl+")"));
				complBUF = new String(complBUF.concat(READY.get("Theme").toString())+"\n");
			}
	    }
		
		
		
		
		
	return complBUF;	
	}
	
	
	
	public static  String fail(){
		
		String FailBuf = new String();
		
		
		Document.numFail=0;
		for(int i=0;i<TestControl.JSONStudListARRAY.size();i++)
	    {
			
			JSONObject READY=(JSONObject)TestControl.JSONStudListARRAY.get(i);	
			if(READY.get("Mark").toString().equals("FAIL")){
				Document.numFail++;
				
				FailBuf = new String(FailBuf.concat(Document.numFail+")"));
				FailBuf = new String(FailBuf.concat(READY.get("Theme").toString())+"\n");
			}
	    }
		
		
		return FailBuf;
	}
	
	
	public static String inProc(){
		
		
		Document.numNotConpl=0;
		String NotConplBuf = new String();
		
		for(int i=0;i<TestControl.JSONStudListARRAY.size();i++)
	    {
			
			JSONObject READY=(JSONObject)TestControl.JSONStudListARRAY.get(i);	
			if(READY.get("Mark").toString().equals("READY") || READY.get("Mark").toString().equals("")){
				Document.numNotConpl++;
				NotConplBuf = new String(NotConplBuf.concat(Document.numNotConpl+")"));
				NotConplBuf = new String(NotConplBuf.concat(READY.get("Theme").toString())+"\n");
			}
	    }
		
		return NotConplBuf;
		
	}
	
	public static void printMarks(){
		
		((JSONObject) FunctionsOnFiles.JSONUsersListARRAY.get(FunctionsOnFiles.usr_num)).replace("MARKS", Document.numCompl);

		((JSONObject)FunctionsOnFiles.JSONUsersListARRAY.get(FunctionsOnFiles.usr_num)).replace("BADMARKS", Document.numFail);
		
		
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
	
	
	
	
	
public static void MarkCheck(){
		
		
		
		if(MainMenuFrame.TEACHER==false)
		{
			
		
		
		JSONObject markCheck = (JSONObject) TestControl.JSONStudListARRAY.get(ThemeFrame.INDEX_ITEM);
		int ready=0;
		if(markCheck.get("Mark").toString().equals("")){ 
			
			ThemeFrame.panelMain2.add(ThemeFrame.includeInTest);
			
			
			ThemeFrame.panelMain2.remove(ThemeFrame.deleteFromTest);		
			
			
			System.out.println(markCheck.get("Theme").toString());
		
		
		
		
		}
		else
		if(markCheck.get("Mark").toString().equals("READY")) {
			
			
			
			ThemeFrame.panelMain2.remove(ThemeFrame.includeInTest);
			
			
			ThemeFrame.panelMain2.add(ThemeFrame.deleteFromTest);		
		
		
		
		
		}

		else{
			
			ThemeFrame.panelMain2.remove(ThemeFrame.includeInTest);
							
							
			ThemeFrame.panelMain2.remove(ThemeFrame.deleteFromTest);
							
						}
		
				
		}
		
		
		
	}
	
	
	
	public static void addNewTest() throws ParseException{
		
		
		student.USR_TEST(FunctionsOnFiles.USRNAME, FunctionsOnFiles.SURNAME, FunctionsOnFiles.LOGIN);
		
		MaterialsEdit.ParseMaterial();
		TEST__EDIT();
		
		
		for(int i=0;i<JSONStudListARRAY.size();i++)
	    {
	   
	    
	    	String mark;
	    	JSONObject STUD=(JSONObject)JSONStudListARRAY.get(i);
	    	mark=STUD.get("Mark").toString();
	    	
	    	 for(int j=0;j<JSONEditListARRAY.size();j++)
			    {
	    		
	    		 JSONObject EDIT =(JSONObject)JSONEditListARRAY.get(j);
	    	if(STUD.get("Theme").toString().equals(EDIT.get("OldTheme"))){	
	    		System.out.println(mark);
	    	STUD.put("Theme",EDIT.get("NewTheme"));	
	    	STUD.put("Mark", mark);
	    	JSONStudListARRAY.set(i, STUD);
		    }
	    
	    	
	    	}
	   
	    	
	    		
	    		
	    		//TestControl.JSONStudListARRAY.remove(i);
	    		
	    		
	    		//System.out.print(TestControl.JSONStudListARRAY.toJSONString());
	    		
	    	
	    	
	    }
		
		
		
		
		
		
			
		
		
			boolean CR=true;
		    for(int i=0;i<MaterialsEdit.JSONThemesListARRAY.size();i++)
		    {
		    
		    	
		    	
		    	JSONObject CREATE =(JSONObject)MaterialsEdit.JSONThemesListARRAY.get(i);
		    	
		    	String CREAT=CREATE.get("Theme").toString();
		    	
		    	for(int j=0;j<JSONStudListARRAY.size();j++)
			    {
		    		JSONObject STUD=(JSONObject)JSONStudListARRAY.get(j);
		    		String STD=STUD.get("Theme").toString();
		    	if(CREAT.equals(STD)){	
		    		System.out.println("\nCREAT:"+CREAT+"\nSTD:"+STD);
		    		CR=true;	
		    		break;
			    }
		    	else CR=false;
		    
		    	
		    	}
		    
		    	System.out.print("CR:"+CR);
		    	if(CR==false){
		    		
		    		
		    		//System.out.print(JSONStudListARRAY.toJSONString());
		    		
		    		JSONObject StAdd = new JSONObject();
		    		StAdd.put("Theme",CREATE.get("Theme")); 
		    		StAdd.put("Mark",""); 
		    		JSONStudListARRAY.add(StAdd);
		    		
		    		
		    		//System.out.print(JSONStudListARRAY.toJSONString());
		    		
		    	}
		    	
		    }	
	
		    
		    
		    
if(JSONStudListARRAY.size()>MaterialsEdit.JSONThemesListARRAY.size()){
	
	
	
	
	
	
	int SIZE =JSONStudListARRAY.size();
	
		    	for(int SZ=0;SZ<SIZE;SZ++){
		    	int counter;
		    	for(int i=0;i<JSONStudListARRAY.size();i++)
			    {
			   
			    
			    	counter=0;
			    	JSONObject STUD=(JSONObject)JSONStudListARRAY.get(i);
			    	
			    	
			    	 for(int j=0;j<MaterialsEdit.JSONThemesListARRAY.size();j++)
					    {
			    		
			    		 JSONObject DELETE =(JSONObject)MaterialsEdit.JSONThemesListARRAY.get(j);
			    	if(STUD.get("Theme").toString().equals(DELETE.get("Theme"))){	
			    		counter++;	
			    		
				    }
			    
			    	
			    	}
			   
			    	if(counter==0){
			    		
			    		
			    		TestControl.JSONStudListARRAY.remove(i);
			    		
			    		
			    		//System.out.print(TestControl.JSONStudListARRAY.toJSONString());
			    		
			    	}
			    	
			    }	
		    	
		    	
		    	}
		    	
		    }
		    

		    
		    
		    File fileStList = new File("D:\\КурсоваяТХТ\\"+FunctionsOnFiles.USRNAME+FunctionsOnFiles.SURNAME+FunctionsOnFiles.LOGIN+".txt");
    		try 
    		{
    			PrintWriter printSt = new PrintWriter(fileStList);
    			printSt.print(TestControl.JSONStudListARRAY.toString());
    			printSt.close();
    		} 
    		catch (FileNotFoundException e1) 
    		{
    			e1.printStackTrace();
    		}
		
		
	}
	
	
	
	public static boolean createTest(String que,String ans1,String ans2,String ans3,String ans4){
		
		boolean visible = true;

		String theme = new String();
		String text = new String();
		
		JSONObject TEXT = (JSONObject)MaterialsEdit.JSONThemesListARRAY.get(ThemeFrame.INDEX_ITEM);
		theme=TEXT.get("Theme").toString();
		text=TEXT.get("Text").toString();
		
		if(!que.equals("") && !ans1.equals("") && !ans2.equals("") && !ans3.equals("") && !ans4.equals("") && QUESTION.variants.getSelection()!=null){
			
			
			JSONObject QUESTEdit = new JSONObject();
			
			
			QUESTEdit.put("Theme", theme); 
			QUESTEdit.put("Text", text);
			
			QUESTEdit.put("Question", que); 
			QUESTEdit.put("Answer1", ans1);
			QUESTEdit.put("Answer2", ans2);
			QUESTEdit.put("Answer3", ans3);
			QUESTEdit.put("Answer4", ans4);
			
			
			
			if(QUESTION.radio1.isSelected()) QUESTEdit.put("RightAnswer",ans1);
				
			if(QUESTION.radio2.isSelected()) QUESTEdit.put("RightAnswer",ans2);
				
			if(QUESTION.radio3.isSelected()) QUESTEdit.put("RightAnswer",ans3);
				
			if(QUESTION.radio4.isSelected())	QUESTEdit.put("RightAnswer",ans4);
							
			
			MaterialsEdit.JSONThemesListARRAY.set(ThemeFrame.INDEX_ITEM, QUESTEdit);
			
			
			
			
			
			File fileThemesList = new File("D:\\КурсоваяТХТ\\Material.txt");
			try 
			{
				PrintWriter print = new PrintWriter(fileThemesList);
				print.print(MaterialsEdit.jsonObjThemesList.toString());
				print.close();
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		
			 visible = false;
		
	}
		
	return visible;	
	}
	
	public static int ReadyThemes() throws ParseException{
	
	
		student.USR_TEST(FunctionsOnFiles.USRNAME, FunctionsOnFiles.SURNAME,FunctionsOnFiles.LOGIN);
		
		
		
		int counterReady=0;
    	for(int i=0;i<JSONStudListARRAY.size();i++)
	    {
	   
	    JSONObject STUD=(JSONObject)JSONStudListARRAY.get(i);
	    	
	    if(STUD.get("Mark").toString().equals("READY"))	counterReady++;
	    	 
	    		
	    	
	    	
	    }	
		
	return counterReady;	
		
	}	
	
	
	public static void checkTest() throws ParseException {
		
		
	//USR_TEST();
		
	for(int i=0;i<TestControl.JSONStudListARRAY.size();i++)
    {
		
		JSONObject GET_TEST=(JSONObject)TestControl.JSONStudListARRAY.get(i);	
		if(GET_TEST.get("Mark").toString().equals("READY")){
		 index_test=i;	
		
			
		try {
			TestQuestion TestF;
			TestF =new TestQuestion();
			TestF.setVisible(true);	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
			
		}
		
		
		
    }
	
	
	
	}
	
	
	
	
	
}


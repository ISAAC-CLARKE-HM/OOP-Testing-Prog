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

public class MaterialsEdit {
	public static String massMaterials[];
	public static JSONArray JSONThemesListARRAY;
	public static JSONObject jsonObjThemesList;
	
 public static void ParseMaterial() throws ParseException
 {
	 String bufferNEW = new String();
		
	    try {
	        //Объект для чтения файла в буфер
	    	
	    	FileInputStream fileThemesList = new FileInputStream("D:\\КурсоваяТХТ\\Material.txt");
	    	
	        BufferedReader inThemesListBuf = new BufferedReader(new InputStreamReader(fileThemesList, "Cp1251"));
	        
	        
	        
	        try {
	            //В цикле построчно считываем файл
	            String ss;
	            while ((ss = inThemesListBuf.readLine()) != null) 
	            {
	            	bufferNEW = new String(bufferNEW.concat("\n"));
	                bufferNEW = new String(bufferNEW.concat(ss));
	            }
	           
	        }
	      finally {
	            //Также не забываем закрыть файл
	    	  inThemesListBuf.close();
	           
	        }
	    } catch(IOException e) 
	        {
	        	throw new RuntimeException(e);
	    	}
	    
	    JSONParser parserThemesList = new JSONParser();
	    

	    Object objectParseThemes = parserThemesList.parse(bufferNEW);
	    
	    
	    jsonObjThemesList = (JSONObject) objectParseThemes;
	   
	   

	    JSONThemesListARRAY = (JSONArray) jsonObjThemesList.get("Material");
	   
	     massMaterials = new String[JSONThemesListARRAY.size()];
	    for(int i=0;i<massMaterials.length;i++)
	    {
	    
	    JSONObject objTemp = (JSONObject)JSONThemesListARRAY.get(i);
	    massMaterials[i] = objTemp.get("Theme").toString();

	    }	     	 
	 
 }
 
 public static void addTheme(String THEME, String TEXT) 
 {
	 JSONObject themeAdd = new JSONObject();
		themeAdd.put("Theme",THEME  ); 
		themeAdd.put("Text",TEXT );
		themeAdd.put("Question", ""); 
		themeAdd.put("Answer1", "");
		themeAdd.put("Answer2", "");
		themeAdd.put("Answer3", "");
		themeAdd.put("Answer4", "");
		themeAdd.put("RightAnswer", "");
		
		
		JSONThemesListARRAY.add(themeAdd);
		System.out.print("CREATE");	
		File fileThemesList = new File("D:\\КурсоваяТХТ\\Material.txt");
		try 
		{
			PrintWriter print = new PrintWriter(fileThemesList);
			print.print(jsonObjThemesList.toString());
			print.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}	 
			 
 }
 
 
 public static void deleteTheme(int INDEX)
 {
	 JSONThemesListARRAY.remove(INDEX);
		
		File fileRemove = new File("D:\\КурсоваяТХТ\\Material.txt");
		try 
		{
			PrintWriter pw = new PrintWriter(fileRemove);
			pw.print(jsonObjThemesList.toString());
			pw.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} 	 
	 
 } 

 public static void editTheme(String THEME, String TEX,int INDEX)
 {
	 
	 String question = new String();
		String answer1 = new String();
		String answer2 = new String();
		String answer3 = new String();
		String answer4 = new String();
		String answerR = new String();
		
		JSONObject TEXT = (JSONObject)JSONThemesListARRAY.get(ThemeFrame.INDEX_ITEM);
		question=TEXT.get("Question").toString();
		answer1=TEXT.get("Answer1").toString();
		answer2=TEXT.get("Answer2").toString();
		answer3=TEXT.get("Answer3").toString();
		answer4=TEXT.get("Answer4").toString();
		answerR=TEXT.get("RightAnswer").toString();
		
		
		JSONObject themeEdit = new JSONObject();
		themeEdit.put("Theme", THEME ); 
		themeEdit.put("Text", TEX );
		themeEdit.put("Question",question);
		themeEdit.put("Answer1",answer1);
		themeEdit.put("Answer2",answer2);
		themeEdit.put("Answer3",answer3);
		themeEdit.put("Answer4",answer4);
		themeEdit.put("RightAnswer",answerR);
		JSONThemesListARRAY.set( INDEX , themeEdit);
		
		
		File fileThemesList = new File("D:\\КурсоваяТХТ\\Material.txt");
		try 
		{
			PrintWriter print = new PrintWriter(fileThemesList);
			print.print(jsonObjThemesList.toString());
			print.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
	 
 }
 
 
 public static int checkMaterial(int numberOfTheme) 
	{
		for(int i=0; i< MaterialsEdit.JSONThemesListARRAY.size(); i++)
		{
			
			JSONObject THEME = (JSONObject)MaterialsEdit.JSONThemesListARRAY.get(i);
			//System.out.println(THEME.get("Theme"));
			//System.out.println(THEME.get("Text"));
			
			if(MainMenuFrame.TEACHER==true)
			{
				//THEME1.setEditable(true);
				
			ThemeFrame.panelMain2.add(ThemeFrame.addQuestion);
			ThemeFrame.panelMain2.add(ThemeFrame.buttonCreate);
			ThemeFrame.panelMain2.add(ThemeFrame.buttonDelete);	
			ThemeFrame.panelMain2.add(ThemeFrame.buttonSave);	
			ThemeFrame.panelMain2.add(ThemeFrame.themeHelp);
			ThemeFrame.panelMain2.add(ThemeFrame.textFieldNewTheme);
			}	
			
			else {
				ThemeFrame.includeInTest.setLocation(480,530);
				//panelMain2.add(includeInTest);
				
				ThemeFrame.deleteFromTest.setLocation(710,530);
				//panelMain2.add(deleteFromTest);		
			}
			
			if(numberOfTheme==i)
			{
				
				
				
				ThemeFrame.textFieldNewTheme.setText(THEME.get("Theme").toString());
				ThemeFrame.THEME1.setText(THEME.get("Text").toString());
				ThemeFrame.panelMain2.repaint();
			}
		
			TestControl.MarkCheck();
			 
		}
		
		return 0;

	}
 
 
}

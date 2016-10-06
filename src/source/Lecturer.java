package source;

import javax.swing.JTable;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Lecturer {

	public static void createRateTable() throws ParseException{
		
		
		String[] columnNames = {"Имя","Фамилия", "Группа", "Тестов пройдено"};
		
		Object data[][]= new Object[FunctionsOnFiles.JSONUsersListARRAY.size()-1][];
		
		MaterialsEdit.ParseMaterial();
		
		for(int i=0; i<FunctionsOnFiles.JSONUsersListARRAY.size()-1;i++){
			
			JSONObject studR = (JSONObject) FunctionsOnFiles.JSONUsersListARRAY.get(i+1);
						
			
			String bal =Integer.toString(studR.get("MARKS").hashCode()+studR.get("BADMARKS").hashCode());
			
			bal = new String(bal.concat(" из "+Integer.toString(MaterialsEdit.JSONThemesListARRAY.size())));
			
			String[] fields = {studR.get("Name").toString(),studR.get("Surname").toString(), studR.get("Group").toString(), bal,studR.get("MARKS").toString(),studR.get("BADMARKS").toString(),bal};			
			
			data[i]= fields;			
			
		}
	
		LecturerControl.studentsRate = new JTable(data,columnNames);
		
		
	}
	
	
}

	package source;

	import java.awt.Color;
import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
	import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
	import org.json.simple.parser.ParseException;

	import source.TestFrame.listenerButton;

public class Document  extends JFrame {

	

		private JPanel	DocumentPanel;
		
		private JButton buttonCreatDoc,close;
		private JLabel completeHelp, failHelp,inProcessHelp, timeHelp, studHelp, endHelp, markHelp, docHelp;

		private JTextArea complete,fail,inProcess;
		
		public static int numNotConpl;
		public static int numCompl;
		public static int numFail;
		public 	JSONObject test;

		
		public Document() throws ParseException{
			
			createDocument();
			
			
		}
		
		public void createDocument() throws ParseException{
			
			setLocation(50,0);
			setSize(700,720);
			setTitle(FunctionsOnFiles.SURNAME+" "+FunctionsOnFiles.USRNAME+" "+FunctionsOnFiles.FATHER_NAME+" ("+FunctionsOnFiles.GROUP +") - успеваемость студента");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			
			
			
			MaterialsEdit.ParseMaterial();  

			
			
			test= (JSONObject)MaterialsEdit.JSONThemesListARRAY.get(TestControl.index_test);
			
			
			DocumentPanel = new JPanel();
			DocumentPanel.setLayout(null);
			
			
			
			
			
			
			
		
			endHelp = new JLabel();
			endHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			endHelp.setSize(600,30);
			endHelp.setLocation(10, 455);
			
			studHelp = new JLabel();
			studHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			studHelp.setSize(600,30);
			studHelp.setLocation(10, 425);
			
			
			completeHelp = new JLabel("Пройденые темы:");
			completeHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			completeHelp.setSize(400,30);
			completeHelp.setLocation(10,0);
			DocumentPanel.add(completeHelp);
			
			
			complete = new JTextArea();
			complete.setFont(new Font("Verdana",Font.ITALIC,13));
			//complete.setLocation(10, 40);
			//complete.setSize(680,150);
			//DocumentPanel.add(complete);
			
			JScrollPane scrolCom = new JScrollPane(complete);
			scrolCom.setLocation(10, 40);
			scrolCom.setSize(680,300);
			DocumentPanel.add(scrolCom);
			
			failHelp = new JLabel("Підтеми з незадовільними оцінками:");
			failHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			failHelp.setSize(0,0);
			failHelp.setLocation(10,200);
			DocumentPanel.add(failHelp);
			
			
			
			fail = new JTextArea();
			fail.setFont(new Font("Verdana",Font.ITALIC,13));
			//fail.setLocation(10, 240);
			//fail.setSize(680,150);
			//DocumentPanel.add(fail);
			
			JScrollPane scrolFail = new JScrollPane(fail);
			scrolFail.setLocation(10, 240);
			scrolFail.setSize(0,0);
			DocumentPanel.add(scrolFail);
			
			
			inProcessHelp = new JLabel("Підтеми, по яким ще не було тесту:");
			inProcessHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			inProcessHelp.setSize(0,0);
			inProcessHelp.setLocation(10,400);
			
			
		
			inProcess = new JTextArea();
			inProcess.setFont(new Font("Verdana",Font.ITALIC,13));
			//inProcess.setLocation(10, 440);
			//inProcess.setSize(680,150);
			//
			
			JScrollPane scrolInProc = new JScrollPane(inProcess);
			scrolInProc.setLocation(10, 440);
			scrolInProc.setSize(0,0);
			
			
			
			timeHelp = new JLabel("Час навчання: "+ThemeFrame.Time+" с.");
			timeHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			timeHelp.setSize(0,0);
			timeHelp.setLocation(10,600);
			DocumentPanel.add(timeHelp);
			
			markHelp = new JLabel();
			markHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			markHelp.setSize(400,30);
			
			
			
			close = new JButton("Закрыть");
			close.setFont(new Font("Verdana",Font.ITALIC,12));
			close.setSize(200,30);
			close.setLocation(490, 650);
			DocumentPanel.add(close);
			
			
			buttonCreatDoc = new JButton("Создать документ");
			buttonCreatDoc.setFont(new Font("Verdana",Font.ITALIC,12));
			buttonCreatDoc.setSize(200,30);
			buttonCreatDoc.setLocation(270, 535);
			//DocumentPanel.add(buttonCreateDoc);
			
			
			
			docHelp = new JLabel("Итоговый документ создан!");
			docHelp.setFont(new Font("Verdana",Font.ITALIC,16));
			docHelp.setSize(400,30);
			docHelp.setLocation(10, 535);
			
			
			
			student.USR_TEST(FunctionsOnFiles.USRNAME, FunctionsOnFiles.SURNAME,FunctionsOnFiles.LOGIN);
			
			
			
			complete.setText(TestControl.complete());
			complete.setEditable(false);
			
			
			
			
			fail.setText(TestControl.fail());
			fail.setEditable(false);
			
			
			
			
			inProcess.setText(TestControl.inProc());
			inProcess.setEditable(false);

	if(numNotConpl==0){
			
		timeHelp.setLocation(10,485);
		
		markHelp.setLocation(10, 510);
		
		int sum=numCompl+numFail;
		close.setLocation(490, 535);
			studHelp.setText("Студент: "+""+FunctionsOnFiles.SURNAME+" "+FunctionsOnFiles.USRNAME+" "+FunctionsOnFiles.FATHER_NAME+" ("+FunctionsOnFiles.GROUP +")");
			endHelp.setText("прошел темы курса 'Наследование в С++'");	
			markHelp.setText("Пройдкно тестов: "+numCompl+" из "+ sum);
			setSize(700,620);
			DocumentPanel.add(studHelp);
			DocumentPanel.add(buttonCreatDoc);
			DocumentPanel.add(endHelp);
			DocumentPanel.add(markHelp);		
			
			repaint();
			}
	else {
		DocumentPanel.add(scrolInProc);	
		
		DocumentPanel.add(inProcessHelp);
	}		
	
	
	
	TestControl.printMarks();
			
			ActionListener listenerButo = new listenerButo();
			
			close.addActionListener(listenerButo);
			buttonCreatDoc.addActionListener(listenerButo);
			setContentPane(DocumentPanel);
		}
		
		
		
		
		
		
		public void createTxtDoc(){
			
			String bufferDoc=new String();
			
			
			bufferDoc = new String("Итоговый документ \n\n"+completeHelp.getText()+"\n"+complete.getText()+"\n\n"+studHelp.getText()+"\n"+endHelp.getText()+"\n"+markHelp.getText()+"\n\n");
			
			
			File fileUsersList = new File("D:\\КурсоваяТХТ\\"+FunctionsOnFiles.SURNAME+FunctionsOnFiles.USRNAME+".doc");
			try 
			{
				PrintWriter pw = new PrintWriter(fileUsersList);
				pw.print(bufferDoc);
				pw.close();
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}	
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		public class listenerButo implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
				if(e.getSource() == close )
				{
					
					setVisible(false);
					Main.mainFrame.setVisible(true);
				
				}
				
				
				if(e.getSource() == buttonCreatDoc )
				{
					
					createTxtDoc();
					remove(buttonCreatDoc);
					docHelp.setForeground(Color.GREEN);
					DocumentPanel.add(docHelp);
					repaint();
				}
			
					
				
			}
			
			
			
		}
	

	
	
	
	
	
}

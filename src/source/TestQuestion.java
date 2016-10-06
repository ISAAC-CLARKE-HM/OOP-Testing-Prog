package source;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import source.TestFrame.listenerButton;

public class TestQuestion extends JFrame {

	private JPanel	TestQuestionPanel;
	private JTextField textFieldAnswer;
	private JButton buttonGiveAnswer,buttonContinue;
	private JLabel testCorrectnessHelp, questionHelp,helpLabel;

	private JRadioButton answ1, answ2, answ3, answ4;
	private ButtonGroup variantsA = new ButtonGroup();
	public 	JSONObject test;

	public TestQuestion() throws ParseException{
		
		createTestQuestion();
		
		
	}
	
	public void createTestQuestion() throws ParseException{
		
		setLocation(50,50);
		setSize(700,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);	
		
		MaterialsEdit.ParseMaterial();  

		
		
		test= (JSONObject)MaterialsEdit.JSONThemesListARRAY.get(TestControl.index_test);
		
		setTitle("Тест по теме '"+test.get("Theme").toString()+"'");
		TestQuestionPanel = new JPanel();
		TestQuestionPanel.setLayout(null);
		
		
		
		helpLabel = new JLabel("Укажите, где ошибка");
		helpLabel.setFont(new Font("Verdana",Font.ITALIC,12));
		helpLabel.setSize(680,20);
		helpLabel.setLocation(10,240);
		TestQuestionPanel.add(helpLabel);
		
		
		testCorrectnessHelp = new JLabel();
		testCorrectnessHelp.setFont(new Font("Verdana",Font.ITALIC,12));
		testCorrectnessHelp.setSize(680,20);
		testCorrectnessHelp.setLocation(10,40);
		TestQuestionPanel.add(testCorrectnessHelp);
		
		
		questionHelp = new JLabel(test.get("Question").toString());
		questionHelp.setFont(new Font("Verdana",Font.ITALIC,12));
		questionHelp.setSize(680,200);
		questionHelp.setLocation(10,10);
		TestQuestionPanel.add(questionHelp);
		
		answ1 = new JRadioButton(test.get("Answer1").toString());
		
		answ1.setLocation(10,270);
		answ1.setSize(680,20);
		answ1.setFont(new Font("Verdana", Font.ITALIC,12));
		TestQuestionPanel.add(answ1);
		
		answ2 = new JRadioButton(test.get("Answer2").toString());
		answ2.setLocation(10,300);
		answ2.setSize(680,20);
		answ2.setFont(new Font("Verdana", Font.ITALIC,12));
		TestQuestionPanel.add(answ2);
		
		answ3 = new JRadioButton(test.get("Answer3").toString());
		answ3.setLocation(10,330);
		answ3.setSize(680,20);
		answ3.setFont(new Font("Verdana", Font.ITALIC,12));
		TestQuestionPanel.add(answ3);
		
		answ4 = new JRadioButton(test.get("Answer4").toString());
		answ4.setLocation(10,360);
		answ4.setSize(680,20);
		answ4.setFont(new Font("Verdana", Font.ITALIC,12));
		TestQuestionPanel.add(answ4);
		
		variantsA.add(answ1);
		variantsA.add(answ2);
		variantsA.add(answ3);
		variantsA.add(answ4);
		
		
		testCorrectnessHelp = new JLabel();
		testCorrectnessHelp.setFont(new Font("Verdana",Font.ITALIC,16));
		testCorrectnessHelp.setSize(300,20);
		testCorrectnessHelp.setLocation(10,400);
		TestQuestionPanel.add(testCorrectnessHelp);
		
		
		buttonContinue = new JButton("Закончить");
		buttonContinue.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonContinue.setSize(200,30);
		buttonContinue.setLocation(490, 435);
		
		
		
		buttonGiveAnswer = new JButton("Сохранить ответ");
		buttonGiveAnswer.setFont(new Font("Verdana",Font.ITALIC,12));
		buttonGiveAnswer.setSize(200,30);
		buttonGiveAnswer.setLocation(10, 435);
		TestQuestionPanel.add(buttonGiveAnswer);
		
		
		ActionListener listenerBut = new listenerBut();
		
		buttonContinue.addActionListener(listenerBut);
		buttonGiveAnswer.addActionListener(listenerBut);
		setContentPane(TestQuestionPanel);
	}
	
	
	
	public class listenerBut implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == buttonContinue )
			{
				FunctionsOnFiles.count_themes++;
				
				
				if(FunctionsOnFiles.count_themes==ThemeFrame.countChosenThemes){
					
					System.out.println(ThemeFrame.countChosenThemes);
					Document DocFr;
				try {
					DocFr=new Document();
					DocFr.setVisible(true);	
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				setVisible(false);
			}
			
			if(e.getSource() == buttonGiveAnswer )
			{
				
				String givenAnswer=new String();
				
				if(answ1.isSelected()) givenAnswer=answ1.getLabel();
				
				if(answ2.isSelected()) givenAnswer=answ2.getLabel();
					
				if(answ3.isSelected()) givenAnswer=answ3.getLabel();
					
				if(answ4.isSelected())	givenAnswer=answ4.getLabel();
				
				if(variantsA.getSelection()!=null){
					
				TestQuestionPanel.add(buttonContinue);
				remove(buttonGiveAnswer);
				
			if( givenAnswer.equals(test.get("RightAnswer").toString())){	
				
				
				TestControl.giveMark(test,"COMPL");
				
				
			
			testCorrectnessHelp.setText("Вы ответили правильно!");
			
			
			}
			else	{
			
			
			
			TestControl.giveMark(test,"FAIL");
			///////////////////////////////////////////////
			
		
			testCorrectnessHelp.setText("Ви ответили неправильно!");
			
			
			
			}
			
			
			
			}
			}
				
			
		}
		
		
		
	}
}

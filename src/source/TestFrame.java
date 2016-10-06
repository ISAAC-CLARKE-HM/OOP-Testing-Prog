package source;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class TestFrame extends JFrame {
	
private JPanel	TestPanel;
private JTextField textFieldAnswer;
private JButton buttonBACK,buttonCONFIRM;
private JLabel testConfirmHelp, themesHelp;

private JButton buttonSaveAnswer,buttonFINISH;
private JTextArea themesForTest;
	

public TestFrame() throws ParseException{
	
	createTestFrame();
	
	
}


public void createTestFrame() throws ParseException{
	
	setLocation(50,50);
	setSize(700,500);
	setTitle("Начать тест?");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);	
	
	
	
	
	
	TestPanel = new JPanel();
	TestPanel.setLayout(null);
	
	
	testConfirmHelp = new JLabel("Ви уверенны, что хотите начать тест?");
	testConfirmHelp.setFont(new Font("Verdana",Font.ITALIC,12));
	testConfirmHelp.setSize(400,30);
	testConfirmHelp.setLocation(230, 390);
	TestPanel.add(testConfirmHelp);
	
	
	themesHelp = new JLabel("В тест бдут входить такие темы:");
	themesHelp.setFont(new Font("Verdana",Font.ITALIC,12));
	themesHelp.setSize(400,30);
	themesHelp.setLocation(200,0);
	TestPanel.add(themesHelp);
	
	
	themesForTest = new JTextArea();
	themesForTest.setFont(new Font("Verdana",Font.ITALIC,20));
	themesForTest.setLocation(100, 35);
	themesForTest.setSize(500,350);
	TestPanel.add(themesForTest);

	themesForTest.setEditable(false);
	
	buttonBACK = new JButton("Нет");
	buttonBACK.setFont(new Font("Verdana",Font.ITALIC,12));
	buttonBACK.setSize(100,30);
	buttonBACK.setLocation(500, 415);
	TestPanel.add(buttonBACK);
	
	buttonCONFIRM = new JButton("Да");
	buttonCONFIRM.setFont(new Font("Verdana",Font.ITALIC,12));
	buttonCONFIRM.setSize(100,30);
	buttonCONFIRM.setLocation(100, 415);
	TestPanel.add(buttonCONFIRM);
	
	student.USR_TEST(FunctionsOnFiles.USRNAME, FunctionsOnFiles.SURNAME,FunctionsOnFiles.LOGIN);
	String readyBUF = new String();
	int num=0;
	for(int i=0;i<TestControl.JSONStudListARRAY.size();i++)
    {
		
		JSONObject READY=(JSONObject)TestControl.JSONStudListARRAY.get(i);	
		if(READY.get("Mark").toString().equals("READY")){
			num++;
		readyBUF = new String(readyBUF.concat(num+")"));
		readyBUF = new String(readyBUF.concat(READY.get("Theme").toString())+"\n");
		}
    }
	

	themesForTest.setText(readyBUF);
	
	
	ActionListener listenerButton = new listenerButton();
	buttonCONFIRM.addActionListener(listenerButton);
	buttonBACK.addActionListener(listenerButton);
	setContentPane(TestPanel);

}

public class listenerButton implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == buttonCONFIRM )
		{
			try {
				TestControl.checkTest();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			setVisible(false);
		}
		
		
		if(e.getSource() == buttonBACK )
		{
			setVisible(false);
			
			MainMenuFrame.mainFRAME.setVisible(true);
			
		}
		
		
		
		
		
		
	}
	
	
	
}

}



package net.andy.web.elements;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import net.andy.web.util.LayoutSetMethod;

public class MenuBar extends LayoutSetMethod{
	public JMenuBar menubar;
	
	public MenuBar(final JFrame f){
		menubar = new JMenuBar();
		// �����˵�
		JMenu file = new JMenu("File");
		JMenu tools = new JMenu("Tools");
		file.setMinimumSize(new Dimension(60, 25));
		tools.setMinimumSize(new Dimension(60, 25));
		menubar.add(file);
		menubar.add(tools);
		
		JMenuItem openFile = new JMenuItem("Open...");
		JMenuItem exit = new JMenuItem("exist");
		file.add(openFile);
		file.addSeparator();
		file.add(exit);
		
		JMenuItem createScript = new JMenuItem("Genetate Script");
		tools.add(createScript);
		
		exit.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent Event) 
	          {
	        	    ///���һ���Ի���ϵͳ�������Ҫ�˳�ϵͳ�Ļ������������ʧ
	        		int i=JOptionPane.showConfirmDialog(null,"�Ƿ������Ҫ�˳�ϵͳ","�˳�ȷ�϶Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
	            	if(i==0)
	            	{
	            		f.dispose();
	            	}

	          }
	      });
	}
}

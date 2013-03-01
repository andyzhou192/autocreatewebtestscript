package net.andy.web.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import net.andy.web.tools.GenerateScriptOfJava;

public class ToolBar {
	public JToolBar bar;
	
	public ToolBar(final JFrame f){
		bar = new JToolBar();
		JButton gene = new JButton("Generate Script");
		gene.setMinimumSize(new Dimension(70, 20));
		gene.setToolTipText("add a new check point");
		
		JButton save = new JButton("Save");
		save.setMinimumSize(new Dimension(70, 20));
		save.setToolTipText("save as ...");
		
		JButton exit = new JButton("Exit");
		exit.setMinimumSize(new Dimension(70, 20));
		save.setToolTipText("exit process ...");
		
		bar.add(save, 0);
		bar.add(gene, 1);
		bar.add(exit, 2);
		
		bar.setAutoscrolls(false);
		bar.setBackground(Color.GRAY);
		bar.setFloatable(false);
		
		// �˳��¼�����
		exit.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent Event) 
	          {
	        	    ///���һ���Ի���ϵͳ�������Ҫ�˳�ϵͳ�Ļ������������ʧ
	        		int i = JOptionPane.showConfirmDialog(null,"�Ƿ������Ҫ�˳�ϵͳ","�˳�ȷ�϶Ի���", JOptionPane.YES_NO_CANCEL_OPTION);
	            	if(i==0)
	            	{
	            		f.dispose();
	            	}

	          }
	      });
		
		// ���ɽű��¼�����
		gene.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GenerateScriptOfJava.writeFile();
				JOptionPane.showMessageDialog(null, "��ϲ�㣡�ű��ѳɹ����ɣ���ȥ�����ɣ�", "SUCCESS Tips", JOptionPane.CLOSED_OPTION);
			}
		});
	}

}

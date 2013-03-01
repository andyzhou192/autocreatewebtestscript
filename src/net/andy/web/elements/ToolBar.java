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
		
		// 退出事件处理
		exit.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent Event) 
	          {
	        	    ///设计一个对话框系统，如果需要退出系统的话，则主框架消失
	        		int i = JOptionPane.showConfirmDialog(null,"是否真的需要退出系统","退出确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
	            	if(i==0)
	            	{
	            		f.dispose();
	            	}

	          }
	      });
		
		// 生成脚本事件处理
		gene.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				GenerateScriptOfJava.writeFile();
				JOptionPane.showMessageDialog(null, "恭喜你！脚本已成功生成，快去看看吧！", "SUCCESS Tips", JOptionPane.CLOSED_OPTION);
			}
		});
	}

}

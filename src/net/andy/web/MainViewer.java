package net.andy.web;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.andy.web.elements.BaseInfo;
import net.andy.web.elements.MenuBar;
import net.andy.web.elements.SelectorTabs;
import net.andy.web.elements.ToolBar;
import net.andy.web.util.LayoutSetMethod;

public class MainViewer extends LayoutSetMethod{
	static final int WIDTH = 800;
	static final int HEIGHT = 700;
	static JPanel p;
	
	// 构造函数
	MainViewer() {
		JFrame f = getJFrame( "欢迎使用web页面自动化脚本生成器", WIDTH, HEIGHT, false );
		getViewerPosition( f, WIDTH, HEIGHT );
		f.setLayout( new GridBagLayout() );
		p = new JPanel();
		f.setContentPane( p );
		p.setLayout(new GridBagLayout());
		
		MenuBar mb = new MenuBar(f);
		f.setJMenuBar( mb.menubar );
		
		ToolBar toolBar = new ToolBar(f);
		p.add(toolBar.bar);
		
		GridBagConstraints constraints = getGridBagConstraints( 6, 4 );
	    
		BaseInfo bi = new BaseInfo();
		addToPane( bi.getBaseInfoPane(), constraints, 0, 1, 6, 1, p );
		
		SelectorTabs si = new SelectorTabs();
		addToPane( si.tabbedPane, constraints, 0, 2, 6, 1, p );
		addToPane( si.addMore, constraints, 4, 3, 1, 1, p );
		addToPane( si.delCheck, constraints, 5, 3, 1, 1, p );

		f.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainViewer();
	}

}

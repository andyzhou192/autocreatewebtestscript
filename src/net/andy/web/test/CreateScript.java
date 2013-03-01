package net.andy.web.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateScript extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 900;
	static final int HEIGHT = 700;
	
	JFrame createScriptFrame;
	///按照网格组布局方式排列组件的方法
	///x指控件位于第几列。
	///y指控件位于第几行。
	///w指控件需要占几列。
	///h指控件需要占几行。
	public void add( Component c,GridBagConstraints constraints,int x,int y,int w,int h ){
	    constraints.gridx=x;
	    constraints.gridy=y;
	    constraints.gridwidth=w;
	    constraints.gridheight=h;
	    add(c,constraints);
	} 
	
	/// 这是一个构造器方法
	/// loginframe是就是指这个界面的框架
	/// setDefaultCloseOperation这是一个使得窗口上面的关闭控件有效的类库方法
	/// lay是一个网格组布局管理器的对象。
	/// nameinput是用来输入用户名的文本域。
	/// passwordinput是用来输入密码的文本域。
	/// title是用来显示标题的标签。
	/// name是用来显示“姓名”的标签。
	///password是用来显示“密码”的标签。
	///ok是一个按钮，使进入系统。
	///cancel是一个按钮，使退出界面和系统。
	/// ok.addActionListener是一个进入系统动作事件监听方法。
	///cancel.addActionListener是一个退出系统和界面动作事件的监听方法。
	CreateScript(){
		createScriptFrame = new JFrame("欢迎使用web页面自动化脚本生成器"); 
		createScriptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new GridBagLayout());                        
	    createScriptFrame.add(this, BorderLayout.CENTER);
	    createScriptFrame.setSize(WIDTH,HEIGHT);
	        
	    Toolkit kit=Toolkit.getDefaultToolkit();
	    Dimension screenSize=kit.getScreenSize();
	    int width=screenSize.width;
	    int height=screenSize.height;
	    int x=(width-WIDTH)/2;
	    int y=(height-HEIGHT)/2;
	    createScriptFrame.setLocation(x,y);
	        
	    JLabel scriptName = new JLabel("Script Name：");
	    JLabel scriptDes = new JLabel("Script Desc：");
	    JLabel scriptAuthor = new JLabel("Author：");
	    
	    // checkPoint
	    JLabel selector = new JLabel("Selector：");
	    JLabel selectorAlias = new JLabel("Selector Alias：");
	    JLabel checkType = new JLabel("Check Type：");
	    JButton browse = new JButton("Browse...");
	    browse.setBorder(BorderFactory.createRaisedBevelBorder());
	    
	    JButton addMore = new JButton("Add Check Point");
	    addMore.setToolTipText("add a new check point");
	    addMore.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    
	    JButton create = new JButton("Create Script");
	    JButton cancel = new JButton("Cancel");
	    
	    final JTextField scriptNameInput = new JTextField( 50 );
	    final JTextArea scriptDesInput = new JTextArea( "Please input Script Description...", 4, 50 );
	    final JTextField scriptAuthorInput = new JTextField( 50 );
	    
	    final JTextField selectorInput = new JTextField( 50 );
	    final JTextField selectorAliasInput = new JTextField( 50 );
	    final JComboBox checkTypeList = new JComboBox();
	    checkTypeList.addItem("Check Text");
	    checkTypeList.addItem("Check Link");
	    checkTypeList.addItem("Check Image");
	        
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.fill = GridBagConstraints.NONE;
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 4;
	    constraints.weighty = 11;
	        
	    add( scriptName, constraints, 0, 0, 1, 1 );                 //使用网格组布局添加控件
	    add( scriptNameInput, constraints, 1, 0, 3, 1 );
	    
	    add( scriptDes, constraints, 0, 1, 1, 1 );
	    add( scriptDesInput, constraints, 1, 1, 3, 4 );
	    
	    add( scriptAuthor, constraints, 0, 5, 1, 1 );
	    add( scriptAuthorInput, constraints, 1, 5, 3, 1 );
	    
	    add( selector, constraints, 0, 6, 1, 1 );
	    add( selectorInput, constraints, 1, 6, 2, 1 );
	    add( browse, constraints, 3, 6, 1, 1 );
	    
	    add( selectorAlias, constraints, 0, 7, 1, 1 );
	    add( selectorAliasInput, constraints, 1, 7, 3, 1 );
	    
	    add( checkType, constraints, 0, 8, 1, 1 );
	    add( checkTypeList, constraints, 1, 8, 3, 1 );
	    
	    add( addMore, constraints, 3, 9, 1, 1 );
	    
	    add( create, constraints, 1, 10, 1, 1 );
	    add( cancel, constraints, 3, 10, 1, 1 );
	    
	    createScriptFrame.setResizable( true );
	    createScriptFrame.setVisible( true );  
	        
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CreateScript();

	}

}

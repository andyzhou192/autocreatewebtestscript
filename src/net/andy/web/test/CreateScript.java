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
	///���������鲼�ַ�ʽ��������ķ���
	///xָ�ؼ�λ�ڵڼ��С�
	///yָ�ؼ�λ�ڵڼ��С�
	///wָ�ؼ���Ҫռ���С�
	///hָ�ؼ���Ҫռ���С�
	public void add( Component c,GridBagConstraints constraints,int x,int y,int w,int h ){
	    constraints.gridx=x;
	    constraints.gridy=y;
	    constraints.gridwidth=w;
	    constraints.gridheight=h;
	    add(c,constraints);
	} 
	
	/// ����һ������������
	/// loginframe�Ǿ���ָ�������Ŀ��
	/// setDefaultCloseOperation����һ��ʹ�ô�������Ĺرտؼ���Ч����ⷽ��
	/// lay��һ�������鲼�ֹ������Ķ���
	/// nameinput�����������û������ı���
	/// passwordinput����������������ı���
	/// title��������ʾ����ı�ǩ��
	/// name��������ʾ���������ı�ǩ��
	///password��������ʾ�����롱�ı�ǩ��
	///ok��һ����ť��ʹ����ϵͳ��
	///cancel��һ����ť��ʹ�˳������ϵͳ��
	/// ok.addActionListener��һ������ϵͳ�����¼�����������
	///cancel.addActionListener��һ���˳�ϵͳ�ͽ��涯���¼��ļ���������
	CreateScript(){
		createScriptFrame = new JFrame("��ӭʹ��webҳ���Զ����ű�������"); 
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
	        
	    JLabel scriptName = new JLabel("Script Name��");
	    JLabel scriptDes = new JLabel("Script Desc��");
	    JLabel scriptAuthor = new JLabel("Author��");
	    
	    // checkPoint
	    JLabel selector = new JLabel("Selector��");
	    JLabel selectorAlias = new JLabel("Selector Alias��");
	    JLabel checkType = new JLabel("Check Type��");
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
	        
	    add( scriptName, constraints, 0, 0, 1, 1 );                 //ʹ�������鲼����ӿؼ�
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

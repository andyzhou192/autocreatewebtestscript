package net.andy.web.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.andy.web.util.LayoutSetMethod;

public class BaseInfo extends LayoutSetMethod{
	public JPanel baseInfo;

	private JLabel packageName = new JLabel();
	private JLabel className = new JLabel();
	private JLabel scriptName = new JLabel();
	private JLabel scriptDesc = new JLabel();
	private JLabel scriptAuth = new JLabel();
	
	public static JTextField packageNameInput = new JTextField();
	public static JTextField scriptAuthInput = new JTextField();
	public static JTextArea scriptDescInput = new JTextArea();
	public static JTextField scriptNameInput = new JTextField();
	public static JTextField classNameInput = new JTextField();

	// 获取基础信息
	public JPanel getBaseInfoPane(){
		baseInfo = new JPanel();
		baseInfo.setLayout(new GridBagLayout());
		
		packageName.setText("Packae：");
		packageName.setHorizontalTextPosition(SwingConstants.RIGHT);
		packageNameInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
		packageNameInput.setMinimumSize(new Dimension(500,25));
		packageNameInput.setColumns(50);
		
		className.setText("Class Name：");
		className.setHorizontalTextPosition(SwingConstants.RIGHT);
		classNameInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
		classNameInput.setMinimumSize(new Dimension(500,25));
		
		scriptName.setText("Script Name：");
		scriptName.setHorizontalTextPosition(SwingConstants.RIGHT);
		scriptNameInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
		scriptNameInput.setMinimumSize(new Dimension(500,25));
		
		scriptDesc.setText("Script Desc：");
		scriptDesc.setHorizontalTextPosition(SwingConstants.RIGHT);
		scriptDesc.setVerticalTextPosition(SwingConstants.TOP);
		scriptDescInput.setMinimumSize(new Dimension(500,100));
		scriptDescInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
		scriptDescInput.setWrapStyleWord(true);
		
		scriptAuth.setText("Script Author：");
		scriptAuth.setHorizontalTextPosition(SwingConstants.RIGHT);
		scriptAuthInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
		scriptAuthInput.setMinimumSize(new Dimension(500,25));
		
		packageName.setFont(new java.awt.Font("Default", Font.BOLD, 12));
		className.setFont(new java.awt.Font("Default", Font.BOLD, 12));
		scriptName.setFont(new java.awt.Font("Default", Font.BOLD, 12));
		scriptDesc.setFont(new java.awt.Font("Default", Font.BOLD, 12));
		scriptAuth.setFont(new java.awt.Font("Default", Font.BOLD, 12));
		
		GridBagConstraints constraints = getGridBagConstraints( 6, 8 );
		constraints.anchor = GridBagConstraints.WEST;
		
		addToPane( packageName, constraints, 0, 0, 1, 1, baseInfo );
		addToPane( packageNameInput,  constraints, 1, 0, 5, 1, baseInfo );
		
		addToPane( className, constraints, 0, 1, 1, 1, baseInfo );
		addToPane( classNameInput,  constraints, 1, 1, 5, 1, baseInfo );
		
		addToPane( scriptName, constraints, 0, 2, 1, 1, baseInfo );
		addToPane( scriptNameInput,  constraints, 1, 2, 5, 1, baseInfo );
		
		addToPane( scriptDesc, constraints, 0, 3, 1, 1, baseInfo );
		addToPane( scriptDescInput,   constraints, 1, 3, 5, 4, baseInfo );
		
		addToPane( scriptAuth, constraints, 0, 7, 1, 1, baseInfo );
		addToPane( scriptAuthInput,  constraints, 1, 7, 5, 1, baseInfo );
		baseInfo.setVisible(true);
		
		return baseInfo;
	}
	
}

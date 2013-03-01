package net.andy.web.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.andy.web.util.LayoutSetMethod;

public class SelectorInfo extends LayoutSetMethod{
	public JPanel selectorInfo;
	
	public JTextField pageURLInput;
	public JTextField selectorInput;
	public JTextField selectorAliasInput;
	public JTextField introduceInput;
	public JComboBox checkTypeList;
	
	public SelectorInfo(){
		selectorInfo = new JPanel();
		selectorInfo.setLayout(new GridBagLayout());
		// checkPoint
		JLabel pageURL = new JLabel("Page URL£º");
	    JLabel selector = new JLabel("Selector Info£º");
	    JLabel selectorAlias = new JLabel("Selector Alias£º");
	    JLabel introduce = new JLabel("Introduce£º");
	    JLabel checkType = new JLabel("Check Type£º");
	    JButton browse = new JButton("Browse...");
	    browse.setMinimumSize(new Dimension(60,25));
	    browse.setBorder(BorderFactory.createRaisedBevelBorder());
	    
	    final JTextField pageURLInput = new JTextField( 50 );
	    pageURLInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
	    pageURLInput.setMinimumSize(new Dimension(500,25));
	    
	    final JTextField selectorInput = new JTextField( 50 );
	    selectorInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
	    selectorInput.setMinimumSize(new Dimension(500,25));
	    
	    final JTextField selectorAliasInput = new JTextField( 50 );
	    selectorAliasInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
	    selectorAliasInput.setMinimumSize(new Dimension(500,25));
	    
	    final JTextField introduceInput = new JTextField( 50 );
	    introduceInput.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
	    introduceInput.setMinimumSize(new Dimension(500,25));
	    
	    final JComboBox checkTypeList = new JComboBox();
	    checkTypeList.setMinimumSize(new Dimension(100,25));
	    checkTypeList.addItem("Check Text");
	    checkTypeList.addItem("Check Link");
	    checkTypeList.addItem("Check Image");
	    checkTypeList.setSelectedIndex(0);
	    
	    pageURL.setFont(new java.awt.Font("Default", Font.BOLD, 12));
	    selector.setFont(new java.awt.Font("Default", Font.BOLD, 12));
	    selectorAlias.setFont(new java.awt.Font("Default", Font.BOLD, 12));
	    checkType.setFont(new java.awt.Font("Default", Font.BOLD, 12));
	    introduce.setFont(new java.awt.Font("Default", Font.BOLD, 12));
	    
	    GridBagConstraints constraints = getGridBagConstraints( 6, 6 );
	    
	    addToPane( pageURL,       constraints, 0, 0, 1, 1, selectorInfo );
	    addToPane( pageURLInput,  constraints, 1, 0, 5, 1, selectorInfo );
	    
	    addToPane( selector,      constraints, 0, 1, 1, 1, selectorInfo );
	    addToPane( selectorInput, constraints, 1, 1, 4, 1, selectorInfo );
	    addToPane( browse,        constraints, 5, 1, 1, 1, selectorInfo );
	    
		addToPane( selectorAlias,      constraints, 0, 2, 1, 1, selectorInfo );
		addToPane( selectorAliasInput, constraints, 1, 2, 2, 1, selectorInfo );
		
		addToPane( checkType,     constraints, 0, 3, 1, 1, selectorInfo );
		addToPane( checkTypeList, constraints, 1, 3, 2, 1, selectorInfo );
		
		addToPane( introduce,      constraints, 0, 4, 1, 1, selectorInfo );
		addToPane( introduceInput, constraints, 1, 4, 2, 1, selectorInfo );
		
		selectorInfo.setVisible(true);
	}

}

package net.andy.web.elements;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import net.andy.web.util.LayoutSetMethod;

public class AddAndRemoveCheck extends LayoutSetMethod {
	public JButton addCheck;
	public JButton removeCheck;

	public AddAndRemoveCheck() {
		addCheck = new JButton("Add Check");
		addCheck.setMinimumSize(new Dimension(60, 20));
		addCheck.setToolTipText("add a new check point");
		addCheck.setBorder(BorderFactory.createCompoundBorder());
		addCheck.setVisible(true);
		
		removeCheck = new JButton("Del Check");
		removeCheck.setMinimumSize(new Dimension(60, 20));
		removeCheck.setToolTipText("remove the last check point");
		removeCheck.setBorder(BorderFactory.createCompoundBorder());
		removeCheck.setVisible(true);
	}
}

package net.andy.web.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 涉及到跨面板的 控件调用, 通过写方法,外部程序也可以调用,
 * A simple example that demontrates my (almost complete) lack of understanding
 * of the question. ;-)
 */
public class t extends JFrame implements ActionListener {
	/* The tabbed pane at the heart of it. */
	JTabbedPane jtp;
	/** Content panel of the tabbed pane */
	JPanel page1, page2, page3;
	/** Button to control UI */
	JButton b1, b2;
	/** Counter for the labels */
	int count;
	private JButton b22;

	/** A tabbed pane with three content tabs. */
	t() {
		super("Flip Tabs");
		jtp = new JTabbedPane();
		add(jtp);
		page1 = new JPanel();
		b1 = new JButton("Button 1");
		b1.addActionListener(this);
		page1.add(b1);
		jtp.add(page1, "page1");
		page2 = new JPanel();
		b22 = new JButton("Button 222");
		page2.add(b22);
		jtp.add(page2, "page2");
		page3 = new JPanel();
		jtp.add(page3, "page3");
		add(jtp);
		pack();
		setSize(getPreferredSize());
		count = 0;
	}

	/**
	 * On button one, make and flip to button 2. On button two, add another
	 * label to tabbed pane 3.
	 */
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		System.out.println(((JButton) o).getText());
		if (o == b1) {
			if (b2 == null) {
				b2 = new JButton("Button 2");
				b22.setText("chensss");
				b2.addActionListener(this);
				page2.add(b2);
				jtp.setSelectedComponent(b2.getParent());
				for (int i = 0; i < 5; i++) {
					JButton a = (JButton) page2.getComponent(i);
					System.out.println("sss" + a.getText());//
				}
			}
		} else { // must be b2
			JLabel l1 = new JLabel("Heyoo! .." + ++count);
			page3.add(l1);
			jtp.setSelectedComponent(l1.getParent());
		}
		validate();
	}

	/** Gimme' it. Now! */
	public static void main(String[] args) {
		t f = new t();
		f.setVisible(true);
	}
}

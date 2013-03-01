package net.andy.web.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * 新建和关闭tab
 * @author guy
 * @company yesoft
 * @date 2009-1-16
 */
public class TabbedPanelShutTry implements ActionListener {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JButton addTabButton;
	private ImageIcon closexIcon;
	private Dimension closeButtonSize;
	private int tabCounter = 0;

	public TabbedPanelShutTry() {
		tabbedPane = new JTabbedPane();
		addTabButton = new JButton("add tab");
		addTabButton.addActionListener(this);

		frame = new JFrame();
		closexIcon = new ImageIcon("c:/shut.jpg");
		closeButtonSize = new Dimension(closexIcon.getIconWidth() + 2,
				closexIcon.getIconHeight() + 2);
		frame.add(tabbedPane, BorderLayout.CENTER);
		frame.add(addTabButton, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		final JPanel content = new JPanel();
		JPanel tab = new JPanel();
		tab.setOpaque(false);

		JLabel tablabel = new JLabel("tab" + (++tabCounter));
		JButton tabCloseButton = new JButton(closexIcon);

		tabCloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int closerTabNumber = tabbedPane.indexOfComponent(content);
				System.out.println(closerTabNumber);
				tabbedPane.removeTabAt(closerTabNumber);
			}
		});

		tab.add(tablabel, BorderLayout.WEST);
		tab.add(tabCloseButton, BorderLayout.EAST);

		tabbedPane.addTab(null, content);
		tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tab);
	}

	public static void main(String[] args) {
		TabbedPanelShutTry main = new TabbedPanelShutTry();
	}
}

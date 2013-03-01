package net.andy.web.elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.andy.web.util.ButtonTabComponent;

public class SelectorTabs implements ActionListener {

	private int newNumber = 2;
	public JTabbedPane tabbedPane;
	public JButton addMore;
	public JButton delCheck;

	public SelectorTabs() {
		SelectorInfo si = new SelectorInfo();
		JPanel panel = si.selectorInfo;

		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);// 设置标签置放位置。
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab("Selector-1", panel);

		AddAndRemoveCheck ac = new AddAndRemoveCheck();
		addMore = ac.addCheck;
		addMore.addActionListener(this);

		delCheck = ac.removeCheck;
		delCheck.addActionListener(this);
	}

	/*
	 * 实现ActionListener接口,当用户按下"新增标签"按钮时，就会在tabbedPane上新增一个Disable状态的标签。
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command == "Add Check" && newNumber < 15) {
			SelectorInfo si = new SelectorInfo();
			JPanel pane1 = si.selectorInfo;
			tabbedPane.addTab("Selector-" + newNumber, pane1);
			tabbedPane.setEnabledAt(newNumber, true);
			tabbedPane.setSelectedIndex(newNumber);
			// 给标签添加关闭按钮
			newNumber++;
			for ( int i = 1; i < newNumber; i++){
				tabbedPane.setTabComponentAt(i, new ButtonTabComponent(tabbedPane));
			}
			tabbedPane.validate();
		} else if (command == "Del Check" && newNumber > 1) {
			newNumber--;
			tabbedPane.removeTabAt(newNumber);
		} else {
			JOptionPane.showMessageDialog(null, "操作错误，选择器tab只剩1个或超过了15个！", "ERROR Tips", JOptionPane.CLOSED_OPTION);
		}
	}
}

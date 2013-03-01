package net.andy.web.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutSetMethod {
	/**
	 * 获取网格限制
	 * @param crossCols 列数
	 * @param crossRows 行数
	 * @return
	 */
	public static GridBagConstraints getGridBagConstraints(int cols, int rows){
		GridBagConstraints constraints = new GridBagConstraints();
	    constraints.fill = GridBagConstraints.NONE; // 如果显示区域比组件的区域大的时候，可以用来控制组件的行为。控制组件是垂直填充，还是水平填充，或者两个方向一起填充
	    constraints.anchor = GridBagConstraints.WEST;  // 告诉布局管理器组件在表格空间中的位置
	    constraints.weightx = cols;  // 指行的权重，告诉布局管理器如何分配额外的水平空间
	    constraints.weighty = rows;  // 指列的权重，告诉布局管理器如何分配额外的垂直空间
	    constraints.ipadx = 2;  // 组件间的横向间距,组件的宽度就是这个组件的最小宽度加上ipadx值
	    constraints.ipady = 1;  // 组件间的纵向间距,组件的高度就是这个组件的最小高度加上ipady值
	    constraints.insets = new Insets( 10, 14, 10, 14 );  // 指组件与表格空间四周边缘的空白区域的大小
	    return constraints;
	}
	
	/** 
	 * 按照网格组布局方式排列组件的方法
	 * @param c
	 * @param constraints
	 * @param x 指控件位于第几列
	 * @param y 指控件位于第几行
	 * @param w 指控件需要占几列
	 * @param h 指控件需要占几行
	 */
	public static void addToPane( Component c,GridBagConstraints constraints,int x,int y,int w,int h, JPanel pane ){
	    constraints.gridx = x;  // 组件的横向坐标
	    constraints.gridy = y;  // 组件的纵向坐标
	    constraints.gridwidth = w;  // 组件的横向宽度，也就是指组件占用的列数，这与HTML的colspan类似
	    constraints.gridheight = h; // 组件的纵向长度，也就是指组件占用的行数，这与HTML的rowspan类似
	    pane.add( c, constraints );
	} 
	
	/**
	 * 设置工具试图刚打开时展示在屏幕中的中间位置
	 * @param jf
	 * @param wid
	 * @param heig
	 */
	public void getViewerPosition( JFrame jf, int wid, int heig ){
		Toolkit kit=Toolkit.getDefaultToolkit();
	    Dimension screenSize=kit.getScreenSize();
	    int width=screenSize.width;
	    int height=screenSize.height;
	    int x=(width-wid)/2;
	    int y=(height-heig)/2;
	    jf.setLocation(x,y);
	}
	
	/**
	 * 创建JFrame
	 * @param title
	 * @param width
	 * @param height
	 * @param resizable
	 * @return
	 */
	public JFrame getJFrame( String title, int width, int height, Boolean resizable ){
		JFrame jf = new JFrame( title );
		jf.setSize( width, height );
		jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		jf.setVisible( true );
		jf.setResizable( resizable );
		return jf;
	}

}

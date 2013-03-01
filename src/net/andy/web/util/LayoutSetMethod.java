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
	 * ��ȡ��������
	 * @param crossCols ����
	 * @param crossRows ����
	 * @return
	 */
	public static GridBagConstraints getGridBagConstraints(int cols, int rows){
		GridBagConstraints constraints = new GridBagConstraints();
	    constraints.fill = GridBagConstraints.NONE; // �����ʾ����������������ʱ�򣬿������������������Ϊ����������Ǵ�ֱ��䣬����ˮƽ��䣬������������һ�����
	    constraints.anchor = GridBagConstraints.WEST;  // ���߲��ֹ���������ڱ��ռ��е�λ��
	    constraints.weightx = cols;  // ָ�е�Ȩ�أ����߲��ֹ�������η�������ˮƽ�ռ�
	    constraints.weighty = rows;  // ָ�е�Ȩ�أ����߲��ֹ�������η������Ĵ�ֱ�ռ�
	    constraints.ipadx = 2;  // �����ĺ�����,����Ŀ�Ⱦ�������������С��ȼ���ipadxֵ
	    constraints.ipady = 1;  // ������������,����ĸ߶Ⱦ�������������С�߶ȼ���ipadyֵ
	    constraints.insets = new Insets( 10, 14, 10, 14 );  // ָ�������ռ����ܱ�Ե�Ŀհ�����Ĵ�С
	    return constraints;
	}
	
	/** 
	 * ���������鲼�ַ�ʽ��������ķ���
	 * @param c
	 * @param constraints
	 * @param x ָ�ؼ�λ�ڵڼ���
	 * @param y ָ�ؼ�λ�ڵڼ���
	 * @param w ָ�ؼ���Ҫռ����
	 * @param h ָ�ؼ���Ҫռ����
	 */
	public static void addToPane( Component c,GridBagConstraints constraints,int x,int y,int w,int h, JPanel pane ){
	    constraints.gridx = x;  // ����ĺ�������
	    constraints.gridy = y;  // �������������
	    constraints.gridwidth = w;  // ����ĺ����ȣ�Ҳ����ָ���ռ�õ�����������HTML��colspan����
	    constraints.gridheight = h; // ��������򳤶ȣ�Ҳ����ָ���ռ�õ�����������HTML��rowspan����
	    pane.add( c, constraints );
	} 
	
	/**
	 * ���ù�����ͼ�մ�ʱչʾ����Ļ�е��м�λ��
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
	 * ����JFrame
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

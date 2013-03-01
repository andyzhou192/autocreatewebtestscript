package net.andy.web.test.changetab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.net.URL;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
 
//http://blog.sina.com.cn/s/blog_616e189f0100niep.html
@SuppressWarnings("serial")
public class TabbedPaneDemo extends JPanel {
 
    public TabbedPaneDemo()
    {
       //���ò��ֹ�������Ĭ�ϵĲ��ֹ������� BorderLayout,����û��ô����
       //ѡ��GridLayout(1,1)���ɣ���������Ϊһ��     
       super(new GridLayout(1,1));
      
       //����JTabbedPane
       JTabbedPane tp = new JTabbedPane();
       //������ǩ��ʾ��ͼ��
       ImageIcon ii = createImageIcon("images/middle.gif");   
      
      
      
       //������һ����ǩ�µ�panel
       JPanel panel0 = createPanel("panel0");
       //ָ����ǩ������ǩͼ�꣬panel������ʾ��Ϣ
       tp.addTab("panel0",ii,panel0,"do noting");
       //���ñ�ǩ�Ŀ�ݼ�
       tp.setMnemonicAt(0, KeyEvent.VK_0);
      
      
       //�ڶ�����ǩ
       JPanel panel1 = createPanel("panel1");
       tp.addTab("panel1",ii,panel1,"do noting");
       tp.setMnemonicAt(1, KeyEvent.VK_1);
 
       //��������ǩ
       JPanel panel2 = createPanel("panel2");
       tp.addTab("panel2",ii,panel2,"do noting");
       tp.setMnemonicAt(2, KeyEvent.VK_2);
 
       //���ĸ���ǩ
       JPanel panel3 = createPanel("panel3");
       tp.addTab("panel3",ii,panel3,"do noting");
       tp.setMnemonicAt(3, KeyEvent.VK_3);
       //���ú��ʵ���ʾ�ߴ磬����Ǳ���ģ���Ϊ������еı�ǩ��
       //��ָ���ʺϵ���ʾ�ߴ磬ϵͳ�޷��жϳ�ʼ��ʾ�ߴ��С
       //Ĭ����ʹ����С�������Ҷ�һ����ǩ��Ƽ���
       tp.setPreferredSize(new Dimension(500,500));
 
       //��tabbedPanel��ӵ�Jpanel��
       add(tp);
      
       //���ô��ڹ�Сʱ����ǩ����ʾ����
       tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
       //���ñ�ǩͣ�ŵ�λ�ã���������Ϊ���ͣ��
       tp.setTabPlacement(JTabbedPane.LEFT);
      
    }
   
   
   
    private JPanel createPanel(String string) {
       //����һ��JPanel����Ϊ���캯����ʼfalse
       //��ʾ������˫����
       JPanel panel = new JPanel(false);
      
       //���ò���
       panel.setLayout(new GridLayout(1,1));
      
       //����һ��label�ŵ�panel��
       JLabel filler = new JLabel(string);
       filler.setHorizontalAlignment(JLabel.CENTER);
       panel.add(filler);
       return panel;
    }
 
 
 
    private ImageIcon createImageIcon(String string) {
       URL url = TabbedPaneDemo.class.getResource(string);
       if(url == null)
       {
           System.out.println("the image "+string+" is not exist!");
           return null;
       }
       return new ImageIcon(url);
    }
 
 
 
    public static void createAndShowGUI()
    {
       JFrame frame = new JFrame("table panel test");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       frame.add(new TabbedPaneDemo());
      
       frame.pack();
       frame.setVisible(true);
      
      
    }
   
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
          
           @Override
           public void run() {
              createAndShowGUI();
           }
       });
    }
}

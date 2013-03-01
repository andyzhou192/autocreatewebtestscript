package net.andy.web.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// 用java做出选项卡，然后再个选项卡下添加各种组
public class BoxAlignmentDemo extends JPanel {
    public BoxAlignmentDemo() {
        super(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■做出选项卡■■■■■■■■■■■■■■■■■■■■■■■■■■■

        JPanel buttonRow = new JPanel();
        // Use default FlowLayout.
        buttonRow.add(createButtonRow(false));
        buttonRow.add(createButtonRow(true));
        tabbedPane.addTab("Altering alignments", buttonRow);//■■■■■■■■■■■■■■■■■■■■■■■选项卡上添加组件■■■■■■■■■■■■■■■■■■■■■■

        JPanel labelAndComponent = new JPanel();
        // Use default FlowLayout.
        labelAndComponent.add(createLabelAndComponent(false));
        labelAndComponent.add(createLabelAndComponent(true));
        tabbedPane.addTab("X alignment mismatch", labelAndComponent);//■■■■■■■■■■■■■■■■■■选项卡上添加组件■■■■■■■■■■■■■■■■■■

        JPanel buttonAndComponent = new JPanel();
        // Use default FlowLayout.
        buttonAndComponent.add(createYAlignmentExample(false));
        buttonAndComponent.add(createYAlignmentExample(true));
        tabbedPane.addTab("Y alignment mismatch", buttonAndComponent);//■■■■■■■■■■■■■■■■■■选项卡上添加组件■■■■■■■■■■■■■■■■■

        // Add tabbedPane to this panel.
        add(tabbedPane, BorderLayout.CENTER);
    }

    protected JPanel createButtonRow(boolean changeAlignment) {
        String prefix = System.getProperty("user.dir") + File.separator;
        String pathPrefix = System.getProperty("user.dir");
        String path1 = pathPrefix + "\\images\\geek-cght.gif";
        String path2 = pathPrefix + "\\images\\middle.gif";
        // System.out.println(File.separator);
        // System.out.println("尼玛手工输入的"+"\\");
        Image img_1 = Toolkit.getDefaultToolkit().getImage(path1);
        ImageIcon img1 = new ImageIcon(img_1);
        Image img_2 = Toolkit.getDefaultToolkit().getImage(path2);
        ImageIcon img2 = new ImageIcon(img_2);
        JButton button1 = new JButton("A JButton", img2);
        button1.setVerticalTextPosition(AbstractButton.BOTTOM);
        button1.setHorizontalTextPosition(AbstractButton.CENTER);

        // JButton button2 = new JButton("Another JButton",
        // createImageIcon("E:\\Users\\hp\\ee_TDDOWNLOAD\\workspace1\\CS_SE\\images\\geek-cght.gif"));
        JButton button2 = new JButton("Another JButton", img1);
        button2.setVerticalTextPosition(AbstractButton.BOTTOM);
        button2.setHorizontalTextPosition(AbstractButton.CENTER);

        String title;
        if (changeAlignment) {
            title = "Desired";
            button1.setAlignmentY(BOTTOM_ALIGNMENT);// JComponent setAlignmentY
            button2.setAlignmentY(BOTTOM_ALIGNMENT);
        } else {
            title = "Default";
        }

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createTitledBorder(title));
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        pane.add(button1);
        pane.add(button2);
        return pane;
    }

    protected JPanel createLabelAndComponent(boolean doItRight) {
        JPanel pane = new JPanel();

        JComponent component = new JPanel();
        Dimension size = new Dimension(150, 100);
        component.setMaximumSize(size);
        component.setPreferredSize(size);
        component.setMinimumSize(size);
        TitledBorder border = new TitledBorder(new LineBorder(Color.black),
                "A JPanel", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component.setBorder(border);

        JLabel label = new JLabel("This is a JLabel");
        String title;
        if (doItRight) {
            title = "Matched";
            label.setAlignmentX(CENTER_ALIGNMENT);
        } else {
            title = "Mismatched";
        }

        pane.setBorder(BorderFactory.createTitledBorder(title));
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(label);
        pane.add(component);
        return pane;
    }

    protected JPanel createYAlignmentExample(boolean doItRight) {
        JPanel pane = new JPanel();
        String title;

        JComponent component1 = new JPanel();
        Dimension size = new Dimension(100, 50);
        component1.setMaximumSize(size);
        component1.setPreferredSize(size);
        component1.setMinimumSize(size);
        TitledBorder border = new TitledBorder(new LineBorder(Color.black),
                "A JPanel", TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component1.setBorder(border);

        JComponent component2 = new JPanel();
        size = new Dimension(100, 50);
        component2.setMaximumSize(size);
        component2.setPreferredSize(size);
        component2.setMinimumSize(size);
        border = new TitledBorder(new LineBorder(Color.black), "A JPanel",
                TitledBorder.CENTER, TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        component2.setBorder(border);

        if (doItRight) {
            title = "Matched";
        } else {
            component1.setAlignmentY(TOP_ALIGNMENT);//顶部对其
            title = "Mismatched";
        }

        pane.setBorder(BorderFactory.createTitledBorder(title));
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        pane.add(component1);
        pane.add(component2);
        return pane;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = BoxAlignmentDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("BoxAlignmentDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        BoxAlignmentDemo newContentPane = new BoxAlignmentDemo();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

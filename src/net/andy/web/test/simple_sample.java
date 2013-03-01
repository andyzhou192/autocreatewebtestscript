package net.andy.web.test;

import java.awt.Graphics;
import java.awt.Color;

public class simple_sample extends java.applet.Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color line_color = Color.black;
	String color_description = "hello";
	private int i = 1;

	public void start_2_change() {
		if (i % 2 == 0) {
			line_color = Color.yellow;
			color_description = "The current color is Yellow!";
		} else {
			line_color = Color.green;
			color_description = "The current color is Green!";
		}
		i++;
		repaint();
	}

	public void paint(Graphics g) {
		g.drawString(color_description, 10, 10);
		g.setColor(line_color);
		g.drawOval(30, 20, 79, 79);
	}
}

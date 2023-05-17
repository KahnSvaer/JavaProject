package main;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private JFrame jframe;
	public Frame(Panel panel) {
		jframe = new JFrame("Music");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.add(panel);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		
		jframe.setVisible(true);
	}

}

package dev.MRobinBatman.TileGame.display;

import java.awt.Canvas;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.text.*;
public class Display {
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}

	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // <- [IMPORANT] SETS WINDOW TO THE CENTER OF THE SCREEN
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false); // JFrame is the only thing that can have focus /// not sure but was recommended
		
		frame.add(canvas);
		frame.pack();
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}


}

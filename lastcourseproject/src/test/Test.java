package test;

import javax.swing.UIManager;

import view.QLHSView;


public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			new QLHSView();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

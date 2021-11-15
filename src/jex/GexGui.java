package jex;

import java.awt.EventQueue;

import org.omg.CORBA.Environment;

public class GexGui {
	GexGui() {
		
		frame = new JexWindowFrame();
		frame.setVisible(true);
	}

	public void refresh() {
		frame.refresh();

	}

	private JexWindowFrame frame;

}

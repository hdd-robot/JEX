package jex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.omg.CORBA.Environment;

public class JexDrawSurface extends JPanel {

	JexDrawSurface() {
		super();

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(10, 20, 780, 370);

		dimWidth = JexEnvironnement2D.getMaxPatchX();
		dimHeight = JexEnvironnement2D.getMaxPatchY();
		pSizeX = JexEnvironnement2D.getPatchSizeX();
		pSizeY = JexEnvironnement2D.getPatchSizeY();

		jexMatrixRec = new Rectangle2D[dimWidth][dimHeight];
		for (int i = 0; i < dimWidth; i++) {
			for (int j = 0; j < dimHeight; j++) {
				jexMatrixRec[i][j] = new Rectangle2D.Double(i * pSizeX, j * pSizeY, pSizeX, pSizeY);
			}
		}
	}

	public void refresh() {

		/**
		 * Draw Environnement
		 */
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		int i = 0;
		int j = 0;

		//
		// for (i = 0; i < dimWidth; i++) {
		// for (j = 0; j < dimHeight; j++) {
		//
		// g2d.draw(jexMatrixRec[i][j]);
		// }
		// }

		for (i = 0; i < dimWidth; i++) {
			for (j = 0; j < dimHeight; j++) {
				g2d.setColor(new Color(JexEnvironnement2D.getPatchAt(i, j).color.getColorR(),
						JexEnvironnement2D.getPatchAt(i, j).color.getColorG(),
						JexEnvironnement2D.getPatchAt(i, j).color.getColorB()));
				g2d.fill(jexMatrixRec[i][j]);

			}
		}

		/**
		 * show agents
		 */

		JexObserver jexObserver = JexObserver.getInstance();
		Hashtable<String, JexAgent> hashtable = jexObserver.getListFollowedAgent();

		Set keys = hashtable.keySet();
		Iterator itr = keys.iterator();
		String key = "";

		while (itr.hasNext()) {
			key = (String) itr.next();
			JexAgent jAgent = hashtable.get(key);
			
			g2d.setColor(new Color(jAgent.color.getColorR(), jAgent.color.getColorG(), jAgent.color.getColorB()));
			
			if(jAgent.getShape() == jAgent.CERCLE) {
				g2d.fillOval(jAgent.getPosX() - (jAgent.radius / 2), jAgent.getPosY() - (jAgent.radius / 2), jAgent.radius,	jAgent.radius);
			}
			
			if(jAgent.getShape() == jAgent.SQUARE) {
				g2d.drawRect(jAgent.getPosX() - (jAgent.radius / 2), jAgent.getPosY() - (jAgent.radius / 2), jAgent.radius,	jAgent.radius);
			}
		}
		
		/**
		 * show Links
		 */
		List<JexLink> list = jexObserver.getListLinkAgent();
		Iterator<JexLink> it = list.iterator();
		
		while (it.hasNext()) {
			JexLink link = it.next();
			JexAgent src  = link.getAgentSrc();
			JexAgent dest = link.getAgentDest();
			g2d.setColor(new Color(link.color.getColorR(), link.color.getColorG(), link.color.getColorB()));
			g2d.drawLine(src.getPosX(), src.getPosY(), dest.getPosX(), dest.getPosY());
			
		}

	}

	private Rectangle2D[][] jexMatrixRec;
	private int dimWidth;
	private int dimHeight;
	private int pSizeX;
	private int pSizeY;

}

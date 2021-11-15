package jex;

public class JexAgent extends JexPosAgent {

	
	
	public String getJexAgentLocalName() {
		return jexAgentLocalName;
	}

	public void setJexAgentLocalName(String jexLocalName) {
		this.jexAgentLocalName = jexLocalName;
	}

	public void setInitPos(int posX, int posY) {
		if (posX < (JexEnvironnement2D.getMaxPatchX() * JexEnvironnement2D.getPatchSizeX()) && posX >= 0) {
			this.posX = posX;
		} else {
			this.posX = 0;
		}

		if (posY < (JexEnvironnement2D.getMaxPatchY() * JexEnvironnement2D.getPatchSizeY()) && posY >= 0) {
			this.posY = posY;
		}
		else {
			this.posY = 0;
		}
	}

	public void setRabdomHeading() {
		int heading = (int) (Math.random() * (360));
		this.setHeading(heading);
	}

	public void setRandomInitPos() {
		int posX = (int) (Math.random() * (JexEnvironnement2D.getMaxPatchX() * JexEnvironnement2D.getPatchSizeX()));
		int posY = (int) (Math.random() * (JexEnvironnement2D.getMaxPatchY() * JexEnvironnement2D.getPatchSizeY()));

		if (posX < (JexEnvironnement2D.getMaxPatchX() * JexEnvironnement2D.getPatchSizeX()) && posX >= 0) {
			this.posX = posX;
		} else {
			this.posX = 0;
		}

		if (posY < (JexEnvironnement2D.getMaxPatchY() * JexEnvironnement2D.getPatchSizeY()) && posY >= 0) {
			this.posY = posY;
		} else {
			this.posY = 0;
		}

	}

	public void setPosX(int posX) {
		if (posX <= (JexEnvironnement2D.getMaxPatchX() * JexEnvironnement2D.getPatchSizeX()) && posX >= 0) {
			this.posX = posX;
		}
		else {
			if(JexEnvironnement2D.isWorldWrapsHorizontally()) {
				if (posX < 0) {
					this.posX = JexEnvironnement2D.getMaxPatchX() * JexEnvironnement2D.getPatchSizeX()-1;
				}
				
				if (posX > (JexEnvironnement2D.getMaxPatchX() * JexEnvironnement2D.getPatchSizeX())) {
					this.posX = 0;
				}
			}
		}
		
		

	}

	public void setPosY(int posY) {
		
		if (posY < (JexEnvironnement2D.getMaxPatchY() * JexEnvironnement2D.getPatchSizeY()) && posY >= 0) {
			this.posY = posY;
		}
		else {
			if(JexEnvironnement2D.isWorldWrapsVertically()) {
				if (posY < 0) {
					this.posY = JexEnvironnement2D.getMaxPatchY() * JexEnvironnement2D.getPatchSizeY()-1;
				}
				
				if (posY > (JexEnvironnement2D.getMaxPatchY() * JexEnvironnement2D.getPatchSizeY())) {
					this.posY = 0;
				}
			}
		}
		
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		if (heading >= 0 && heading < 360) {
			this.heading = heading;
		}
	}

	public void forward(int i) {
		int x = 0 ;
		int y = 0 ;
		
		double teta = Math.toRadians(this.heading);
		
		if((Math.cos(teta) >= 0.01 )||(Math.cos(teta) <= -0.01)){
			x = (int) (i / (Math.cos(teta)));
		}
		if((Math.sin(teta) >= 0.01 )||(Math.sin(teta) <= -0.01)){
			y = (int) (i / (Math.sin(teta)));	
		}
		
		this.setPosX(this.getPosX() + x);
		this.setPosY(this.getPosY() + y);
	
	}

	public void backward(int i) {
		forward(-i);
	}
	
	
	
	public JexPatch getStepedPatch() {
		int x = (int) Math.floor(this.getPosX() / JexEnvironnement2D.getPatchSizeX());
		int y = (int) Math.floor(this.getPosY() / JexEnvironnement2D.getPatchSizeY());
		return JexEnvironnement2D.getPatchAt(x, y);
	}
	

	public final int NO_SHAPE = 0;
	public final int CERCLE = 1;
	public final int SQUARE = 2;

	protected int shape = 1;
	protected int radius = 10;
	protected int heading = 0;

	private String jexAgentLocalName;

}

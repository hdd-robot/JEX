package jex;

public abstract  class JexPosAgent extends JexGeneriqueAgent{

	

	JexPosAgent(){
		color = new JexColor(255, 255, 255);
	}

	public int getPosX() {
		return posX;
	}
	

	

	
	public int getPosY() {
		return posY;
	}


	
	protected int posX 			= 0;
	protected int posY 			= 0;
	

	
}

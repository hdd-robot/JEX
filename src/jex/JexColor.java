package jex;

public class JexColor {

	public JexColor(int colorR, int colorG, int colorB) {
		this.colorR = colorR;
		this.colorG = colorG;
		this.colorB = colorB;
	}
	
	public String getStringColorRGB() {
		return (Integer.toString(colorR) + "," + Integer.toString(colorR) + "," + Integer.toString(colorR));
	}

	public void setColorRGB(int colorR, int colorG, int colorB) {
		this.colorR = colorR;
		this.colorG = colorG;
		this.colorB = colorB;
	}

	public int getColorR() {
		return colorR;
	}

	public void setColorR(int colorR) {
		this.colorR = colorR;
	}

	public int getColorG() {
		return colorG;
	}

	public void setColorG(int colorG) {
		this.colorG = colorG;
	}

	public int getColorB() {
		return colorB;
	}

	public void setColorB(int colorB) {
		this.colorB = colorB;
	}
	
	

	private int colorR = 0;
	private int colorG = 0;
	private int colorB = 0;
}

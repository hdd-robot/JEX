
package jex;

public class JexEnvironnement2D extends JexEnvironnement {

	public static void init() {
		init2D();
	}

	public static void init2D() {
		init2D(100, 100, 0, 0, false, false);
	}

	public static void init2D(int maxPatchX, int maxPatchY, int orginX, int orginY, boolean worldWrapsHorizontally, boolean worldWrapsVertically) {
		
		JexEnvironnement2D.setMaxPatchX(maxPatchX);
		JexEnvironnement2D.setMaxPatchY(maxPatchY);
		JexEnvironnement2D.setWorldWrapsHorizontally(worldWrapsVertically);
		JexEnvironnement2D.setWorldWrapsVertically(worldWrapsHorizontally);
		JexEnvironnement2D.jexMatrixPatch = new JexPatch[maxPatchX][maxPatchY];
		
		for (int i = 0; i < maxPatchX; i++ ) {
			for (int j = 0; j < maxPatchY; j++ ) {
				JexEnvironnement2D.jexMatrixPatch[i][j]= new JexPatch(i,j);
				JexEnvironnement2D.jexMatrixPatch[i][j].color.setColorRGB(200, 200, 200);
			}
		}
		
	}

	/*
	 * Getters
	 */
	public static boolean isWorldWrapsHorizontally() {
		return JexEnvironnement2D.worldWrapsHorizontally;
	}

	public static boolean isWorldWrapsVertically() {
		return JexEnvironnement2D.worldWrapsVertically;
	}

	public static int getMaxPatchX() {
		return JexEnvironnement2D.maxPatchX;
	}

	public static int getMaxPatchY() {
		return JexEnvironnement2D.maxPatchY;
	}

	public static int getOrginX() {
		return JexEnvironnement2D.orginX;
	}

	public static int getOrginY() {
		return JexEnvironnement2D.orginY;
	}

	public static int getPatchSizeX() {
		return JexEnvironnement2D.patchSizeX;
	}

	public static int getPatchSizeY() {
		return JexEnvironnement2D.patchSizeY;
	}

	
	public static JexPatch getPatchAt(int x, int y) {
		return JexEnvironnement2D.jexMatrixPatch[x][y];
	}
	
	/*
	 * Setters
	 */
	private static void setMaxPatchY(int maxPatchY) {
		JexEnvironnement2D.maxPatchY = maxPatchY;
	}

	private static void setMaxPatchX(int maxPatchX) {
		JexEnvironnement2D.maxPatchX = maxPatchX;
	}

	private static void setWorldWrapsVertically(boolean worldWrapsVertically) {
		JexEnvironnement2D.worldWrapsVertically = worldWrapsVertically;
	}

	private static void setWorldWrapsHorizontally(boolean worldWrapsHorizontally) {
		JexEnvironnement2D.worldWrapsHorizontally = worldWrapsHorizontally;
	}

	private static void setOrginX(int orginX) {
		JexEnvironnement2D.orginX = orginX;
	}

	private static void setOrginY(int orginY) {
		JexEnvironnement2D.orginY = orginY;
	}

	private static void setPatchSizeX(int patchSizeX) {
		JexEnvironnement2D.patchSizeX = patchSizeX;
	}

	private static void setPatchSizeY(int patchSizeY) {
		JexEnvironnement2D.patchSizeY = patchSizeY;
	}

	
	/**
	 * Attributes
	 */
	protected static volatile boolean worldWrapsHorizontally = false;
	protected static volatile boolean worldWrapsVertically = false;
	
	protected static volatile int patchSizeX =5;
	protected static volatile int patchSizeY =5;
	
	protected static volatile int maxPatchX = 0;
	protected static volatile int maxPatchY = 0;
	protected static volatile int orginX = 0;
	protected static volatile int orginY = 0;
	
	protected static volatile JexPatch[][] jexMatrixPatch;

}

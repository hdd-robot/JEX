package jex;

public interface JexAgentObserve {
	public void subscribe();
	public void unsubscribe();
	
	public void pos(int posX,int posY, int teta);
	
}

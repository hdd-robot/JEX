package jex;

import java.awt.Color;

public class JexLink extends JexGeneriqueAgent {

	JexLink(JexAgent agentSrc, JexAgent agentDest,boolean directed) {
		this.setAgentSrc(agentSrc);
		this.setagentDest(agentDest);
		this.setDirected(directed);
		
		this.setColor(new JexColor(0, 0, 0));
	}

	public JexAgent getAgentSrc() {
		return agentSrc;
	}

	public void setAgentSrc(JexAgent agentSrc) {
		this.agentSrc = agentSrc;
	}

	public JexAgent getagentDest() {
		return agentDest;
	}

	public void setagentDest(JexAgent agentDest) {
		this.agentDest = agentDest;
	}

	
	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public JexAgent getAgentDest() {
		return agentDest;
	}

	public void setAgentDest(JexAgent agentDest) {
		this.agentDest = agentDest;
	}



	private boolean  directed  = false;
	private JexAgent agentSrc  = null ;
	private JexAgent agentDest = null ;

	
	

}

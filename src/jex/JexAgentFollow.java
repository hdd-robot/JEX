package jex;

import jade.core.Agent;

public class JexAgentFollow {

	JexAgentFollow(int agentID, Agent agent, int posX , int posY, int heading ){
		this.agentID = agentID;
		this.ref = agent;
		this.posX = posX;
		this.posY = posY;
		this.heading = heading ;
	}
	
	
	protected int agentID;
	protected Agent ref;
	protected int posX;
	protected int posY;
	protected int heading; 
}

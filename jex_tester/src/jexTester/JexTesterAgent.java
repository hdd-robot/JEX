package jexTester;

import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jex.JexEnvironnement2D;
import jex.JexObserver;

public class JexTesterAgent extends Agent{

	protected void setup() {
		System.out.println("Agent JEX TESTER ");
		
		/**
		 * Init Environnement 
		 */
		
		JexEnvironnement2D.init2D(80, 60, 0, 0, true, true);
		JexEnvironnement2D.setRefreshTime(1000);
		
		
		Object args[] = new Object[1];
		args[0] = "";
		ContainerController cc = getContainerController();
		try {
		   AgentController ac = cc.createNewAgent("JexObserverAgent", "jex.JexObserver", args);
		   ac.start();
		   
		   AgentController ac2 = cc.createNewAgent("agent testeur 1", "jexTester.AgentToTest", args);
		   ac2.start();
	
		   AgentController ac3 = cc.createNewAgent("agent testeur 2", "jexTester.AgentToTest2", args);
		   ac3.start();
		   
		}
		catch (Exception e) {
		   System.out.println("exception : " + e);
		}


		doDelete();
	}

}

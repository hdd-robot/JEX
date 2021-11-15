package jexTester;


import org.omg.CORBA.Environment;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jex.JexAgent;
import jex.JexAgentObserve;
import jex.JexColor;
import jex.JexEnvironnement2D;
import jex.JexObserver;

public class AgentToTest2 extends Agent {
	
	private JexObserver jexObserver = JexObserver.getInstance();

	protected void setup() {
		
		jexObserver.subscribe(this.getLocalName());
		
		JexAgent jexAgent= jexObserver.getJexAgent(this.getLocalName());
		
		jexAgent.setRadius(10);
		jexAgent.setShape(jexAgent.CERCLE);
		jexAgent.setColor(new JexColor(200,0,0));
		jexAgent.setRandomInitPos();
		
		addBehaviour(new TickerBehaviour(this, 1000) {
			protected void onTick() {		
				jexAgent.setHeading(30);
				jexAgent.forward(100);
			}
		});

	}

}

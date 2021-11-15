package jexTester;

import org.omg.CORBA.Environment;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jex.JexAgent;
import jex.JexAgentObserve;
import jex.JexColor;
import jex.JexEnvironnement2D;
import jex.JexObserver;
import jex.JexPatch;

public class AgentToTest extends Agent {
	
	private JexObserver jexObserver = JexObserver.getInstance();

	protected void setup() {
		
		jexObserver.subscribe(this.getLocalName());
		JexAgent jexAgent= jexObserver.getJexAgent(this.getLocalName());
		
		jexAgent.setRadius(10);
		jexAgent.setShape(jexAgent.CERCLE);
		jexAgent.setColor(new JexColor(0,200,0));
		
		jexAgent.setRandomInitPos();
		
		
		
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		
		jexObserver.addLink(jexAgent.getJexAgentLocalName(), "agent testeur 2" , false);
		
		addBehaviour(new TickerBehaviour(this, 1000) {
			protected void onTick() {		
				jexAgent.setHeading(30);
				jexAgent.forward(1);
				
				JexPatch p = jexAgent.getStepedPatch();
				p.setColor(new JexColor(20, 200, 200));
			}
		});

	}

}

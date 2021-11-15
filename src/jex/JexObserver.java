package jex;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class JexObserver extends Agent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see jade.core.Agent#setup()
	 */
	protected final void setup() {
		init();

		addBehaviour(new TickerBehaviour(this, JexEnvironnement2D.getRefreshTime()) {
			protected void onTick() {
				gexGui.refresh();
			}
		});
	}

	/*
	 * 
	 */
	public static JexObserver getInstance() {
		if (INSTANCE == null) {
			synchronized (JexObserver.class) {
				if (INSTANCE == null) {
					INSTANCE = new JexObserver();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * 
	 */
	protected void init() {
	
		gexGui = new GexGui();
	}

	/**
	 * 
	 * @param jadeAgentID
	 * @return
	 */
	public JexAgent getJexAgent(String jadeAgentID) {
		JexAgent jexAgent = listFollowedAgent.get(jadeAgentID);
		if (jexAgent == null) {
			return null;
		}
		return jexAgent;
	}

	/**
	 * 
	 * @param jadeAgentID
	 * @return
	 */
	public synchronized JexAgent subscribe(String jadeAgentID) {
		
		JexAgent jexAgent = listFollowedAgent.get(jadeAgentID);
		if (jexAgent == null) {
			jexAgent = new JexAgent();
			jexAgent.setJexAgentLocalName(jadeAgentID);
			listFollowedAgent.put(jadeAgentID, jexAgent);
		}
		return jexAgent;
	}

	/**
	 * 
	 * @param jadeAgentID
	 */
	public synchronized void unsubscribe(String jadeAgentID) {
		listFollowedAgent.remove(jadeAgentID);
	}

	/**
	 * 
	 * @param jadeAgentID
	 * @param jexAgent
	 */
	public synchronized void update(String jadeAgentID, JexAgent jexAgent) {
		JexAgent jexAgentSearch = listFollowedAgent.get(jadeAgentID);
		if (jexAgentSearch != null) {
			listFollowedAgent.put(jadeAgentID, jexAgent);
		}
	}

	/**
	 * 
	 * @param src
	 * @param dest
	 * @param directed
	 */
	public synchronized void addLink(JexAgent src, JexAgent dest, boolean directed) {
		JexLink link = new JexLink(src, dest, directed);
		this.listLinkAgent.add(link);
	}
	
	/**
	 * ADD LINK with key only
	 */
	public synchronized void addLink(String srcLocalName, String destLocalName, boolean directed) {
		
		
		addLink(this.getJexAgent(srcLocalName), this.getJexAgent(destLocalName), directed);
	}
	
	

	/**
	 * 
	 * @param src
	 * @param dest
	 */
	public synchronized void removeLink(JexAgent src, JexAgent dest) {
		Iterator<JexLink> it = this.listLinkAgent.iterator();

		while (it.hasNext()) {
			JexLink link = it.next();
			if (link.getAgentSrc() == src && link.getAgentDest() == dest) {
				it.remove();
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public synchronized Hashtable<String, JexAgent> getListFollowedAgent() {
		return listFollowedAgent;
	}

	/**
	 * 
	 * @return
	 */
	public synchronized List<JexLink> getListLinkAgent() {
		return listLinkAgent;
	}

	private GexGui gexGui;
	private volatile Hashtable<String, JexAgent> listFollowedAgent = new Hashtable<String, JexAgent>();
	private volatile List<JexLink> listLinkAgent = new ArrayList<JexLink>();

	private static JexObserver INSTANCE = null;
}

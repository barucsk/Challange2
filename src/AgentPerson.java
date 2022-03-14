package examples.challenge2;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.*;

public class AgentMarket extends Agent {
  Environment clips;

  protected void setup() {
     clips = new Environment();
    addBehaviour(new TellBehaviour());
  } 

  private class TellBehaviour extends Behaviour {
    boolean tellDone = false;

    public void action() {
        System.out.println("Tell is executed");
        clips.eval("(clear)");
	    clips.load("market/run-persons.clp");
	    clips.eval("(reset)");
	    clips.eval("(facts)");
		clips.run();
       tellDone = true;
    } 

    public boolean done() {
      if (tellDone)
        return true;
      else
	return false;
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  } 
}
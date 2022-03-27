package examples.clips.agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.Environment;

public class ClipsAgent extends Agent {
  Environment clips;

  protected void setup() {
     try{clips = new Environment();}catch(Exception e) {}
    addBehaviour(new TellBehaviour());
    addBehaviour(new AskBehaviour());
  } 

  private class TellBehaviour extends Behaviour {
    boolean tellDone = false;

    public void action() {
       System.out.println("Tell is executed");
        try
       {clips.eval("(clear)");

       clips.build("(defrule r1 (sintoma ?x) => (printout t ?x crlf))");
       clips.eval("(reset)");

       clips.eval("(assert (sintoma a))");
       clips.eval("(assert (sintoma b))");

       clips.eval("(facts)");}catch(Exception e) {}


       tellDone = true;
    } 

    public boolean done() {
      if (tellDone)
        return true;
      else
	return false;
    }

  }    // END of inner class ...Behaviour

  private class AskBehaviour extends Behaviour {
    boolean askDone = false;

    public void action() {
       System.out.println("Ask is executed");

       try{clips.run();}catch(Exception e){}

       askDone = true;
    } 

    public boolean done() {
      if (askDone)
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
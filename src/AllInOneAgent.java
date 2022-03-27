package examples.clips.agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.Environment;

public class AllInOneAgent extends Agent {
  Environment clips;

  protected void setup() {
     try{clips = new Environment();}catch(Exception e) {}
    addBehaviour(new TellBehaviour());
    addBehaviour(new AskBehaviour());
  } 

public void setMarket()
    {
        try{clips.clear();
			clips.load("src/clips/market/templates.clp");

			clips.load("src/clips/market/facts.clp");
        
            clips.load("src/clips/market/rules.clp");

			clips.reset();
       		clips.eval("(facts)");
		}catch(Exception e) {}
    }

public void setPersons()
    {
        try{
            clips.clear();
			clips.load("src/clips/persons/load-persons.clp");
			clips.load("src/clips/persons/load-persons-rules.clp");
			clips.reset();
       		clips.eval("(facts)");
		}catch(Exception e) {}
    }

public void setProdcust()
    {
        try{
            clips.clear();
			clips.load("src/clips/prodcust/load-prod-cust.clp");

			clips.load("src/clips/prodcust/load-prodcust-rules.clp");

			clips.reset();
       		clips.eval("(facts)");
		}catch(Exception e) {}
    
    }

  private class TellBehaviour extends Behaviour {
    boolean tellDone = false;

    

    public void action() {
		
       System.out.println("Tell is executed");
       
            


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

       try{
           setMarket();
		   clips.run();
		   clips.clear();
           setPersons();
		   clips.run();
		   clips.clear();
           setProdcust();
		   clips.run();
		   clips.clear();
		}catch(Exception e){}

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
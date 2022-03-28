Ok. Here now we are mixed clips inside an jade agent
First we are do a agent test call ClipsAgent.java
And later do a diferents agent MarketAgent, PersonsAgent, ProdcustAgent to run the challange1 over
agents. And finally AllInOneAgent that run that three in one.

To compile the files we use this command structure
	javac -cp lib/*  src/ClipsAgent.java  -d classes/
	javac -cp lib/*  src/PersonsAgent.java  -d classes/

To execute the agents use this command
	java -cp lib\*;classes jade.Boot -gui -agents clipsAgent:examples.clips.agents.ClipsAgent
	java -cp lib\*;classes jade.Boot -gui -agents PersonsAgent:examples.clips.agents.PersonsAgent
	
And do it the same with the other files

****************************************************************************************
		https://youtu.be/dlM0BXMEoh4
****************************************************************************************

package com.uni.fmi.futuristicfarm.ai.agent;

import com.uni.fmi.futuristicfarm.ai.FarmOntology;
import com.uni.fmi.futuristicfarm.ai.gui.CustomerAgentGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer Agent is an agent that sends customer's consultation request.
 */
public class CustomerAgent extends Agent {

    private CustomerAgentGUI customerAgentGUI;
    private String selectedPlant;
    private List<String> selectedSymptoms;
    private ArrayList<AID> farmers;

    @Override
    protected void setup() {
        final FarmOntology farmOntology = new FarmOntology();
        customerAgentGUI = new CustomerAgentGUI(
                this,
                farmOntology.getAllSymptoms(),
                farmOntology.getAllPlants());
        selectedSymptoms = new ArrayList<>();
        addBehaviour(new CustomerBehaviour(this, 1000));
    }

    private class CustomerBehaviour extends TickerBehaviour {

        public CustomerBehaviour(Agent a, long period) {
            super(a, period);
        }

        @Override
        protected void onTick() {
            if (selectedPlant != null && !selectedSymptoms.isEmpty()) {
                System.out.printf("I am searching for illness of plant %s with the " +
                        "following symptoms: %s%n", selectedPlant, String.join(",", selectedSymptoms));

                DFAgentDescription dfd = new DFAgentDescription();
                ServiceDescription sd = new ServiceDescription();
                sd.setType("consultation");
                dfd.addServices(sd);

                try {
                    DFAgentDescription[] descriptions = DFService.search(myAgent, dfd);
                    farmers = new ArrayList<>();

                    for (DFAgentDescription description : descriptions) {
                        farmers.add(description.getName());
                    }
                } catch (FIPAException e) {
                    e.printStackTrace();
                }

                if (farmers.size() > 0) {
                    myAgent.addBehaviour(new CustomerSendConsultationRequestBehaviour());
                } else {
                    System.out.println("There are no farmer agents available!");
                }
            }
        }
    }

    private class CustomerSendConsultationRequestBehaviour extends OneShotBehaviour {

        @Override
        public void action() {
            ACLMessage cfp = new ACLMessage(ACLMessage.CFP);

            for (AID farmer : farmers) {
                cfp.addReceiver(farmer);
            }

            cfp.setContent(selectedPlant + "," + String.join(",", selectedSymptoms));
            cfp.setConversationId("consultation request");
            cfp.setReplyWith("cfp" + System.currentTimeMillis());

            MessageTemplate mt = MessageTemplate.and(
                    MessageTemplate.MatchConversationId("consultation request"),
                    MessageTemplate.MatchInReplyTo(cfp.getReplyWith())
            );

            send(cfp);

            selectedPlant = null;
            selectedSymptoms = List.of();
            removeBehaviour(this);
        }
    }

    public void setSelectedSymptoms(List<String> selectedSymptoms) {
        this.selectedSymptoms = selectedSymptoms;
    }

    public void setSelectedPlant(String selectedPlant) {
        this.selectedPlant = selectedPlant;
    }
}

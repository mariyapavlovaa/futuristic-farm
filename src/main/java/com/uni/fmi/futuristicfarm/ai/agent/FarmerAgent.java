package com.uni.fmi.futuristicfarm.ai.agent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uni.fmi.futuristicfarm.ai.FarmOntology;
import com.uni.fmi.futuristicfarm.ai.gui.FarmerAgentGUI;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Farm Agent is agent that accepts customer's consultation request and returns diagnose answer.
 */
public class FarmerAgent extends Agent {

    private FarmerAgentGUI farmerAgentGUI;
    private FarmOntology farmOntology;
    public String resultLabel = null;

    @Override
    protected void setup() {

        farmOntology = new FarmOntology();
        farmerAgentGUI = new FarmerAgentGUI(this, farmOntology.getAllSymptoms());


        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("consultation");
        sd.setName("farmer consultation agent");

        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            e.printStackTrace();
        }

        addBehaviour(new FarmSendConsultationResultBehaviour());

    }

    private class FarmSendConsultationResultBehaviour extends CyclicBehaviour {

        @Override
        public void action() {

            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = receive(mt);

            if (msg != null) {

                List<String> messageContent = Arrays.stream(msg.getContent().split(","))
                        .map(String::trim).toList();
                String plant = new String(messageContent.get(0));
                System.out.println("Received plant: " + plant);
                List<String> symptoms = new ArrayList<>(messageContent.subList(1, messageContent.size()));

                ACLMessage reply = msg.createReply();

                //symptoms are left in the messageContent
                List<String> result = farmOntology.getIllnessBySymptom(plant,symptoms);
                ObjectMapper mapper = new ObjectMapper();

                if (result.size() > 0) {
                    resultLabel= String.join(",", result);
                    System.out.println("The found Illness by the given symptoms is: " + resultLabel);
                    reply.setPerformative(ACLMessage.INFORM);

                    try {
                        reply.setContent(mapper.writeValueAsString(result));
                        reply.setLanguage("JSON");
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                } else {
                    resultLabel= "There is no such Illness!";
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setContent("consultation");
                    reply.setLanguage("JSON");
                    System.out.println("There is no such Illness!");
                }

                send(reply);
            }

        }
    }

    public FarmOntology getFarmOntology() {
        return farmOntology;
    }
}

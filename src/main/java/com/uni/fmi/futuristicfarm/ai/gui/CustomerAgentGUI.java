package com.uni.fmi.futuristicfarm.ai.gui;

import com.uni.fmi.futuristicfarm.ai.agent.CustomerAgent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerAgentGUI extends JFrame {

    public CustomerAgentGUI(CustomerAgent customerAgent, List<String> symptoms, List<String> plants) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Customer Agent");

        Container cp = getContentPane();

        JLabel selectPlantLabel = new JLabel("Please select a plant:");
        JComboBox<String> plantComboBox = new JComboBox<>();
        plantComboBox.addItem("Plant options"); // Add default text as the first item
        plants.forEach(plantComboBox::addItem);
        plantComboBox.setSelectedIndex(0); // Set the default text as the selected item
        plantComboBox.setEditable(false);

        JLabel selectSymptomsLabel = new JLabel("Please select from the symptoms:");
        JList<String> symptomsNames = new JList<>(symptoms.toArray(new String[0]));
        symptomsNames.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane symptomsScrollPane = new JScrollPane(symptomsNames);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = plantComboBox.getSelectedItem();
                List<String> selectedSymptoms = symptomsNames.getSelectedValuesList();

                if (!selectedSymptoms.isEmpty() && selectedItem != null) {
                    String selectedPlant = selectedItem.toString();
                    String plant = selectedPlant.replace("Ill", "");
                    customerAgent.setSelectedPlant(plant);
                    customerAgent.setSelectedSymptoms(selectedSymptoms);
                }
            }
        });

        JPanel contentPane = new JPanel(new GridLayout(4, 1, 5, 5));
        contentPane.setBackground(new Color(0, 100, 0)); // RGB values for dark green
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.add(selectPlantLabel);
        contentPane.add(plantComboBox);
        contentPane.add(selectSymptomsLabel);
        contentPane.add(symptomsScrollPane);

        cp.add(contentPane, BorderLayout.CENTER);
        cp.add(searchButton, BorderLayout.SOUTH);

        setSize(600, 500);
        setVisible(true);
    }
}

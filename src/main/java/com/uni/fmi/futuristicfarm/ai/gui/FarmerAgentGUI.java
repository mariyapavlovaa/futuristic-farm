package com.uni.fmi.futuristicfarm.ai.gui;

import com.uni.fmi.futuristicfarm.ai.agent.FarmerAgent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FarmerAgentGUI extends JFrame {

    FarmerAgent myAgent;
    List<String> symptoms;

    public FarmerAgentGUI(FarmerAgent myAgent, List<String> symptoms) {
        this.myAgent = myAgent;
        this.symptoms = symptoms;
        initialize();
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Farmer Agent");

        Container cp = getContentPane();

        JPanel contentPane = new JPanel(new GridLayout(4, 3));
        contentPane.setBackground(new Color(0, 0, 128)); // RGB values for darker blue

        // Show result
        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(new Color(0, 0, 128)); // RGB values for darker blue
        JLabel resultLabel = new JLabel("<html>Please, <br>" +
                " click Show Result button <br>" +
                "to see the found Illness of your crop.");
        resultLabel.setForeground(Color.WHITE); // Set text color to white
        JButton resultButton = new JButton("Show Result");
        resultButton.setForeground(Color.BLACK); // Set text color to black
        resultPanel.add(resultLabel);
        resultPanel.add(resultButton);
        contentPane.add(resultPanel);

        // Creating new symptom
        JPanel createNewSymptomPanel = new JPanel();
        createNewSymptomPanel.setBackground(new Color(0, 0, 160)); // RGB values for darker blue
        JLabel createLabel = new JLabel("Enter Symptom Name:");
        createLabel.setForeground(Color.WHITE); // Set text color to white
        JTextField newSymptomTF = new JTextField(10); // New text field for entering a new symptom
        newSymptomTF.setEditable(true);
        JButton createSymptomButton = new JButton("Create Symptom"); // New button for creating the new symptom
        createSymptomButton.setForeground(Color.BLACK); // Set text color to black
        createNewSymptomPanel.add(createLabel);
        createNewSymptomPanel.add(newSymptomTF);
        createNewSymptomPanel.add(createSymptomButton);
        contentPane.add(createNewSymptomPanel);

        // Deleting symptom
        JPanel deleteSymptomPanel = new JPanel();
        deleteSymptomPanel.setBackground(new Color(0, 0, 200)); // RGB values for darker blue
        JLabel deleteLabel = new JLabel("Enter Symptom Name:");
        deleteLabel.setForeground(Color.WHITE); // Set text color to white
        JTextField deleteSymptomTF = new JTextField(10); // New text field for entering a symptom to delete
        deleteSymptomTF.setEditable(true);
        JButton deleteSymptomButton = new JButton("Delete Symptom"); // New button for deleting the symptom
        deleteSymptomButton.setForeground(Color.BLACK); // Set text color to black
        deleteSymptomPanel.add(deleteLabel);
        deleteSymptomPanel.add(deleteSymptomTF);
        deleteSymptomPanel.add(deleteSymptomButton);
        contentPane.add(deleteSymptomPanel);

        // edit
        JPanel editPanel = new JPanel();
        editPanel.setBackground(new Color(0, 0, 240)); // RGB values for darker blue
        JLabel editLabel = new JLabel("Please select from old symptoms' names:");
        editLabel.setForeground(Color.WHITE); // Set text color to white
        JComboBox<String> editComboBox = new JComboBox<>();
        editComboBox.addItem("Symptoms"); // Add default text as the first item
        symptoms.forEach(editComboBox::addItem);
        editComboBox.setSelectedIndex(0); // Set the default text as the selected item
        editComboBox.setEditable(false);
        JLabel newSymptomLabel = new JLabel("Enter New Symptom Name:");
        newSymptomLabel.setForeground(Color.WHITE); // Set text color to white
        JTextField newSymptomNameTF = new JTextField(10); // New text field for entering a symptom to delete
        newSymptomNameTF.setEditable(true);
        JButton editButton = new JButton("Edit");
        editPanel.add(editLabel);
        editPanel.add(editComboBox);
        editPanel.add(newSymptomLabel);
        editPanel.add(newSymptomNameTF);
        editPanel.add(editButton);
        contentPane.add(editPanel);

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "The found Illness is: " + myAgent.resultLabel;
                JOptionPane.showMessageDialog(FarmerAgentGUI.this, message);
            }
        });

        createSymptomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newSymptom = newSymptomTF.getText();
                myAgent.getFarmOntology().createSymptom(newSymptom); // Call the method to create the new symptom
                newSymptomTF.setText(""); // Clear the text field
            }
        });

        deleteSymptomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String symptomToDelete = deleteSymptomTF.getText();
                myAgent.getFarmOntology().deleteSymptom(symptomToDelete); // Call the method to delete the symptom
                deleteSymptomTF.setText(""); // Clear the text field
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedOldSymptom = editComboBox.getSelectedItem();
                String symptomToBeEdited = newSymptomNameTF.getText();

                if (selectedOldSymptom != null && symptomToBeEdited != null) {
                    myAgent.getFarmOntology().updateSymptom(symptomToBeEdited, selectedOldSymptom.toString());
                }
                newSymptomNameTF.setText(""); // Clear the text field

            }
        });

        cp.add(contentPane);

        setSize(430, 450);
        setVisible(true);
    }

}
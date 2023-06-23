package com.uni.fmi.futuristicfarm.ai.gui;

import com.uni.fmi.futuristicfarm.ai.agent.FarmerAgent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FarmerAgentGUI extends JFrame {

    FarmerAgent myAgent;

    public FarmerAgentGUI(FarmerAgent myAgent) {
        this.myAgent = myAgent;
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

        JTextField resultNameTF = new JTextField(10);
        resultNameTF.setEditable(true);

        JLabel resultLabel = new JLabel("<html>Please, <br>" +
                " click Show Result button <br>" +
                "to see the found Illness of your crop.");
        resultLabel.setForeground(Color.WHITE); // Set text color to white

        JButton resultButton = new JButton("Show Result");
        resultButton.setForeground(Color.BLACK); // Set text color to black

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(new Color(0, 0, 128)); // RGB values for darker blue
        JPanel row = new JPanel();
        row.setBackground(new Color(0, 0, 128)); // RGB values for darker blue

        row.add(resultLabel);
        contentPane.add(row, BorderLayout.CENTER);
        contentPane.add(resultButton, BorderLayout.SOUTH);

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Намерената болест е: " + myAgent.resultLabel;
                JOptionPane.showMessageDialog(FarmerAgentGUI.this, message);
            }
        });

        cp.add(contentPane);

        setSize(300, 200);
        setVisible(true);
    }

}
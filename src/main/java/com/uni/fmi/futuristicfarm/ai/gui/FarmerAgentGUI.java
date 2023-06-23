package com.uni.fmi.futuristicfarm.ai.gui;

import com.uni.fmi.futuristicfarm.ai.agent.FarmerAgent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FarmerAgentGUI extends JFrame {

    FarmerAgent myAgent;

    public FarmerAgentGUI(FarmerAgent myAgent) {
        this.myAgent = myAgent;
        initialize();
    }

    private void initialize() {
        Container cp = getContentPane();

        JTextField resultNameTF = new JTextField(10);
        resultNameTF.setEditable(true);

        JLabel resultLabel = new JLabel("<html>Please, <br>" +
                " click Show Result button <br>" +
                "to see the found Illness of your crop.");

        JButton resultButton = new JButton("Show Result");

        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel row = new JPanel();

        row.add(resultLabel);
        // row.add(resultNameTF);
        contentPane.add(row, BorderLayout.CENTER);
        contentPane.add(resultButton, BorderLayout.SOUTH);

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                String result = resultNameTF.getText();

                String message = "Намерената болест е: " + myAgent.resultLabel;
                JOptionPane.showMessageDialog(FarmerAgentGUI.this, message);
            }
        });

        cp.add(contentPane);

        setSize(300, 200);
        setVisible(true);
    }

}
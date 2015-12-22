package miniproject3;

import javax.swing.*;

public class SolutionDialog extends JDialog{
    public SolutionDialog(MainWindow parent, String title, String algorithm, float time, String solution){
        super(parent, title, true);
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JLabel algorithmLabel = new JLabel("Algorithme");
        JTextField algorithmTextField = new JTextField(algorithm);
        Box algorithmBox = Box.createHorizontalBox();
        algorithmTextField.setEditable(false);
        algorithmTextField.setBorder(BorderFactory.createEtchedBorder());
        algorithmBox.add(algorithmLabel);
        algorithmBox.add(Box.createHorizontalStrut(5));
        algorithmBox.add(algorithmTextField);
        JLabel elapsedTimeLabel = new JLabel("Temps écoulé");
        JTextField elapsedTimeTextField = new JTextField(String.format("%.3f", time));
        elapsedTimeTextField.setEditable(false);
        elapsedTimeTextField.setBorder(BorderFactory.createEtchedBorder());
        Box elapsedTimeBox = Box.createHorizontalBox();
        elapsedTimeBox.add(elapsedTimeLabel);
        elapsedTimeBox.add(Box.createHorizontalStrut(5));
        elapsedTimeBox.add(elapsedTimeTextField);
        elapsedTimeBox.add(new JLabel(String.format("seconde%s", time < 2 ? "" : "s")));
        elapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JLabel solutionLabel = new JLabel("Solution");
        JTextArea solutionTextArea = new JTextArea(5, 20);
        solutionTextArea.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        solutionTextArea.setEditable(false);
        solutionTextArea.setLineWrap(true);
        solutionTextArea.setWrapStyleWord(true);
        Box solutionBox = Box.createHorizontalBox();
        solutionBox.add(solutionLabel);
        solutionBox.add(Box.createHorizontalStrut(5));
        solutionBox.add(new JScrollPane(solutionTextArea));
        mainBox.add(algorithmBox);
        mainBox.add(elapsedTimeBox);
        mainBox.add(solutionBox);
        add(mainBox);
        pack();
        setLocationRelativeTo(parent);
        solutionTextArea.setText(solution);
        setVisible(true);
    }
}

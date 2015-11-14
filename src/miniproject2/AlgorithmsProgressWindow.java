package miniproject2;

import miniproject2.sort.Algorithm;
import miniproject2.sort.BubbleSortAlgorithm;
import miniproject2.sort.SortAlgorithm;

import javax.swing.*;
import java.awt.*;

public class AlgorithmsProgressWindow extends JFrame {
    JProgressBar algorithmProgressBar;
    JLabel algorithmNameLabel;
    JLabel caseLabel;
    JLabel numberLabel;

    @SuppressWarnings("unchecked")
    AlgorithmsProgressWindow() {
        super();
        Box mainBox =  Box.createVerticalBox();
        mainBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        algorithmNameLabel = new JLabel();
        numberLabel = new JLabel();
        caseLabel = new JLabel();

        Box algorithmNameBox = Box.createHorizontalBox();
        algorithmNameBox.add(algorithmNameLabel);
        Box caseBox = Box.createHorizontalBox();
        caseBox.add(numberLabel);
        caseBox.add(Box.createHorizontalStrut(5));
        caseBox.add(caseLabel);

        algorithmProgressBar = new JProgressBar();
        algorithmProgressBar.setStringPainted(true);
        algorithmProgressBar.setPreferredSize(new Dimension(300, algorithmProgressBar.getPreferredSize().height));
        Box algorithmProgressBox = Box.createHorizontalBox();
        algorithmProgressBox.add(algorithmProgressBar);

        mainBox.add(algorithmProgressBox);
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(algorithmNameBox);
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(caseBox);
        mainBox.add(Box.createVerticalStrut(5));

        add(mainBox);
        setTitle("Tri d'un tableau");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void start(int[] numbers, Algorithm algorithm, boolean worstCase){
        numberLabel.setText(String.format(worstCase ? "De %d à 1" : "De 1 à %d", numbers.length));
        caseLabel.setText(worstCase ? "Pire cas" : "Meilleur cas");
        SortAlgorithm sortAlgorithm;
        switch (algorithm) {
            case Bubble:
                sortAlgorithm = new BubbleSortAlgorithm(numbers, worstCase, this);
                algorithmNameLabel.setText(sortAlgorithm.toString());
                sortAlgorithm.execute();
                break;
        }
        pack();
        setVisible(true);
    }

    public void setProgress(int progress){
        algorithmProgressBar.setValue(progress);
    }
}

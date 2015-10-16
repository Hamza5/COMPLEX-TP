package miniproject1;

import miniproject1.prime.*;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AlgorithmsProgressWindow extends JFrame {
    JProgressBar algorithm1ProgressBar;
    JProgressBar algorithm2ProgressBar;
    JLabel algorithm1ElapsedTimeLabel;
    JLabel algorithm2ElapsedTimeLabel;
    AlgorithmsProgressWindow() {
        super();
        Box mainBox =  Box.createVerticalBox();
        mainBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        Box algorithm1Box = Box.createHorizontalBox();
        algorithm1Box.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        JLabel algorithm1Label = new JLabel("Algorithme 1");
        algorithm1Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        algorithm1ProgressBar = new JProgressBar();
        algorithm1ProgressBar.setStringPainted(true);
        algorithm1ProgressBar.setPreferredSize(new Dimension(300, algorithm1ProgressBar.getPreferredSize().height));
        algorithm1ElapsedTimeLabel = new JLabel("...");
        Box algorithm1ElapsedTimeBox = Box.createHorizontalBox();
        algorithm1ElapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        algorithm1ElapsedTimeBox.add(algorithm1ElapsedTimeLabel);
        algorithm1Box.add(algorithm1Label);
        algorithm1Box.add(algorithm1ProgressBar);
        mainBox.add(algorithm1Box);
        mainBox.add(algorithm1ElapsedTimeBox);

        Box algorithm2Box = Box.createHorizontalBox();
        algorithm2Box.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JLabel algorithm2Label = new JLabel("Algorithme 2");
        algorithm2Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        algorithm2ProgressBar = new JProgressBar();
        algorithm2ProgressBar.setStringPainted(true);
        algorithm2ProgressBar.setPreferredSize(new Dimension(300, algorithm2ProgressBar.getPreferredSize().height));
        algorithm2ElapsedTimeLabel = new JLabel("...");
        Box algorithm2ElapsedTimeBox = Box.createHorizontalBox();
        algorithm2ElapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        algorithm2ElapsedTimeBox.add(algorithm2ElapsedTimeLabel);
        algorithm2Box.add(algorithm2Label);
        algorithm2Box.add(algorithm2ProgressBar);
        mainBox.add(algorithm2Box);
        mainBox.add(algorithm2ElapsedTimeBox);

        add(mainBox);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void setProgress(String algorithmName,int progress){
        switch (algorithmName){
            case "Algorithme 1":
                algorithm1ProgressBar.setValue(progress);
                break;
            case "Algorithme 2":
                algorithm2ProgressBar.setValue(progress);
                break;
        }
    }
    public void setResult(String algorithmName, boolean prime, long elapsedTime){
        String text = "Le nombre ";
        switch (algorithmName){
            case "Algorithme 1":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm1ProgressBar.setString(text);
                algorithm1ElapsedTimeLabel.setText(String.format("Temps écoulé : %.4f", elapsedTime/1000.0));
                break;
            case "Algorithme 2":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm2ProgressBar.setString(text);
                algorithm2ElapsedTimeLabel.setText(String.format("Temps écoulé : %.4f", elapsedTime/1000.0));
                break;
        }
    }
    public void start(double number){
        setTitle(String.format("%.0f", number));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        PrimeNumberAlgorithm algorithm1 = new PrimeNumberAlgorithm1(number, this);
        executor.submit(algorithm1);
        PrimeNumberAlgorithm algorithm2 = new PrimeNumberAlgorithm2(number, this);
        executor.submit(algorithm2);
        executor.shutdown();
    }
}

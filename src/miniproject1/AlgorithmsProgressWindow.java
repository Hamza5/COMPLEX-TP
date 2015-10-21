package miniproject1;

import miniproject1.prime.*;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AlgorithmsProgressWindow extends JFrame {
    JProgressBar algorithm1ProgressBar;
    JProgressBar algorithm2ProgressBar;
    JProgressBar algorithm3ProgressBar;
    JProgressBar algorithm4ProgressBar;
    JProgressBar algorithm5ProgressBar;
    JProgressBar algorithm6ProgressBar;
    JProgressBar totalProgressBar;
    JLabel algorithm1ElapsedTimeLabel;
    JLabel algorithm2ElapsedTimeLabel;
    JLabel algorithm3ElapsedTimeLabel;
    JLabel algorithm4ElapsedTimeLabel;
    JLabel algorithm5ElapsedTimeLabel;
    JLabel algorithm6ElapsedTimeLabel;
    AlgorithmsProgressWindow() {
        super();
        Box mainBox =  Box.createVerticalBox();
        mainBox.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        totalProgressBar = new JProgressBar();
        totalProgressBar.setStringPainted(true);
        Box totalProgressBox = Box.createHorizontalBox();
        totalProgressBox.add(totalProgressBar);
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(totalProgressBar);
        mainBox.add(Box.createVerticalStrut(10));

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

        Box algorithm3Box = Box.createHorizontalBox();
        algorithm3Box.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JLabel algorithm3Label = new JLabel("Algorithme 3");
        algorithm3Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        algorithm3ProgressBar = new JProgressBar();
        algorithm3ProgressBar.setStringPainted(true);
        algorithm3ProgressBar.setPreferredSize(new Dimension(300, algorithm3ProgressBar.getPreferredSize().height));
        algorithm3ElapsedTimeLabel = new JLabel("...");
        Box algorithm3ElapsedTimeBox = Box.createHorizontalBox();
        algorithm3ElapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        algorithm3ElapsedTimeBox.add(algorithm3ElapsedTimeLabel);
        algorithm3Box.add(algorithm3Label);
        algorithm3Box.add(algorithm3ProgressBar);
        mainBox.add(algorithm3Box);
        mainBox.add(algorithm3ElapsedTimeBox);

        Box algorithm4Box = Box.createHorizontalBox();
        algorithm4Box.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JLabel algorithm4Label = new JLabel("Algorithme 4");
        algorithm4Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        algorithm4ProgressBar = new JProgressBar();
        algorithm4ProgressBar.setStringPainted(true);
        algorithm4ProgressBar.setPreferredSize(new Dimension(300, algorithm4ProgressBar.getPreferredSize().height));
        algorithm4ElapsedTimeLabel = new JLabel("...");
        Box algorithm4ElapsedTimeBox = Box.createHorizontalBox();
        algorithm4ElapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        algorithm4ElapsedTimeBox.add(algorithm4ElapsedTimeLabel);
        algorithm4Box.add(algorithm4Label);
        algorithm4Box.add(algorithm4ProgressBar);
        mainBox.add(algorithm4Box);
        mainBox.add(algorithm4ElapsedTimeBox);

        Box algorithm5Box = Box.createHorizontalBox();
        algorithm5Box.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JLabel algorithm5Label = new JLabel("Algorithme 5");
        algorithm5Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        algorithm5ProgressBar = new JProgressBar();
        algorithm5ProgressBar.setStringPainted(true);
        algorithm5ProgressBar.setPreferredSize(new Dimension(300, algorithm5ProgressBar.getPreferredSize().height));
        algorithm5ElapsedTimeLabel = new JLabel("...");
        Box algorithm5ElapsedTimeBox = Box.createHorizontalBox();
        algorithm5ElapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        algorithm5ElapsedTimeBox.add(algorithm5ElapsedTimeLabel);
        algorithm5Box.add(algorithm5Label);
        algorithm5Box.add(algorithm5ProgressBar);
        mainBox.add(algorithm5Box);
        mainBox.add(algorithm5ElapsedTimeBox);

        Box algorithm6Box = Box.createHorizontalBox();
        algorithm6Box.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        JLabel algorithm6Label = new JLabel("Algorithme 6");
        algorithm6Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        algorithm6ProgressBar = new JProgressBar();
        algorithm6ProgressBar.setStringPainted(true);
        algorithm6ProgressBar.setPreferredSize(new Dimension(300, algorithm6ProgressBar.getPreferredSize().height));
        algorithm6ElapsedTimeLabel = new JLabel("...");
        Box algorithm6ElapsedTimeBox = Box.createHorizontalBox();
        algorithm6ElapsedTimeBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        algorithm6ElapsedTimeBox.add(algorithm6ElapsedTimeLabel);
        algorithm6Box.add(algorithm6Label);
        algorithm6Box.add(algorithm6ProgressBar);
        mainBox.add(algorithm6Box);
        mainBox.add(algorithm6ElapsedTimeBox);

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
            case "Algorithme 3":
                algorithm3ProgressBar.setValue(progress);
                break;
            case "Algorithme 4":
                algorithm4ProgressBar.setValue(progress);
                break;
            case "Algorithme 5":
                algorithm5ProgressBar.setValue(progress);
                break;
            case "Algorithme 6":
                algorithm6ProgressBar.setValue(progress);
                break;
        }
    }
    public void setResult(String algorithmName, boolean prime, long elapsedTime){
        String text = "Le nombre ";
        final String resultMessageFormat = "Temps écoulé : %.3f second%s";
        switch (algorithmName){
            case "Algorithme 1":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm1ProgressBar.setString(text);
                algorithm1ProgressBar.setValue(100);
                algorithm1ElapsedTimeLabel.setText(String.format(resultMessageFormat, elapsedTime/1000.0, elapsedTime < 2000 ? "" : "s"));
                break;
            case "Algorithme 2":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm2ProgressBar.setString(text);
                algorithm2ProgressBar.setValue(100);
                algorithm2ElapsedTimeLabel.setText(String.format(resultMessageFormat, elapsedTime/1000.0, elapsedTime < 2000 ? "" : "s"));
                break;
            case "Algorithme 3":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm3ProgressBar.setString(text);
                algorithm3ProgressBar.setValue(100);
                algorithm3ElapsedTimeLabel.setText(String.format(resultMessageFormat, elapsedTime/1000.0, elapsedTime < 2000 ? "" : "s"));
                break;
            case "Algorithme 4":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm4ProgressBar.setString(text);
                algorithm4ProgressBar.setValue(100);
                algorithm4ElapsedTimeLabel.setText(String.format(resultMessageFormat, elapsedTime/1000.0, elapsedTime < 2000 ? "" : "s"));
                break;
            case "Algorithme 5":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm5ProgressBar.setString(text);
                algorithm5ProgressBar.setValue(100);
                algorithm5ElapsedTimeLabel.setText(String.format(resultMessageFormat, elapsedTime/1000.0, elapsedTime < 2000 ? "" : "s"));
                break;
            case "Algorithme 6":
                text += prime ? "est premier" : "n'est pas premier";
                algorithm6ProgressBar.setString(text);
                algorithm6ProgressBar.setValue(100);
                algorithm6ElapsedTimeLabel.setText(String.format(resultMessageFormat, elapsedTime/1000.0, elapsedTime < 2000 ? "" : "s"));
                break;
        }
    }
    public ExecutorService start(long number){
        setTitle(String.format("Teste de la primalité de %d", number));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        PrimeNumberAlgorithm algorithm1 = new PrimeNumberAlgorithm1(number, this);
        executor.submit(algorithm1);
        PrimeNumberAlgorithm algorithm2 = new PrimeNumberAlgorithm2(number, this);
        executor.submit(algorithm2);
        PrimeNumberAlgorithm algorithm3 = new PrimeNumberAlgorithm3(number, this);
        executor.submit(algorithm3);
        PrimeNumberAlgorithm algorithm4 = new PrimeNumberAlgorithm4(number, this);
        executor.submit(algorithm4);
        PrimeNumberAlgorithm algorithm5 = new PrimeNumberAlgorithm5(number, this);
        executor.submit(algorithm5);
        PrimeNumberAlgorithm algorithm6 = new PrimeNumberAlgorithm6(number, this);
        executor.submit(algorithm6);
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    logFileWriter.close();
//                } catch (IOException e) {
//                    System.err.println("Impossible de fermer le fchier des résultats !");
//                }
//            }
//        });
        executor.shutdown();
        return executor;
    }
    public void start(final ArrayList<Long> numbers){
        final int tasksCount = numbers.size();
        totalProgressBar.setMaximum(tasksCount);
        final AlgorithmsProgressWindow progressWindow = this;
        (new Thread(){
            @Override
            public void run() {
                try{
                    for(long number : numbers){
                        SwingUtilities.invokeAndWait(new Runnable() {
                            @Override
                            public void run() {
                                resetAll();
                                int newValue = totalProgressBar.getValue() + 1;
                                totalProgressBar.setValue(newValue);
                                totalProgressBar.setString(String.format("Nombre %d sur %d", newValue, tasksCount));
                            }
                        });
                        ExecutorService executor = progressWindow.start(number);
                        executor.awaitTermination(1, TimeUnit.DAYS);
                        Thread.sleep(1000);
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            totalProgressBar.setString("Terminé");
                            setTitle("Teste de primalité terminé");
                            resetAll();
                        }
                    });
                } catch(InterruptedException | InvocationTargetException ex){
                    ex.printStackTrace();
                }
            }
        }).start();
    }
    public void resetAll(){
        algorithm1ProgressBar.setString(null);
        algorithm1ProgressBar.setValue(0);
        algorithm1ElapsedTimeLabel.setText("...");

        algorithm2ProgressBar.setString(null);
        algorithm2ProgressBar.setValue(0);
        algorithm2ElapsedTimeLabel.setText("...");

        algorithm3ProgressBar.setString(null);
        algorithm3ProgressBar.setValue(0);
        algorithm3ElapsedTimeLabel.setText("...");

        algorithm4ProgressBar.setString(null);
        algorithm4ProgressBar.setValue(0);
        algorithm4ElapsedTimeLabel.setText("...");

        algorithm5ProgressBar.setString(null);
        algorithm5ProgressBar.setValue(0);
        algorithm5ElapsedTimeLabel.setText("...");

        algorithm6ProgressBar.setString(null);
        algorithm6ProgressBar.setValue(0);
        algorithm6ElapsedTimeLabel.setText("...");
    }
}
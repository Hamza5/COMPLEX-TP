package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

abstract public class SortAlgorithm extends SwingWorker<Void, Void> implements PropertyChangeListener{

    protected String name;
    protected AlgorithmsProgressWindow progressWindow;
    protected long startTime;
    protected long endTime;
    protected FileWriter logFileWriter;
    protected boolean worstCase;
    protected int[] numbers;
    protected int inf;
    protected int sup;
    protected ArrayList<Integer> stopValues;

    SortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues){
        super();
        this.numbers = numbers;
        this.progressWindow = progressWindow;
        this.worstCase = worstCase;
        this.inf = numbers[0];
        this.sup = numbers[numbers.length-1];
        this.stopValues = new ArrayList<>();
        for (int i : stopValues) this.stopValues.add(i);
        addPropertyChangeListener(this);
        setProgress(0);
    }

    protected abstract void doOperation();

    protected void doBefore(){
        try {
            logFileWriter = new FileWriter(String.format("%s %s %d-%d.txt", name, worstCase ? "pire" : "meilleur", inf, sup), true);
            try {
                Calendar now = Calendar.getInstance();
                logFileWriter.write(String.format("---------- Début : %tF %tT ----------%n", now, now));
                try {
                    logFileWriter.close();
                    startTime = System.currentTimeMillis();
                } catch (IOException ex) {
                    System.err.println("Erreur lors de la fermeture du fichier !");
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de l'écriture dans le fichier !");
            }
        } catch (IOException ex){
            System.err.println("Impossible de créer le fchier des résultats !");
        }
    }

    protected void doAfter(){
        endTime = System.currentTimeMillis();
        try {
            Calendar now = Calendar.getInstance();
            logFileWriter = new FileWriter(String.format("%s %s %d-%d.txt", name, worstCase ? "pire" : "meilleur", inf, sup), true);
            float time = (endTime - startTime)/1000f;
            logFileWriter.write(String.format("---------- Fin : %tF %tT - Temps écoulé : %.3f seconde%s ----------%n%n", now, now, time, time < 2000 ? "" : "s" ));
            try {
                logFileWriter.close();
            } catch (IOException ex) {
                System.err.println("Erreur lors de la fermeture du fichier !");
            }
        } catch (IOException ex) {
            System.err.println("Erreur lors de l'écriture dans le fichier !");
        }
    }

    @Override
    protected void done(){
        try {
            get();
        } catch (ExecutionException e) {
            String[] stackTraces = Arrays.deepToString(e.getCause().getStackTrace()).split(", ");
            StringBuilder sb = new StringBuilder(e.toString()+'\n');
            for(String s : stackTraces) {
                sb.append(s);
                sb.append('\n');
            }
            JOptionPane.showMessageDialog(progressWindow,sb.toString() , "Erreur dans le thread de calcul", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            System.err.println("Worker thread interrupted"); // This should never happen
        }
        progressWindow.dispatchEvent(new WindowEvent(progressWindow, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    protected final Void doInBackground(){
        doBefore();
        doOperation();
        doAfter();
        return null;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("progress")){
            int progress = (int)evt.getNewValue();
            if (progress != (int)evt.getOldValue()){
                progressWindow.setProgress(progress);
                if (!isDone()){
                    try {
                        endTime = System.currentTimeMillis();
                        logFileWriter = new FileWriter(String.format("%s %s %d-%d.txt", name, worstCase ? "pire" : "meilleur", inf, sup), true);
                        float time = (endTime - startTime)/1000f;
                        logFileWriter.write(String.format("Progression : %d - Temps écoulé : %.3f seconde%s%n", progress, time, time < 2 ? "" : "s" ));
                        logFileWriter.close();
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'écriture dans le fichier !");
                    }
                }
            }
        }
    }
    protected void logIntermediateNumber(int i){
        try {
            endTime = System.currentTimeMillis();
            logFileWriter = new FileWriter(String.format("%s %s %d-%d.txt", name, worstCase ? "pire" : "meilleur", inf, sup), true);
            float time = (endTime - startTime)/1000f;
            logFileWriter.write(String.format("Nombre : %d - Temps écoulé : %.3f seconde%s%n", i, time, time < 2 ? "" : "s" ));
            logFileWriter.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier !");
        }
    }

	public void sort() {
		// TODO Auto-generated method stub
		
	}
}

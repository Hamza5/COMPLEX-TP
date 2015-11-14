package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

abstract public class SortAlgorithm extends SwingWorker<Void, Void> implements PropertyChangeListener{

    protected String name;
    protected AlgorithmsProgressWindow progressWindow;
    protected long elapsedTime;
    protected FileWriter logFileWriter;
    protected boolean worstCase;
    protected int[] numbers;

    SortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow){
        super();
        this.numbers = numbers;
        this.progressWindow = progressWindow;
        this.worstCase = worstCase;
        addPropertyChangeListener(this);
        setProgress(0);
    }

    protected abstract void doOperation();

    protected void doBefore(){
        try {
            logFileWriter = new FileWriter(String.format("%s %d %s.txt", name, numbers.length, worstCase ? "pire" : "meilleur"), true);
            try {
                Calendar now = Calendar.getInstance();
                logFileWriter.write(String.format("---------- Début : %tF %tT ----------%n", now, now));
                try {
                    logFileWriter.close();
                    elapsedTime = System.currentTimeMillis();
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
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        try {
            Calendar now = Calendar.getInstance();
            logFileWriter = new FileWriter(String.format("%s %d %s.txt", name, numbers.length, worstCase ? "pire" : "meilleur"), true);
            logFileWriter.write(String.format("---------- Fin : %tF %tT - Temps écoulé : %.3f second%s ----------%n%n", now, now, elapsedTime/1000f, elapsedTime < 2000 ? "" : "s" ));
            try {
                logFileWriter.close();
            } catch (IOException ex) {
                System.err.println("Erreur lors de la fermeture du fichier !");
            }
        } catch (IOException ex) {
            System.err.println("Erreur lors d'écrir dans le fichier !");
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
//            if (evt.getOldValue() != evt.getNewValue())
//                System.out.println(evt.getNewValue());
            progressWindow.setProgress((int)evt.getNewValue());
        }
    }
}

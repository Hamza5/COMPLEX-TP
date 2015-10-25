package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

abstract public class PrimeNumberAlgorithm extends SwingWorker<Boolean, Long> implements PropertyChangeListener{
    protected boolean prime;
    protected long number;
    protected String name;
    protected AlgorithmsProgressWindow progressWindow;
    protected long elapsedTime;
    protected FileWriter logFileWriter;
    protected int order;
    PrimeNumberAlgorithm(long number, AlgorithmsProgressWindow progressWindow){
        super();
        this.prime = true;
        this.number = number;
        this.progressWindow = progressWindow;
        addPropertyChangeListener(this);
        setProgress(0);
    }
    @Override
    protected Boolean doInBackground(){
        try {
            logFileWriter = new FileWriter(String.format("Nombre_%d_log.txt", number), true);
            try {
                Calendar now = Calendar.getInstance();
                logFileWriter.write(String.format("----------%s----------%nDébut : %tF %tT%n", name, now, now));
            } catch (IOException e) {
                System.err.println("Erreur lors de l'écrir dans le fichier !");
            }
        } catch (IOException ex){
            System.err.println("Impossible de créer le fchier des résultats !");
        }
        return null;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    protected void done(){
        setProgress(100);
        progressWindow.setResult(name, prime, elapsedTime);
        progressWindow.addExecutionTime(order, elapsedTime);
        try {
            Calendar now = Calendar.getInstance();
            logFileWriter.write(String.format("Fin : %tF %tT - Temps écoulé : %.3f second%s%n%n", now, now, elapsedTime/1000f, elapsedTime < 2000 ? "" : "s" ));
            try {
                logFileWriter.close();
            } catch (IOException ex){
                System.err.println("Erreur lors de la fermeture du fichier !");
            }
        } catch (IOException ex) {
            System.err.println("Erreur lors d'écrir dans le fichier !");
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("progress")){
            int progress = (int)evt.getNewValue();
            if (progress != (int)evt.getOldValue()){
                progressWindow.setProgress(name, progress);
            }
        }
    }
}

package miniproject1.prime;

import javax.swing.SwingWorker;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import miniproject1.AlgorithmsProgressWindow;

abstract public class PrimeNumberAlgorithm extends SwingWorker<Boolean, Double> implements PropertyChangeListener{
    protected boolean prime;
    protected double number;
    protected String name;
    protected AlgorithmsProgressWindow progressWindow;
    protected long elapsedTime;
    PrimeNumberAlgorithm(double number, AlgorithmsProgressWindow progressWindow){
        super();
        this.prime = true;
        this.number = number;
        this.progressWindow = progressWindow;
        addPropertyChangeListener(this);
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    protected void done(){
        setProgress(100);
        progressWindow.setResult(name, prime, elapsedTime);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("progress")){
            progressWindow.setProgress(name, (int)evt.getNewValue());
        }
    }
}

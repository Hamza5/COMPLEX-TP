package miniproject3.coloring;

import miniproject3.MainWindow;
import miniproject3.SolutionDialog;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public abstract class ColoringAlgorithm extends SwingWorker<Void, Void> implements PropertyChangeListener{
    protected int[][] adjacency;
    protected String[] colors;
    protected String name;
    protected long startTime;
    protected long endTime;
    protected String[] solution;
    protected long progress;
    protected long max;
    private MainWindow parentWindow;
    public ColoringAlgorithm(int[][] matrix, String[] colorsNames, MainWindow window){
        super();
        adjacency = matrix;
        colors = colorsNames;
        parentWindow = window;
        progress = 0;
        window.setProgress(0);
        addPropertyChangeListener(this);
    }
    protected boolean validate(String[] verticesColors){
        for (int i=0; i<adjacency.length-1; i++){
            for (int j=i+1; j<adjacency[0].length; j++){
                if ((adjacency[i][j] > 0 || adjacency[j][i] > 0) && verticesColors[i].equals(verticesColors[j])) return false;
            }
        }
        return true;
    }
    @Override
    protected Void doInBackground(){
        doBefore();
        doOperation();
        doAfter();
        return null;
    }
    protected void doAfter(){
        endTime = System.currentTimeMillis();
    }
    protected void doBefore(){
        startTime = System.currentTimeMillis();
    }
    protected abstract void doOperation();
    @Override
    public String toString(){
        return name;
    }
    @Override
    protected void done(){
        String algorithm = parentWindow.getMethod();
        float elapsedTime = (endTime - startTime)/(float)1000;
        SolutionDialog solutionDialog = new SolutionDialog(parentWindow, "Solution", algorithm, elapsedTime, solution != null ? Arrays.toString(solution) : "Aucune solution trouvée");
        parentWindow.enableCalculationButton(true);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if (evt.getPropertyName().equals("progress")) {
            int progress = (int)evt.getNewValue();
            if ((int)evt.getOldValue() != progress) {
                parentWindow.setProgress(progress);
            }
        }
    }
}

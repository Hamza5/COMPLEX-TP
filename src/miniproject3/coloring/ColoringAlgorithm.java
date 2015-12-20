package miniproject3.coloring;

import miniproject3.MainWindow;
import miniproject3.SolutionDialog;

import javax.swing.*;
import java.util.Arrays;

public abstract class ColoringAlgorithm extends Thread {
    protected int[][] adjacency;
    protected String[] colors;
    protected String name;
    protected long startTime;
    protected long endTime;
    protected String[] solution;
    private MainWindow parentWindow;
    public ColoringAlgorithm(int[][] matrix, String[] colorsNames, MainWindow window){
        super();
        adjacency = matrix;
        colors = colorsNames;
        parentWindow = window;
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
    public final void run(){
        doBefore();
        doOperation();
        doAfter();
    }
    protected void doAfter(){
        endTime = System.currentTimeMillis();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String algorithm = parentWindow.getMethod();
                float elapsedTime = (endTime - startTime)/(float)1000;
                SolutionDialog solutionDialog = new SolutionDialog(parentWindow, "Solution", algorithm, elapsedTime, Arrays.toString(solution));
                parentWindow.enableCalculationButton(true);
            }
        });
    }
    protected void doBefore(){
        startTime = System.currentTimeMillis();
    }
    protected abstract void doOperation();
    @Override
    public String toString(){
        return name;
    }
}

package miniproject3.coloring;

import miniproject3.MainWindow;

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
        for (int i=0; i<adjacency.length; i++){
            for (int j=0; j<adjacency[0].length; j++){
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
        float elapsedTime = (endTime - startTime)/(float)1000;
        final String message = String.format("Algorithme : %s - Temps écoulé : %.3f seconde%s%n", name, elapsedTime, elapsedTime > 1 ? "s" : "")
        + (solution != null ? String.format("Solution trouvée : %s%n", Arrays.toString(solution)) : "Aucune solution trouvée");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(parentWindow, message, "Résultat", JOptionPane.INFORMATION_MESSAGE);
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

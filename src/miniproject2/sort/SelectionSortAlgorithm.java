package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class SelectionSortAlgorithm extends SortAlgorithm {

    public SelectionSortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri par sélection";
    }

    @Override
    protected void doOperation() {
        int progress = 0;
        for(int i = 0; i < numbers.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < numbers.length; j++){
                if(numbers[j] < numbers[min]) min = j;
            }
            int x = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = x;
            setProgress(Float.valueOf( ++progress / ((float)numbers.length-1) * 100 ).intValue());
            if (stopValues.contains(i)) { // Pour sauvegarder les résultats des nombres intermédiaires
                logIntermediateNumber(i);
            }
        }
    }
}

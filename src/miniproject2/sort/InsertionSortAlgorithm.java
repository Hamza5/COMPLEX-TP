package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class InsertionSortAlgorithm extends SortAlgorithm{
    public InsertionSortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri par insertion";
    }

    @Override
    protected void doOperation() {
        long progress = 0;
        for (int i=0; i<numbers.length; i++){
            int j;
            int x = numbers[i];
            for (j = i; j > 0 && numbers[j-1] > x; j--){
                numbers[j] = numbers[j-1];
            }
            numbers[j] = x;
            setProgress(Float.valueOf(++progress / ((float)numbers.length) * 100 ).intValue());
            if (stopValues.contains(i)) { // Pour sauvegarder les temps d'exécutions des nombres intermédiaires
                logIntermediateNumber(i);
            }
        }
    }
}

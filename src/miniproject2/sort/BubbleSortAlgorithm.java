package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class BubbleSortAlgorithm extends SortAlgorithm {

    public BubbleSortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow) {
        super(numbers, worstCase, progressWindow);
        name = "Tri à bulles";
    }

    @Override
    protected void doOperation() {
        double progress = 0;
        for(int i = 0; i < numbers.length - 1; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if(numbers[i] > numbers [j]){
                    int x = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = x;
                }
                setProgress(Double.valueOf( ++progress / ((double) (numbers.length-1) * (numbers.length-2) / 2) * 100 ).intValue());
            }
        }
    }

}

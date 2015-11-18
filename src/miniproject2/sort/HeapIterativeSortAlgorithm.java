package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class HeapIterativeSortAlgorithm extends SortAlgorithm {
    public HeapIterativeSortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri par tas itératif";
    }

    private void sink(int[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && pq[j] < pq[j+1]) j++;
            if (pq[k] >= pq[j]) break;
            int x = pq[k];
            pq[k] = pq[j];
            pq[j] = x;
            k = j;
        }
    }

    @Override
    protected void doOperation() {
        int progress = 0;
        int N = numbers.length-1;
        for (int k = N/2; k >= 0; k--){
            sink(numbers, k, N);
            setProgress(Float.valueOf(++progress / (((float)numbers.length+1)/2 + numbers.length-1) * 100 ).intValue());
        }
        while (N > 0) {
            int x = numbers[0];
            numbers[0] = numbers[N];
            numbers[N] = x;
            N--;
            sink(numbers, 0, N);
            setProgress(Float.valueOf(++progress / (((float)numbers.length+1)/2 + numbers.length-1) * 100 ).intValue());
        }
    }

}

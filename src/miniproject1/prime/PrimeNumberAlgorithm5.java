package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

public class PrimeNumberAlgorithm5 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm5(long number,  AlgorithmsProgressWindow progressWindow) {
        super(number, progressWindow);
        name = "Algorithme 5";
    }
    @Override
    public Boolean doInBackground() {
        super.doInBackground();
        elapsedTime = System.currentTimeMillis();
        long i = 2;
        while(i <= Math.sqrt(number) && prime){
            setProgress(Double.valueOf(i / Math.sqrt(number) * 100).intValue());
            if(number % i == 0) prime = false;
            else i++;
        }
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return prime;
    }
}

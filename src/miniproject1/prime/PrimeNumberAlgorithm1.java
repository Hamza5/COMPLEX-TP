package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

public class PrimeNumberAlgorithm1 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm1(double number, AlgorithmsProgressWindow progressWindow) {
        super(number, progressWindow);
        name = "Algorithme 1";
    }
    @Override
    protected Boolean doInBackground() {
        elapsedTime = System.currentTimeMillis();
        double i = 2;
        while(i < number && prime){
            setProgress(Double.valueOf(Math.floor(i / number * 100)).intValue());
            if(number % i == 0) prime = false;
            else i++;
        }
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return prime;
    }
}

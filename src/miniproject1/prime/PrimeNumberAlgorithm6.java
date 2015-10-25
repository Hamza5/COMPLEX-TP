package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

public class PrimeNumberAlgorithm6 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm6(long number,  AlgorithmsProgressWindow progressWindow) {
        super(number, progressWindow);
        name = "Algorithme 6";
        order = 6;
    }
    @Override
    public Boolean doInBackground() {
        super.doInBackground();
        elapsedTime = System.currentTimeMillis();
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            long i = 3;
            while(i <= Math.sqrt(number) && prime){
                setProgress(Double.valueOf(i / Math.sqrt(number) * 100).intValue());
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return prime;
    }
}

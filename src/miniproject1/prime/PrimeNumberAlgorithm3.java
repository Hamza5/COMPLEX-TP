package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

public class PrimeNumberAlgorithm3 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm3(long number,  AlgorithmsProgressWindow progressWindow) {
        super(number, progressWindow);
        name = "Algorithme 3";
    }
    @Override
    public Boolean doInBackground() {
        super.doInBackground();
        elapsedTime = System.currentTimeMillis();
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            long i = 3;
            while(i < number-1 && prime){
                setProgress(Float.valueOf(i / (((float)number) - 1) * 100).intValue());
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return prime;
    }
}

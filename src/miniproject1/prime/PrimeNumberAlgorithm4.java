package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

public class PrimeNumberAlgorithm4 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm4(long number,  AlgorithmsProgressWindow progressWindow) {
        super(number, progressWindow);
        name = "Algorithme 4";
    }
    @Override
    public Boolean doInBackground() {
        super.doInBackground();
        elapsedTime = System.currentTimeMillis();
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            long i = 3;
            while(i <= number/2 && prime){
                setProgress(Float.valueOf(i / (((float)number) / 2) * 100).intValue());
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return prime;
    }
}

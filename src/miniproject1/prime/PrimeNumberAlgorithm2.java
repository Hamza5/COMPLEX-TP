package miniproject1.prime;

import miniproject1.AlgorithmsProgressWindow;

public class PrimeNumberAlgorithm2 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm2(double number, AlgorithmsProgressWindow progressWindow) {
        super(number, progressWindow);
        name = "Algorithme 2";
    }
    @Override
    public Boolean doInBackground() {
        elapsedTime = System.currentTimeMillis();
        double i = 2;
        while(i <= number/2 && prime){
            setProgress(Double.valueOf(Math.floor(i / (number / 2) * 100)).intValue());
            if(number % i == 0) prime = false;
            else i++;
        }
        elapsedTime = System.currentTimeMillis() - elapsedTime;
        return prime;
    }
}

package miniproject1.prime;

public class PrimeNumberAlgorithm2 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm2(double number) {
        super(number);
        name = "Algorithme 2";
    }
    @Override
    public void run() {
        double i = 2;
        while(i <= number/2 && prime){
            if(number % i == 0) prime = false;
            else i++;
        }
        executed = true;
    }
}

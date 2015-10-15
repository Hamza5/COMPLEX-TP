package miniproject1.prime;

public class PrimeNumberAlgorithm1 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm1(double number) {
        super(number);
        name = "Algorithme 1";
    }
    @Override
    public void run() {
        double i = 2;
        while(i < number && prime){
            if(number % i == 0) prime = false;
            else i++;
        }
        executed = true;
    }
}

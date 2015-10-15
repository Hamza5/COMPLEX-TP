package miniproject1.prime;

public class PrimeNumberAlgorithm5 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm5(double number) {
        super(number);
        name = "Algorithme 5";
    }
    @Override
    public void run() {
        double i = 2;
        while(i <= Math.sqrt(number) && prime){
            if(number % i == 0) prime = false;
            else i++;
        }
        executed = true;
    }
}

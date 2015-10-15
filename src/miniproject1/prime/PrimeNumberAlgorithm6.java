package miniproject1.prime;

public class PrimeNumberAlgorithm6 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm6(double number) {
        super(number);
        name = "Algorithme 6";
    }
    @Override
    public void run() {
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            double i = 3;
            while(i <= Math.sqrt(number) && prime){
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        executed = true;
    }
}

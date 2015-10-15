package miniproject1.prime;

public class PrimeNumberAlgorithm4 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm4(double number) {
        super(number);
        name = "Algorithme 4";
    }
    @Override
    public void run() {
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            double i = 3;
            while(i <= number/2 && prime){
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        executed = true;
    }
}

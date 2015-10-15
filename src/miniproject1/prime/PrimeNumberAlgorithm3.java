package miniproject1.prime;

public class PrimeNumberAlgorithm3 extends PrimeNumberAlgorithm {
    public PrimeNumberAlgorithm3(double number) {
        super(number);
        name = "Algorithme 3";
    }
    @Override
    public void run() {
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            double i = 3;
            while(i < number-1 && prime){
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        executed = true;
    }
}

package miniproject1.prime;

abstract public class PrimeNumberAlgorithm implements Runnable{
    protected boolean prime;
    protected boolean executed;
    protected double number;
    protected String name;
    PrimeNumberAlgorithm(double number){
        super();
        this.prime = true;
        this.executed = false;
        this.number = number;
    }
    public boolean isPrime(){
        if(!executed) run();
        return prime;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
}

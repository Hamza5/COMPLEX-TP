package miniproject1;

import miniproject1.prime.*;
public class Main {
	public static void main(String[] args){
        try{
            if(args.length != 1) throw new IllegalArgumentException();
            double number = Double.parseDouble(args[0]);
            if(number < 0) throw new NumberFormatException();
            System.out.printf("Nombre = %d%n", Double.valueOf(number).intValue());
            System.out.println("Lancement des algorithmes...");
            printExecutionTime(new PrimeNumberAlgorithm1(number));
            printExecutionTime(new PrimeNumberAlgorithm2(number));
            printExecutionTime(new PrimeNumberAlgorithm3(number));
            printExecutionTime(new PrimeNumberAlgorithm4(number));
            printExecutionTime(new PrimeNumberAlgorithm5(number));
            printExecutionTime(new PrimeNumberAlgorithm6(number));
        } catch(IllegalArgumentException ex){
            System.err.printf("Usage : java %s <entier_positif>%n", "Main");
            System.exit(1);
        }
	}
    private static void printExecutionTime(PrimeNumberAlgorithm algorithm){
        System.out.println(algorithm.getName());
        long start = System.currentTimeMillis();
        algorithm.run();
        long end = System.currentTimeMillis();
        System.out.printf("Le temps d'exécution : %f second(s) résultat = %s %n", (end - start)/1000f, algorithm.isPrime());
    }
}
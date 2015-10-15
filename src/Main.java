public class Main {
	public static void main(String[] args){
    try{
        if(args.length != 1) throw new IllegalArgumentException();
        double number = Double.parseDouble(args[0]);
        if(number < 0) throw new NumberFormatException();
        System.out.printf("Nombre = %d%n", Double.valueOf(number).intValue());
        System.out.println("Lancement des algorithmes...");
        long start = System.currentTimeMillis();
        boolean result = PrimeNumbersAlgorithms.algorithm1(number);
        long end = System.currentTimeMillis();
        showExecutionTime(start, end, "Algorithme 1 : "+result);
        start = System.currentTimeMillis();
        result = PrimeNumbersAlgorithms.algorithm2(number);
        end = System.currentTimeMillis();
        showExecutionTime(start, end, "Algorithme 2 : "+result);
        start = System.currentTimeMillis();
        result =PrimeNumbersAlgorithms.algorithm3(number);
        end = System.currentTimeMillis();
        showExecutionTime(start, end, "Algorithme 3 : "+result);
        start = System.currentTimeMillis();
        result = PrimeNumbersAlgorithms.algorithm4(number);
        end = System.currentTimeMillis();
        showExecutionTime(start, end, "Algorithme 4 : "+result);
        start = System.currentTimeMillis();
        result = PrimeNumbersAlgorithms.algorithm5(number);
        end = System.currentTimeMillis();
        showExecutionTime(start, end, "Algorithme 5 : "+result);
        start = System.currentTimeMillis();
        result = PrimeNumbersAlgorithms.algorithm6(number);
        end = System.currentTimeMillis();
        showExecutionTime(start, end, "Algorithme 6 : "+result);
    } catch(IllegalArgumentException ex){
        System.err.printf("Usage : java %s <entier_positif>%n", "Main");
        System.exit(1);
    }
	}
    private static void showExecutionTime(long start, long end, String message){
        System.out.println(message);
        System.out.printf("Le temps d'exécution : %f second(s)%n", (end - start)/1000f);
    }
}
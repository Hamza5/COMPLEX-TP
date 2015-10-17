package miniproject1;

import javax.swing.SwingUtilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        try {
            FileReader fileReader;
            try {
                if (args.length != 1) throw new IllegalArgumentException();
                final long number = Long.parseLong(args[0]);
                if (number < 0) throw new NumberFormatException();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AlgorithmsProgressWindow progressWindow = new AlgorithmsProgressWindow();
                        progressWindow.start(number);
                    }
                });
            } catch (NumberFormatException ex) {
                fileReader = new FileReader(args[0]);
                final ArrayList<Long> numbers = new ArrayList<>();
                Scanner numbersReader = new Scanner(fileReader);
                while(numbersReader.hasNextLong()){
                    long number = numbersReader.nextLong();
                    if(number < 0) throw new NumberFormatException();
                    numbers.add(number);
                }
                fileReader.close();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AlgorithmsProgressWindow progressWindow = new AlgorithmsProgressWindow();
                        progressWindow.start(numbers);
                    }
                });
            }
        } catch(NumberFormatException ex){
            System.err.printf("Le fichier %s doit contenir que des entiers positifs !%n", args[0]);
            System.exit(3);
        } catch(IllegalArgumentException ex){
            System.err.printf("Usage : java %s (<entier_positif> | <fichier_entiers_positifs>)%n", "Main");
            System.exit(1);
        } catch(IOException ex){
            System.err.printf("Le fichier %s n'existe pas !%n", args[0]);
            System.exit(2);
        }
	}
}
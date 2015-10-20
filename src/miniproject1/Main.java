package miniproject1;

import javax.swing.SwingUtilities;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        try {
            if (args.length != 1) throw new IllegalArgumentException();
            else {
                try {
                    File numbersFile = new File(args[0]);
                    if (numbersFile.exists()) {
                        FileReader fileReader = new FileReader(numbersFile);
                        final ArrayList<Long> numbers = new ArrayList<>();
                        Scanner numbersReader = new Scanner(fileReader);
                        while (numbersReader.hasNextLong()) {
                            long number = numbersReader.nextLong();
                            if (number < 0) throw new NumberFormatException();
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
                    } else {
                        try {
                            final long number = Long.parseLong(args[0]);
                            if (number < 0) throw new NumberFormatException();
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    AlgorithmsProgressWindow progressWindow = new AlgorithmsProgressWindow();
                                    progressWindow.start(number);
                                }
                            });
                        } catch(NumberFormatException ex){
                            System.err.println("Les entiers  doivent êtrepositifs !");
                            System.exit(3);
                        }
                    }
                } catch(IOException ex){
                    System.err.printf("Erreur lors de l'utilisation ddu fichier %s !%n", args[0]);
                    System.exit(2);
                }
            }
        } catch(IllegalArgumentException ex){
            System.err.printf("Usage : java %s (<entier_positif> | <fichier_entiers_positifs>)%n", "Main");
            System.exit(1);
        }
	}
}
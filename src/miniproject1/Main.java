package miniproject1;

import miniproject1.prime.*;

import javax.swing.*;

public class Main {
	public static void main(String[] args){
        try{
            if(args.length != 1) throw new IllegalArgumentException();
            final double number = Double.parseDouble(args[0]);
            if(number < 0) throw new NumberFormatException();
            System.out.printf("Nombre = %d%n", Double.valueOf(number).intValue());
            System.out.println("Lancement des algorithmes...");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AlgorithmsProgressWindow progressWindow = new AlgorithmsProgressWindow();
                    progressWindow.start(number);
                }
            });
        } catch(IllegalArgumentException ex){
            System.err.printf("Usage : java %s <entier_positif>%n", "Main");
            System.exit(1);
        }
	}
}
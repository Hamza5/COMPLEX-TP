package miniproject3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args){
        try {
            if (args.length > 2){
                Scanner file = new Scanner(new FileReader(args[0]));
                ArrayList<String> lines = new ArrayList<>();
                while (file.hasNextLine()){
                    lines.add(file.nextLine());
                }
                int[][] vertices = new int[lines.size()][lines.size()];
                for (int i = 0; i < vertices.length; i++){
                    Scanner data = new Scanner(lines.get(i));
                    for (int j = 0; j < vertices[0].length && data.hasNextInt(); j++){
                        vertices[i][j] = data.nextInt();
                    }
                }
                final StringBuilder colors = new StringBuilder();
                for (int i=1; i<args.length; i++){
                    colors.append(args[i]);
                    colors.append("\n");
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        MainWindow window = new MainWindow();
                        window.setDataAndCalculate(args[0], colors.toString());
                    }
                });
            } else
                SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainWindow window = new MainWindow();
                    }
            });
        } catch (FileNotFoundException ex){
            System.err.printf("Le fichier %s ne peut pas être trouvée !%n", args[0]);
            System.exit(1);
        }
    }
}

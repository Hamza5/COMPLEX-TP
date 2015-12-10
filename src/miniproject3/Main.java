package miniproject3;

import miniproject3.coloring.ColoringAlgorithm;
import miniproject3.coloring.DepthFirstColoringAlgorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            try {
                if (args.length < 2) throw new IllegalArgumentException("Usage : miniproject3.Main <fichier_graphe> <Couleur_1> [<Couleur_i> ...]");
                try {
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
                    String[] colors = new String[args.length-1];
                    System.arraycopy(args, 1, colors, 0, colors.length);

                    // Algorithme profondeur d'abord
                    ColoringAlgorithm deepFirst = new DepthFirstColoringAlgorithm(vertices, colors);
                    deepFirst.start();

                    try {
                        deepFirst.join();
                    } catch (InterruptedException e) {
                        deepFirst.interrupt();
                        throw e;
                    }
                } catch (FileNotFoundException ex){
                    System.err.printf("Le fichier %s ne peut pas être trouvée !%n", args[0]);
                    throw ex;
                }
            }
            catch (IllegalArgumentException ex){
                System.err.println(ex.toString());
                throw ex;
            }
        } catch (Exception ex){
            System.exit(1);
        }
    }
}

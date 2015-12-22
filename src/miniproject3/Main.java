package miniproject3;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String header = "^#\\s*Graphe\\s*\\d+";
    private static final String simpleMatrixLine = "^(\\d+\\s+)*\\d+$";
    private static final String newFormatLine = "^\\d+\\s+\\d+(\\s+\\d+)?$";
    private static final String invalidLineMessage = "Le contenu de la ligne %d est invalide";

    public static void main(final String[] args){
        if (args.length > 2){
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
    }
    public static int[][] getFileContent(String path) throws FileNotFoundException, IndexOutOfBoundsException, NumberFormatException {
        Scanner file = new Scanner(new FileReader(path));
        ArrayList<String> lines = new ArrayList<>();
        int[][] vertices;
        String firstLine = file.nextLine();
        if (firstLine.matches(header)){
            String[] words = firstLine.split("\\s+");
            int vertexCount = Integer.parseInt(words[words.length-1]);
            int i = 2;
            while (file.hasNextLine()){
                String line = file.nextLine();
                if (line.matches(newFormatLine)){
                    lines.add(line);
                } else throw new NumberFormatException(String.format(invalidLineMessage, i));
                i++;
            }
            vertices = new int[vertexCount][vertexCount];
            for (i=0; i<lines.size(); i++){
                String[] line = lines.get(i).split("\\s+");
                int from = Integer.parseInt(line[0])-1;
                int to = Integer.parseInt(line[1])-1;
                int weight;
                if (line.length==3) weight = Integer.parseInt(line[2]);
                else weight = 1;
                vertices[from][to] = weight;
            }
        } else {
            if (firstLine.matches(simpleMatrixLine)) lines.add(firstLine);
            else throw new NumberFormatException(String.format(invalidLineMessage, 1));
            int i = 2;
            while (file.hasNextLine()){
                String line = file.nextLine();
                if (line.matches(simpleMatrixLine)) lines.add(line);
                else throw new NumberFormatException(String.format(invalidLineMessage, i));
                i++;
            }
            vertices = new int[lines.size()][lines.size()];
            for (i = 0; i < vertices.length; i++){
                Scanner data = new Scanner(lines.get(i));
                for (int j = 0; j < vertices[0].length && data.hasNextInt(); j++){
                    vertices[i][j] = data.nextInt();
                }
            }
        }
        return vertices;
    }
}

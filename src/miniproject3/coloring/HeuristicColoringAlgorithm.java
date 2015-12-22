package miniproject3.coloring;

import miniproject3.MainWindow;

public class HeuristicColoringAlgorithm extends ColoringAlgorithm{
    public HeuristicColoringAlgorithm(int[][] matrix, String[] colorsNames, MainWindow window){
        super(matrix, colorsNames, window);
        name = "Recherche Heuristique";
        max = (long) (Math.pow(colorsNames.length, matrix.length-1)+1);
    }

    @Override
    protected void doOperation() {
        heuristicDepthTree(new String[]{colors[0]});
    }

    private boolean heuristic(String[] currentColors){
        int j = currentColors.length-1;
        for (int i=j-1; i>=0; i--){
            if ((adjacency[i][j] > 0 || adjacency[j][i] > 0) && currentColors[i].equals(currentColors[j])) return false;
        }
        return true;
    }

    private boolean heuristicDepthTree(String[] verticesColors){
        boolean found;
        if (verticesColors.length == adjacency.length){
            // On n'a pas besoin de valider tout, car on est sûr que le coloriage des sommets précédents est correcte.
            found = heuristic(verticesColors);
            if(found) solution = verticesColors;
        } else {
            setProgress(Float.valueOf(++progress/(float)max*100).intValue());
            found = false;
            for (int i=0; i<colors.length && !found; i++){
                String[] currentColors = new String[verticesColors.length+1];
                System.arraycopy(verticesColors, 0, currentColors, 0, verticesColors.length);
                currentColors[verticesColors.length] = colors[i];
                if (heuristic(currentColors)) found = heuristicDepthTree(currentColors);
            }
        }
        return found;
    }
}

package miniproject3.coloring;

public class HeuristicColoringAlgorithm extends ColoringAlgorithm{
    public HeuristicColoringAlgorithm(int[][] matrix, String[] colorsNames){
        super(matrix, colorsNames);
        name = "Recherche Heuristique";
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
            found = validate(verticesColors);
            if(found) solution = verticesColors;
        } else {
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

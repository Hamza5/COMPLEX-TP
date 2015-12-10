package miniproject3.coloring;

public class DepthFirstColoringAlgorithm extends ColoringAlgorithm{

    public DepthFirstColoringAlgorithm(int[][] matrix, String[] colorsNames){
        super(matrix, colorsNames);
        name = "Profondeur d'abord";
    }

    @Override
    protected void doOperation() {
        depthTree(new String[]{colors[0]});
    }

    private boolean depthTree(String[] verticesColors){
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
                found = depthTree(currentColors);
            }
        }
        return found;
    }
}

package miniproject3.coloring;

import miniproject3.MainWindow;

public class DepthFirstColoringAlgorithm extends ColoringAlgorithm{

    public DepthFirstColoringAlgorithm(int[][] matrix, String[] colorsNames, MainWindow window){
        super(matrix, colorsNames, window);
        name = "Profondeur d'abord";
        max = (long) (Math.pow(colorsNames.length, matrix.length-1));
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
        setProgress(Float.valueOf(++progress/(float)max*100).intValue());
        return found;
    }
}

package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class FusionSortAlgorithm extends SortAlgorithm {

    public FusionSortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri par fusion";
    }
   
     void TFusion (int [] table, int Gauche, int Droite)
	 {
	 	int centre;
	 	if(Gauche<Droite)
	 	{
	 		centre = (Gauche+Droite)/2;
	 		TFusion(table, Gauche, centre);
	 		TFusion(table, centre+1, Droite);
	 		Fusion (table, Gauche, centre, Droite);
	 	}
	 }

	 void Fusion (int table[], int Gauche, int centre, int Droite)
	 {	int j = Gauche; 
	 	int k = centre+1; 
	 	int i = Gauche; 
	 	int [] TableAnc = (int[]) table.clone(); 
	 	while (j<= centre && k <= Droite)
	 	{   System.out.println("Droite "+Droite/(double)table.length*100);
	 	setProgress(Double.valueOf(Droite/(double)table.length*100).intValue());
	 		if(TableAnc[j] <= TableAnc[k]){table[i] = TableAnc[j];j++;}
	 		else{table[i] = TableAnc[k];k++;}
	 		i++;
	 	}
	 	if (i<=Droite)
	 	{
	 		while(j<=centre) {table[i]=TableAnc[j];i++;j++;}
	 		while(k<=Droite) {table[i]=TableAnc[k];i++;k++;}
	 	}
	 }
    @Override
    protected void doOperation() {
    	
    	 TFusion (numbers, 0, numbers.length-1);
    	 for(int i=0;i<numbers.length;i++){
    	        System.out.print(" "+numbers[i]);
    	        }
    }

}

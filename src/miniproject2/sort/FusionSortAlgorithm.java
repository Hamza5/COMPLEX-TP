package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class FusionSortAlgorithm extends SortAlgorithm {

    public FusionSortAlgorithm(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri par fusion récursif";
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
    int progress=0;
 	public  void Fusion(int []Tabtemp,int IndiceGauche,int Piv,int IndiceDroite){
		int tempIndex=0;
		int lowerIndex = IndiceGauche;
		int midIndex = Piv-1;
		int totalItems = IndiceDroite-lowerIndex+1;
		while(lowerIndex <= midIndex && Piv <= IndiceDroite){
			if((IndiceGauche/(double)numbers.length*100)>progress){
				progress=Double.valueOf(IndiceGauche/(double)numbers.length*100).intValue();
			setProgress(Double.valueOf(IndiceGauche/(double)numbers.length*100).intValue());}
			if(numbers[lowerIndex] < numbers[Piv]){
				Tabtemp[tempIndex++] = numbers[lowerIndex++];
			}else{
				Tabtemp[tempIndex++] = numbers[Piv++];
			}
		}
		
		while(lowerIndex <= midIndex){
			Tabtemp[tempIndex++] = numbers[lowerIndex++];
		}
		
		while(Piv <= IndiceDroite){
			Tabtemp[tempIndex++] 
					= numbers[Piv++];
		}
		
		for(int i=0;i<totalItems;i++){
			numbers[IndiceGauche+i] = Tabtemp[i];
		}
	}
    public  void sort(){
		int []Tabtemp = new int[numbers.length];
		TFusion(Tabtemp,0,numbers.length-1);
	}
    protected void doOperation() {
    	sort();
    }

}

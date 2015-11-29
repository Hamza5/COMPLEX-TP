package miniproject2.sort;

import java.util.Arrays;

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
	 		mergeParts ( Gauche, centre, Droite);
	 	}
	 }
    int progress=0;
    int []Tabtemp = new int[numbers.length];

 void mergeParts(int IndcGauche, int piv, int IndcDroite) {
 
        for (int i = IndcGauche; i <= IndcDroite; i++) {
            Tabtemp [i] = numbers[i];
        }
        int i = IndcGauche;
        int j = piv + 1;
        int k = IndcGauche;
        while (i <= piv && j <= IndcDroite) {
        	if((IndcGauche/(double)numbers.length*100)>progress){
				progress=Double.valueOf(IndcGauche/(double)numbers.length*100).intValue();
			setProgress(Double.valueOf(IndcGauche/(double)numbers.length*100).intValue());}
            if (Tabtemp [i] <= Tabtemp [j]) {
                numbers[k] = Tabtemp [i];
                i++;
            } else {
                numbers[k] = Tabtemp [j];
                j++;
            }
            k++;
        }
        while (i <= piv) {
            numbers[k] = Tabtemp [i];
            k++;
            i++;
        }
 
    }

 public  void sort(){
		int []Tabtemp = new int[numbers.length];
		TFusion(Tabtemp,0,numbers.length-1);
	}
    protected void doOperation() {
<<<<<<< HEAD
  
=======
>>>>>>> 0a57cf4060d2a5472025f7167ba35199d5a26d77
    	sort();
    }

}

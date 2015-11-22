package miniproject2.sort;

import java.util.Arrays;

import miniproject2.AlgorithmsProgressWindow;

public class RapidSortAlgorithme extends SortAlgorithm {
    public RapidSortAlgorithme(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri rapide";
    }

    int partition(int Gauche, int Droite)
    {     
          int i = Gauche, j = Droite;
          int tmp;
          int pivot = numbers[(Gauche + Droite) / 2];

          while (i <= j) {
                while (numbers[i] < pivot)
                      i++;
                while (numbers[j] > pivot)
                      j--;
                if (i <= j) {
                      tmp = numbers[i];
                      numbers[i] = numbers[j];
                      numbers[j] = tmp;
                      i++;
                      j--;
                }
          };
         
          return i;
    }
	 void TriRapide (int Gauche,int Droite)
	 {  
	   int  i;
	  if(Droite > Gauche)
	  {
	    i = partition(Gauche,Droite);
	    TriRapide (Gauche,i-1);
	    TriRapide (i+1,Droite);
	  }
	 }
    protected void doOperation() {
    	int  n  =  numbers.length-1  ;
    	TriRapide(0,n);
    	 
    
    }

}

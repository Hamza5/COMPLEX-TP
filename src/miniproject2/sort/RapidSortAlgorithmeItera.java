package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class RapidSortAlgorithmeItera extends SortAlgorithm {

    public RapidSortAlgorithmeItera(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri rapide itératif";
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
           }
          
           return i;
     }
  void RapidSortItera (int tab[], int IndxDeb, int IndxFin)
 {	 
	 int[] pile=new int[ IndxFin - IndxDeb + 1 ];
     int tete = -1;
     pile[ ++tete ] = IndxDeb;
     pile[ ++tete ] = IndxFin;
     while ( tete >= 0 )
     {	
     setProgress(Double.valueOf((1-pile[tete]/(double)numbers.length)*100).intValue());
         IndxFin = pile[ tete-- ];
         IndxDeb = pile[ tete-- ];
  
       
         int p = partition( IndxDeb, IndxFin );
         if ( p-1 > IndxDeb )
         {
             pile[ ++tete ] = IndxDeb;
             pile[ ++tete ] = p - 1;
         }
         
         if ( p+1 < IndxFin )
         {
             pile[ ++tete ] = p + 1;
             pile[ ++tete ] = IndxFin;
         }
     }
 }
    protected void doOperation() {
    	RapidSortItera(numbers,0, numbers.length-1);
    	
    }
}

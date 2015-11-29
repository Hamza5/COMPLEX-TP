package miniproject2.sort;

import java.util.Arrays;

import miniproject2.AlgorithmsProgressWindow;

public class RapidSortAlgorithmeItera extends SortAlgorithm {
	
	 double progress = 0;
    public RapidSortAlgorithmeItera(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri rapide Itratif";
        
    }

     int returnFirst(int x, int y) {
	    return x;
	}
  

     void permuter ( int a, int b )
     {
         int t = numbers[a];
         numbers[a]=numbers[b];;
         numbers[b]=t;
     }
      
     /* This function is same in both iterative and recursive*/
     int partition (int arr[], int l, int h)
     {
         int x = arr[h];
         int i = (l - 1);
      
         for (int j = l; j <= h- 1; j++)
         {
             if (arr[j] <= x)
             {
                 i++;
                 permuter (i, j);
             }
         }
         permuter (i + 1, h);
         return (i + 1);
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
  
       
         int p = partition(numbers, IndxDeb, IndxFin );
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

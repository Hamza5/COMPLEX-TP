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
  
//Meme fonction dans l'iteratif
  int partition (int tab[], int IndxDeb, int IndxFin)
 {
     int x = tab[IndxFin];
     int i = (IndxDeb - 1);
  
     for (int j = IndxDeb; j <= IndxFin- 1; j++)
     {
         if (tab[j] <= x)
         {
             i++;
             tab[i]=returnFirst(tab[j],tab[j]=tab[i]);//permutation entre tab[i] et tab[j]
       }
     }
     tab[i+1]=returnFirst(tab[IndxFin],tab[IndxFin]=tab[i+1]);
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
  
       
         int p = partition( tab, IndxDeb, IndxFin );
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

package miniproject2.sort;

import java.util.Arrays;

import miniproject2.AlgorithmsProgressWindow;

public class RapidSortAlgorithme extends SortAlgorithm {
    public RapidSortAlgorithme(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri rapide";
    }

//    
//    int  partition  (int Gauche,int Droite)
//	{  //progress=(double)Gauche/numbers.length*100;
//    	System.out.print((double)Gauche/numbers.length*100+"%\n");
//	   int i,j,piv,temp ;
//	   piv  =  numbers[Droite] ;
//	   i = Gauche-1 ;
//	   j = Droite ;
//	  do
//	   {
//	    do
//	    i++;  
//	    while ( numbers[i] < piv );
//	    
//	    do
//	    j--;
//	    while(numbers[j] > piv);
//	    
//	    temp = numbers[i] ;
//	    numbers[i]= numbers[j] ;
//	    numbers[j]= temp ;
//	   
//	   }while(j > i);
//	 
//	   numbers[j]= numbers[i] ;
//	   numbers[i]= numbers[Droite] ;
//	   numbers[Droite]= temp ;
//	  return i;
//	 }
    int partition(int Gauche, int Droite)
    {     
          int i = Gauche, j = Droite;
          int tmp;
          int pivot = numbers[(Gauche + Droite) / 2];
          System.out.print((double)Gauche/numbers.length*100+"%\n");

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
    	System.out.print(Arrays.toString(numbers));
    	int  n  =  numbers.length-1  ;
    	TriRapide(0,n);
    	setProgress(Double.valueOf(100-getProgress()).intValue());
    	 
    
    }

}

package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class RapidSortAlgorithme extends SortAlgorithm {
    public RapidSortAlgorithme(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri rapide récursif";
    }

    int partition(int tab[], int Gauche, int Droite)
    {
          int i = Gauche, j = Droite;
          int tmp;
          int pivot = tab[(Gauche + Droite) / 2];
         
          while (i <= j) {
                while (tab[i] < pivot)
                      i++;
                while (tab[j] > pivot)
                      j--;
                if (i <= j) {
                      tmp = tab[i];
                      tab[i] = tab[j];
                      tab[j] = tmp;
                      i++;
                      j--;
                }
          }
         
          return i;
    }
     
    void TriRapide(int tab[], int Gauche, int Droite) {
          int index = partition(tab, Gauche, Droite);
          if (Gauche < index - 1)
                TriRapide(tab, Gauche, index - 1);
          if (index < Droite)
                TriRapide(tab, index, Droite);
    }
    protected void doOperation() {
    	int  n  =  numbers.length-1  ;
    	TriRapide(numbers,0,n);
     }

}

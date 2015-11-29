package miniproject2.sort;

import miniproject2.AlgorithmsProgressWindow;

public class FusionSortAlgorithmItera extends SortAlgorithm {

    public FusionSortAlgorithmItera(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow, int[] stopValues) {
        super(numbers, worstCase, progressWindow, stopValues);
        name = "Tri par fusion itératif";
    }
	public  void TFusion(int[] Tab) {
 		if(Tab.length < 2) {return;}
 		int etape = 1;
 		int GauchD, DroiteD;

 		while(etape < Tab.length) {
 			GauchD = 0;
 			DroiteD = etape;
 			while(DroiteD + etape <= Tab.length) {
 				Fusion(Tab, GauchD, GauchD + etape, DroiteD, DroiteD + etape);
 				GauchD = DroiteD + etape;
 				DroiteD = GauchD + etape;
 			}
 			if(DroiteD < Tab.length) {Fusion(Tab, GauchD, GauchD + etape, DroiteD, Tab.length);}
 			setProgress(Double.valueOf(etape/(double)numbers.length*100).intValue());
 			etape *= 2;
 		}
 	}
 	public static void Fusion(int[] Tab, int GauchD, int FinGauche,int DroiteD, int FinDroite) {
 			int[] Droite = new int[FinDroite-DroiteD + 1];
 			int[] Gauche = new int[FinGauche-GauchD + 1];

 			for(int i = 0, k = DroiteD; i < (Droite.length - 1); ++i, ++k) {Droite[i] = Tab[k];}
 			for(int i = 0, k = GauchD; i < (Gauche.length - 1); ++i, ++k) {Gauche[i] = Tab[k];}

 			Droite[Droite.length-1] = Integer.MAX_VALUE;
 			Gauche[Gauche.length-1] = Integer.MAX_VALUE;
 			for(int k = GauchD, m = 0, n = 0; k < FinDroite; ++k) {
 				if(Gauche[m] <= Droite[n]) {
 					Tab[k] = Gauche[m];
 					m++;
 				}
 				else {Tab[k] = Droite[n];n++;}
 			}
 		}
    @Override
    protected void doOperation() {
    	TFusion(numbers);
    	
    }

}

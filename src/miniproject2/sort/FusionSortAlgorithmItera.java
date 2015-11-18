package miniproject2.sort;

import java.util.LinkedList;

import miniproject2.AlgorithmsProgressWindow;

public class FusionSortAlgorithmItera extends SortAlgorithm {

    public FusionSortAlgorithmItera(int[] numbers, boolean worstCase, AlgorithmsProgressWindow progressWindow) {
        super(numbers, worstCase, progressWindow);
        name = "Tri à bulles";
    }

    static public class MergePosInfo
    {
        public int left;
        public int mid;
        public int right;
    }
     public void MergeSort_Iterative(int [] numbers, int left, int right)
    {
        int mid;
        if (right <= left) return;
        
        LinkedList<MergePosInfo> list1 = new LinkedList<MergePosInfo>();
        LinkedList<MergePosInfo> list2 = new LinkedList<MergePosInfo>();
 
        MergePosInfo info = new MergePosInfo();
        info.left = left;
        info.right = right;
        info.mid = -1;
       
        list1.add(info);
 
        while(true){
            if(list1.size() == 0)  break;

            
            left = list1.get(0).left;
            right = list1.get(0).right;
            list1.remove(0);
            mid = (right + left) / 2;
            System.out.println("info.left "+(info.left/(double)numbers.length*100-50));
            if(left < right){
                MergePosInfo info2 = new MergePosInfo();
                info2.left = left;
                info2.right = right;
                info2.mid = mid + 1;
                list2.add(info2);
 
                info.left = left;
                info.right = mid;
                list1.add(info);
                
                info.left = mid + 1;
                info.right = right;
                list1.add(info);
                

            }
          // System.out.println("mid " +mid);
        }
      
        
        for (int i = 0; i < list2.size(); i++){
        	Fusion(numbers, list2.get(i).left, list2.get(i).mid, list2.get(i).right);
        }
       
    }
     float progress=0;
     void Fusion (int table[], int Gauche, int centre, int Droite){	
    	int j = Gauche; 
	 	int k = centre+1; 
	 	int i = Gauche; 
	 	int [] TableAnc = (int[]) table.clone(); 
	 	
	 	//setProgress(Double.valueOf((Gauche/(double)table.length)*200).intValue());
	 	while (j<= centre && k <= Droite)
	 	{   
	 	//setProgress(Double.valueOf(Droite/(double)table.length*100).intValue());
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
        MergeSort_Iterative(numbers, 0, numbers.length-1);
        System.out.print("tableau trie"+numbers.toString());
    }

}

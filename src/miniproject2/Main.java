package miniproject2;

import miniproject2.sort.Algorithm;

public class Main {
	public static void main(String[] args){
		int[] numbersTable;
		try {
			if (args.length != 3) throw new IllegalArgumentException();
			int size = Integer.parseInt(args[1]);
            if(size < 1) throw new NumberFormatException();
			String algorithmName = args[0].toLowerCase();
			numbersTable = new int[size];
            String testCase = args[2].toLowerCase();
            boolean inWorstCase = false;
            switch (testCase) {
                case "meilleur":
                    for (int i = 0; i < size; i++) {
                        numbersTable[i] = i + 1;
                    }
                    break;
                case "pire":
                    for (int i = 0; i < size; i++) {
                        numbersTable[size - i - 1] = i + 1;
                    }
                    inWorstCase = true;
                    break;
                default:
                    System.err.println("Cas inconnue : " + algorithmName);
                    System.exit(4);
            }
            AlgorithmsProgressWindow progressWindow = new AlgorithmsProgressWindow();
            switch (algorithmName) {
                case "sélection":
                    progressWindow.start(numbersTable, Algorithm.Selection, inWorstCase);
                    break;
                case "insertion":
                    progressWindow.start(numbersTable, Algorithm.Insertion, inWorstCase);
                    break;
                case "bulles":
                    progressWindow.start(numbersTable, Algorithm.Bubble, inWorstCase);
                    break;
                case "rapide":
                    progressWindow.start(numbersTable, Algorithm.Rapid, inWorstCase);
                    break;
                case "fusion":
                    progressWindow.start(numbersTable, Algorithm.Merge, inWorstCase);
                    break;
                case "tas":
                    progressWindow.start(numbersTable, Algorithm.Heap, inWorstCase);
                    break;
                case "rapide2":
                    progressWindow.start(numbersTable, Algorithm.RapidIterative, inWorstCase);
                    break;
                case "fusion2":
                    progressWindow.start(numbersTable, Algorithm.MergeIterative, inWorstCase);
                    break;
                case "tas2":
                    progressWindow.start(numbersTable, Algorithm.HeapIterative, inWorstCase);
                    break;
                default:
                    System.err.println("Algorithme inconnue : "+algorithmName);
                    System.exit(3);
            }
		}
		catch(NumberFormatException ex){
            System.err.println("Taille invalide : "+args[1]);
            System.exit(2);
		}
		catch(IllegalArgumentException ex){
            System.err.printf("Usage : %s <algorithme> <taille_tableau> (pire|meilleur)%n" +
                            " <algorithme> : bulles|sélection|insertion|fusion|rapide|tas|fusion2|rapide2|tas2%n",
                            "miniproject2.Main");
            System.exit(1);
		}
	}
}

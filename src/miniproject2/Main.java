package miniproject2;

import miniproject2.sort.Algorithm;

public class Main {
	public static void main(String[] args){
		int[] numbersTable;
		try {
			if (args.length < 3) throw new IllegalArgumentException();
			int min = Integer.parseInt(args[2]);
            int max = Integer.parseInt(args[args.length-1]);
            if (min > max) {
                int x = min;
                min = max;
                max = x;
            }
            int[] checkValues = new int[args.length - 2];
            for (int i = 0; i < checkValues.length; i++) checkValues[i] = Integer.parseInt(args[i+2]);
            if (min == max) min = 1;
            if(max < 1) throw new NumberFormatException();
			String algorithmName = args[0].toLowerCase();
			numbersTable = new int[max - min + 1];
            String testCase = args[1].toLowerCase();
            boolean inWorstCase = false;
            switch (testCase) {
                case "meilleur":
                    for (int i = 0; i < numbersTable.length; i++) {
                        numbersTable[i] = min++;
                    }
                    break;
                case "pire":
                    for (int i = 0; i < numbersTable.length; i++) {
                        numbersTable[i] = max--;
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
                    progressWindow.start(numbersTable, Algorithm.Selection, inWorstCase, checkValues);
                    break;
                case "insertion":
                    progressWindow.start(numbersTable, Algorithm.Insertion, inWorstCase, checkValues);
                    break;
                case "bulles":
                    progressWindow.start(numbersTable, Algorithm.Bubble, inWorstCase, checkValues);
                    break;
                case "rapide":
                    progressWindow.start(numbersTable, Algorithm.Rapid, inWorstCase, checkValues);
                    break;
                case "fusion":
                    progressWindow.start(numbersTable, Algorithm.Merge, inWorstCase, checkValues);
                    break;
                case "tas":
                    progressWindow.start(numbersTable, Algorithm.Heap, inWorstCase, checkValues);
                    break;
                case "rapide2":
                    progressWindow.start(numbersTable, Algorithm.RapidIterative, inWorstCase, checkValues);
                    break;
                case "fusion2":
                    progressWindow.start(numbersTable, Algorithm.MergeIterative, inWorstCase, checkValues);
                    break;
                case "tas2":
                    progressWindow.start(numbersTable, Algorithm.HeapIterative, inWorstCase, checkValues);
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
            System.err.printf("Usage : %s <algorithme> (pire|meilleur) <valeur> [<valeur_i>, ...]%n" +
                            " <algorithme> : bulles|sélection|insertion|fusion|rapide|tas|fusion2|rapide2%n" +
                            " <valeur> : La valeur minimale dans le tableau (ou maximale s'il n'a pas de <valeur_i>)%n" +
                            " <valeur_i> : Une ou plusieurs valeurs intermédiaires quand il faut enregistrer le temps d'exécution%n" +
                            "              La dernière valeur est la valeur maximale du tableau",                            "miniproject2.Main");
            System.exit(1);
		}
	}
}

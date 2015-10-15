class PrimeNumbersAlgorithms {

	static boolean algorithm1(double number){
		boolean prime = true;
		double i = 2;
		while(i < number && prime){
			if(number % i == 0) prime = false;
            else i++;
		}
		return prime;
	}

    static boolean algorithm2(double number){
        boolean prime = true;
        double i = 2;
        while(i <= number/2 && prime){
            if(number % i == 0) prime = false;
            else i++;
        }
        return prime;
    }

    static boolean algorithm3(double number){
        boolean prime = true;
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            double i = 3;
            while(i < number-1 && prime){
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        return prime;
    }

    static boolean algorithm4(double number){
        boolean prime = true;
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            double i = 3;
            while(i <= number/2 && prime){
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        return prime;
    }

    static boolean algorithm5(double number){
        boolean prime = true;
        double i = 2;
        while(i <= Math.sqrt(number) && prime){
            if(number % i == 0) prime = false;
            else i++;
        }
        return prime;
    }

    static boolean algorithm6(double number){
        boolean prime = true;
        if(number != 2 && number % 2 == 0) prime = false;
        else if(number != 2){
            double i = 3;
            while(i <= Math.sqrt(number) && prime){
                if(number % i == 0) prime = false;
                else i += 2;
            }
        }
        return prime;
    }
}
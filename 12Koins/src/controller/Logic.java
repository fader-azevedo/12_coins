package controller;


import java.util.Random;
public class Logic {
    public static void main(String [] Args){
//============Set up============\\
        int counterfeit = randInt(0,11);
        int counterValue = randInt(0,1);

        int coins[] = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        coins[counterfeit] = 2 + 2*(counterValue);
        int coinLocation = 0;
        String weight = "?";


//============Case Explanation============\\
//Uncomment to check with original values

        if(counterValue == 0){
            System.out.println("The counterfeit coin is coin " + (counterfeit+1) + " and is Lighter");
        }
        else{
            System.out.println("The counterfeit coin is coin " + (counterfeit+1) + " and is Heavier");
        }
        System.out.print(" \n [");
        for(int x = 0; x < 12; x++){
            System.out.print(coins[x]);
            if(x != 11){
                System.out.print(", ");
            }
        }
        System.out.println("] \n");


//============Solution============\\
        //First Weighing Groups
        int w1groupA = coins[0] + coins[1] + coins[2] + coins[3]; String w1groupA_ = "[0,1,2,3]";
        int w1groupB = coins[4] + coins[5] + coins[6] + coins[7]; String w1groupB_ = "[]";
        //Second Weighing Groups
        int w2groupA = coins[0] + coins[1] + coins[2]; String w2groupA_ = "[]";
        int w2groupB = coins[8] + coins[9] + coins[10]; String w2groupB_ = "[]";
        int w2groupC = coins[0] + coins[4] + coins[5]; String w2groupC_ = "[]";
        int w2groupD = coins[1] + coins[6] + coins[7]; String w2groupD_ = "[]";
        int w2groupE = coins[4] + coins[0] + coins[1]; String w2groupE_ = "[]";
        int w2groupF = coins[5] + coins[2] + coins[3]; String w2groupF_ = "[]";

//====Logic====\\
        if(w1groupA == w1groupB){               //Weigh One
            System.out.println("1ª Pesagem: w1groupA == w1groupB");
            if(w2groupA == w2groupB){               //Weigh Two
                System.out.println("2ª Pesagem: w2groupA == w2groupB");
                if(coins[11] > coins[0]){               //Weigh Three
                    System.out.println("3ª Pesagem: coins[11] > coins[0]");
                    coinLocation = 11;
                    weight = "Heavier";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem: coins[11] < coins[0]");
                    coinLocation = 11;
                    weight = "Lighter";
                }
            }
            else if(w2groupA < w2groupB){            //Weigh Two
                System.out.println("2ª Pesagem: w2groupA < w2groupB");
                if(coins[8] == coins[9]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 10;
                    weight = "Heavier";
                }
                else if(coins[8] > coins[9]){              //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 8;
                    weight = "Heavier";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 9;
                    weight = "Heavier";
                }
            }
            else{                                   //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[8] == coins[9]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 10;
                    weight = "Lighter";
                }
                else if(coins[8] < coins[9]){              //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 8;
                    weight = "Lighter";
                }
                else{                                  //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 9;
                    weight = "Lighter";
                }
            }
        }
        else if(w1groupA < w1groupB){              //Weigh One
            System.out.println("1ª Pesagem");
            if(w2groupC == w2groupD){               //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[8] == coins[2]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 3;
                    weight = "Lighter";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 2;
                    weight = "Lighter";
                }
            }
            else if(w2groupC < w2groupD){              //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[6] == coins[7]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 0;
                    weight = "Lighter";
                }
                else if(coins[6] > coins[7]){              //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 6;
                    weight = "Heavier";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 7;
                    weight = "Heavier";
                }
            }
            else{                                   //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[4] == coins[5]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 1;
                    weight = "Lighter";
                }
                else if(coins[4] > coins[5]){              //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 4;
                    weight = "Heavier";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 5;
                    weight = "Heavier";
                }
            }
        }
        else{                                   //Weigh One
            System.out.println("1ª Pesagem");
            if(w2groupE == w2groupF){               //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[8] == coins[6]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 7;
                    weight = "Lighter";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 6;
                    weight = "Lighter";
                }
            }
            else if(w2groupE < w2groupF){              //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[2] == coins[3]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 4;
                    weight = "Lighter";
                }
                else if(coins[2] > coins[3]){              //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 2;
                    weight = "Heavier";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 3;
                    weight = "Heavier";
                }
            }
            else{                                   //Weigh Two
                System.out.println("2ª Pesagem");
                if(coins[0] == coins[1]){               //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 5;
                    weight = "Lighter";
                }
                else if(coins[0] > coins[1]){              //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 0;
                    weight = "Heavier";
                }
                else{                                   //Weigh Three
                    System.out.println("3ª Pesagem");
                    coinLocation = 1;
                    weight = "Heavier";
                }
            }
        }

//============Test============\\
        if(counterValue == 0 && weight == "Lighter" && counterfeit == coinLocation){
            System.out.println("Correct! The counterfeit coin is coin " + (coinLocation+1) + " and is " + weight);
        }
        else if(counterValue == 1 && weight == "Heavier" && counterfeit == coinLocation){
            System.out.println("Correct! The counterfeit coin is coin " + (coinLocation+1) + " and is " + weight);
        }
        else{
            System.out.println("Index is " + coinLocation);
            System.out.println("Weight is " + weight);
        }
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
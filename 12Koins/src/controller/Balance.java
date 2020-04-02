package controller;

import java.util.*;

public class Balance {

    public int counterfeit = randInt(0,11);
    public int counterValue = randInt(0,1);

    List<Integer> coins = Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);
    int fakeValue = 2 + 2*(counterValue);

    public Balance(){
        coins.set(counterfeit,fakeValue);
    }

    public int getGroupA(){
        return  coins.subList(0,6).stream().mapToInt(Integer::intValue).sum();
    }

    public int getGroupB(){
        return coins.subList(6,12).stream().mapToInt(Integer::intValue).sum();
    }

    private int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public String answer(){
        String answer = "";
        if(counterValue == 0){
            answer = "A moeda falsa é moeda " + (counterfeit+1) + " e é a mais leve";
        } else{
            answer = "A moeda falsa é moeda " + (counterfeit+1) + " e é a mais pesada";
        }
        return answer+ ' '+coins.toString();
    }
}

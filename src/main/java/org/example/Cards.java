package org.example;

public class Cards {
    int number;
    int horns;
    //cards ending with 5 have 2 horns
    //cards ending with 0 have 3 horns
    //cards having same numbers, example "11", "44", have 5 horns
    //"55" have 7 horns, for being same numbers and ending with 5
    public Cards(int number){
        this.number = number;
        if(number%10==0){
            this.horns = 3;
        } else if (number%10==5) {
            if (number % 10 == number / 10) {
                this.horns = 7;
            } else {
                this.horns = 2;
            }
        } else if (number % 10 == number / 10) {
            this.horns = 5;
        } else {
            this.horns = 1;
        }
    }

    public int getNumber() {
        return number;
    }

    public int getHorns() {
        return horns;
    }
}

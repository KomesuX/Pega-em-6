package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PegaEmSeisAplication {
    public static void main (String[] args){
        SpringApplication.run(PegaEmSeisAplication.class, args);
        List<Cards> deck = new ArrayList<>();
        int cardPosition = 0;
        for (int i = 1; i <= 104; i++) {
            deck.add(new Cards(i));
            cardPosition += 1;
            System.out.println(deck.get(i-1).getNumber() + " horns " + deck.get(i-1).getHorns());
        }
        //Random shuffle = new Random();
        //int randomNum = shuffle.nextInt(113) - 1;
        //System.out.println("carta aleatória " + deck.get(randomNum).getNumber() + " com número de chifres " + deck.get(randomNum).getHorns());

    }

}

package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class MontyHallGame {
    private final Random random = new Random();

    public HashMap<Integer, String> playGame(int rounds, boolean switchDoor) {
        HashMap<Integer, String> resultMap = new HashMap<>();
        int wins = 0;
        int losses = 0;
        for (int i = 1; i <= rounds; i++) {

            int prizePosition = random.nextInt(3); // Позиция с призом (0,1,2)

            int playerChoice = random.nextInt(3); // Игрок выбирает одну из дверей

            int hostChoice = getHostChoice(prizePosition, playerChoice); // Определяем одну дверь без приза


            if (switchDoor) {
                playerChoice = getFinalChoice(playerChoice, hostChoice);
            } // Меняем дверь на не открытую

            // Проверяем, победил ли игрок
            if (playerChoice == prizePosition) {
                wins++;
                resultMap.put(i, "Победа");
            } else {
                losses++;
                resultMap.put(i, "Поражение");
            }
        }

        System.out.printf("Итог: %d побед, %d поражений.\n", wins, losses);
        return resultMap;
    }

    // Определяем невыбранную дверь и дверь без приза
    private int getHostChoice(int prizePosition, int playerChoice) {
        for (int i = 0; i < 3; i++) {
            if (i != prizePosition && i != playerChoice) {
                return i;
            }
        }
        return -1;
    }


    private int getFinalChoice(int playerChoice, int hostChoice) {
        for (int i = 0; i < 3; i++) {
            if (i != playerChoice && i != hostChoice) {
                return i;
            }
        }
        return -1;
    }
}

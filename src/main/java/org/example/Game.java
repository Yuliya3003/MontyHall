package org.example;

public class Game {
    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        int rounds = 1000; // количество тестов

        // Проверяем с заменой двери и без замены
        System.out.println("Симуляция с изменением выбора:");
        game.playGame(rounds, true);

        System.out.println("\nСимуляция без изменения выбора:");
        game.playGame(rounds, false);
    }
}

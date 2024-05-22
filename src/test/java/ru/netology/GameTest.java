package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void whenSecondPlayerWin() {
        Player ivan = new Player(123, "Иван", 120);
        Player petr = new Player(12345, "Петр", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(petr);

        int actual = game.round("Петр", "Иван");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerWin() {
        Player ivan = new Player(1, "Петр", 120);
        Player petr = new Player(2, "Иван", 100);
        Game game = new Game();

        game.register(ivan);
        game.register(petr);

        int actual = game.round("Петр", "Иван");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenStrengthEqual() {
        Player ivan = new Player(1, "Петр", 120);
        Player petr = new Player(2, "Иван", 120);
        Game game = new Game();

        game.register(ivan);
        game.register(petr);

        int actual = game.round("Петр", "Иван");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExist() {
        Player ivan = new Player(1, "Петр", 120);

        Game game = new Game();

        game.register(ivan);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Илья", "Иван")
        );
    }

    @Test
    public void whenSecondPlayerNotExist() {
        Player ivan = new Player(1, "Петр", 120);

        Game game = new Game();

        game.register(ivan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Илья")
        );
    }
}

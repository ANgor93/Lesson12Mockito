package FilmsManagerTest;

import FilmsManager.FilmsManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {
    FilmsManager manager = new FilmsManager(7); // выстроим лимит и погнали


    @Test
    public void shouldAllFilms() {
        manager.addFilm("Star Wars 1");
        manager.addFilm("Star Wars 2");
        manager.addFilm("Star Wars 3");

        String[] expected = {"Star Wars 1", "Star Wars 2", "Star Wars 3"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FilmsCompareLimit() {
        manager.addFilm("Star Wars 1");
        manager.addFilm("Star Wars 2");
        manager.addFilm("Star Wars 3");
        manager.addFilm("Star Wars 4");
        manager.addFilm("Star Wars 5");

        String[] expected = {"Star Wars 5", "Star Wars 4", "Star Wars 3", "Star Wars 2", "Star Wars 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FilmsOverLimit() {
        manager.addFilm("Star Wars 1");
        manager.addFilm("Star Wars 2");
        manager.addFilm("Star Wars 3");
        manager.addFilm("Star Wars 4");
        manager.addFilm("Star Wars 5");
        manager.addFilm("Star Wars 6");
        manager.addFilm("Star Wars 7");

        String[] expected = {"Star Wars 7", "Star Wars 6", "Star Wars 5", "Star Wars 4", "Star Wars 3", "Star Wars 2", "Star Wars 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FilmsCompareDefaultLimit() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("Star Wars 1");
        manager.addFilm("Star Wars 2");
        manager.addFilm("Star Wars 3");
        manager.addFilm("Star Wars 4");
        manager.addFilm("Star Wars 5");
        manager.addFilm("Star Wars 6");
        manager.addFilm("Star Wars 7");
        manager.addFilm("Star Wars 8");
        manager.addFilm("Star Wars 9");
        manager.addFilm("Star Wars 10");

        String[] expected = {"Star Wars 10", "Star Wars 9", "Star Wars 8", "Star Wars 7", "Star Wars 6", "Star Wars 5", "Star Wars 4", "Star Wars 3", "Star Wars 2", "Star Wars 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FilmUnderLimit() {
        manager.addFilm("Star Wars 1");
        manager.addFilm("Star Wars 2");
        manager.addFilm("Star Wars 3");

        String[] expected = {"Star Wars 3", "Star Wars 2", "Star Wars 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
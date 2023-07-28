package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
    SimpleTask simpleTask = new SimpleTask(5, "Написать текст");

        String[] subtasks = { "Шрифт", "Буквы", "Пробелы" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "О профессиональном выгорании специалистов среднего звена",
                "Особенности кадровой политики текущего технологического уклада",
                "В понедельник с утра на свежую голову"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Выдавить из себя раба частями");

        Assertions.assertFalse(task.matches("Выловить"));
        Assertions.assertTrue(task.matches("из"));
        Assertions.assertFalse(task.matches("пруда"));
        Assertions.assertTrue(task.matches("раба"));
        Assertions.assertTrue(task.matches("частями"));
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Постигнуть в совершенстве метод `matches`", "Придумать сюжет в TodosTest класс"};
        Epic epic = new Epic(2, subtasks);

        Assertions.assertTrue(epic.matches("matches"));
        Assertions.assertTrue(epic.matches("TodosTest"));
        Assertions.assertFalse(epic.matches("AnyTest"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(3, "Ежедневный статус", "Язык Java", "2023-07-29 08:00");

        Assertions.assertTrue(meeting.matches("статус"));
        Assertions.assertTrue(meeting.matches("Язык"));
        Assertions.assertFalse(meeting.matches("программа"));
    }

    @Test
    public void testSearch() {
        SimpleTask task1 = new SimpleTask(1, "Сходить в магазин за продуктами");
        SimpleTask task2 = new SimpleTask(2, "Проконтролировать внеклассное чтение дочери");
        Meeting meeting = new Meeting(3, "Ежедневный статус", "Язык Java", "2023-07-29 08:00");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(meeting);

        Task[] result1 = todos.search("магазин");
        Assertions.assertArrayEquals(new Task[]{ task1 }, result1);

        Task[] result2 = todos.search("чтение");
        Assertions.assertArrayEquals(new Task[]{ task2 }, result2);

        Task[] result3 = todos.search("Сделать открытие");
        Assertions.assertArrayEquals(new Task[]{}, result3);
    }

}
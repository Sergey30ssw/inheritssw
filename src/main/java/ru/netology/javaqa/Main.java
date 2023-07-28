package ru.netology.javaqa;

public class Main {
    public static void main(String[] args) {
        // Задачи на день
        Task task1 = new SimpleTask(1, "Сходить в магазин за продуктами");
        Task task2 = new SimpleTask(2, "Проконтролировать внеклассное чтение дочери");
        Task epic = new Epic(3, new String[]{"Проект по изучению UI"});
        Task meeting = new Meeting(4, "Ежедневный статус", "Язык Java", "2023-07-29 08:00");

        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(epic);
        todos.add(meeting);


    }
}
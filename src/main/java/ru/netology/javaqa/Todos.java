package ru.netology.javaqa;

public class Todos {

    private Task[] tasks = new Task[0]; // <- здесь будут задачи

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     * @param current Массив, в который мы хотим добавить элемент
     * @param task Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот, что был переделан,
     * но с добавлением нового элемента
     */
    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    /**
     * Метод добавления задачи в список дел
     * @param task Добавляемая задача
     */
    public void add(Task task) { // <- в этом месте может лежать объект и вида SimpleTask, и вида Epic, и вида Meeting
        tasks = addToArray(tasks, task);
    }

    public Task[] findAll() {
        return tasks;
    }

    /**
     * Метод поиска задач, которые подходят под поисковый запрос
     * @param query Поисковый запрос
     * @return Массив из подошедших задач
     */
    public Task[] search(String query) {
        Task[] result = new Task[0]; // массив для ответа
        for (Task task : tasks) { // перебор всех задач
            if (task.matches(query)) { // если задача подходит под запрос
                result = addToArray(result, task); // добавление задачи в массив ответа
            }
        }
        return result;
    }
}
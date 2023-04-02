package ru.job4j.todo.service;

import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public Task create(Task task);

    public void update(Task task);

    public void delete(int taskId);

    public List<Task> findByAll();

    public Optional<Task> findById(int id);

    public List<Task> findByDone(boolean done);

}

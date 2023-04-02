package ru.job4j.todo.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.Task;
import ru.job4j.todo.repository.TaskStore;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleTaskService implements TaskService{

    private final TaskStore repo;

    @Override
    public Task create(Task task) {
        return repo.create(task);
    }

    @Override
    public void update(Task task) {
        repo.update(task);
    }

    @Override
    public void delete(int taskId) {
        repo.delete(taskId);
    }

    @Override
    public List<Task> findByAll() {
        return repo.findByAll();
    }

    @Override
    public Optional<Task> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<Task> findByDone(boolean done) {
        return repo.findByDone(done);
    }
}

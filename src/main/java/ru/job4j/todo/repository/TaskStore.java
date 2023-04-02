package ru.job4j.todo.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TaskStore {
    private final SessionFactory sf;

    /**
     * Обновить в базе задачу.
     * @param task задача.
     */
    public Task create(Task task) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return task;
    }

    /**
     * Обновить в базе задачу.
     * @param task задача.
     */
    public void update(Task task) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Удалить задачу по id.
     * @param taskId ID
     */
    public void delete(int taskId) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Task task = new Task();
            task.setId(taskId);
            session.delete(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Список всех задач
     * @return список задач.
     */
    public List<Task> findByAll() {
        Session session = sf.openSession();
        try {
            return session.createQuery("From Tasks")
                    .getResultList();
        } finally {
            session.close();
        }
    }

    /**
     * Найти задачу по ID
     * @return задача.
     */
    public Optional<Task> findById(int id) {
        Session session = sf.openSession();
        try {
            Query<Task> query = session.createQuery("From User Where id=:id");
            query.setParameter("id", id);
            return query.uniqueResultOptional();
        } finally {
            session.close();
        }
    }

    /**
     * Список всех задач по нужному статусу
     * @param done статус выполнения
     * @return список задач.
     */
    public List<Task> findByDone(boolean done) {
        Session session = sf.openSession();
        try {
            return session.createQuery("From Tasks Where done=:done")
                    .setParameter("done", done)
                    .getResultList();
        } finally {
            session.close();
        }
    }

}
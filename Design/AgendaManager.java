package Design;

import java.io.*;
import java.util.*;

public class AgendaManager {
    private static final String TASKS_FILE = "tasks.dat";
    private static final String NOTES_FILE = "notes.dat";

    private Map<String, Task> tasks;
    private Map<String, Note> notes;

    public AgendaManager() {
        tasks = new HashMap<>();
        notes = new HashMap<>();
        loadTasks();
        loadNotes();
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
        saveTasks();
    }

    public void addNote(Note note) {
        notes.put(note.getId(), note);
        saveNotes();
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes.values());
    }

    public void updateTask(Task updatedTask) {
        if (tasks.containsKey(updatedTask.getId())) {
            tasks.put(updatedTask.getId(), updatedTask);
            saveTasks();
        }
    }

    public void updateNote(Note updatedNote) {
        if (notes.containsKey(updatedNote.getId())) {
            notes.put(updatedNote.getId(), updatedNote);
            saveNotes();
        }
    }

    public void deleteTask(String taskId) {
        tasks.remove(taskId);
        saveTasks();
    }

    public void deleteNote(String noteId) {
        notes.remove(noteId);
        saveNotes();
    }

    private void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TASKS_FILE))) {
            tasks = (Map<String, Task>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing tasks file found. Starting with an empty task map.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadNotes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOTES_FILE))) {
            notes = (Map<String, Note>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing notes file found. Starting with an empty note map.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TASKS_FILE))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveNotes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOTES_FILE))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getIncompleteTasksSortedByPriorityAndDueDate() {
        List<Task> incompleteTasks = new ArrayList<>(tasks.values());
        incompleteTasks.removeIf(Task::isCompleted);
        Collections.sort(incompleteTasks);
        return incompleteTasks;
    }

    public Map<TaskPriority, List<Task>> getTasksByPriority() {
        Map<TaskPriority, List<Task>> tasksByPriority = new EnumMap<>(TaskPriority.class);
        for (TaskPriority priority : TaskPriority.values()) {
            tasksByPriority.put(priority, new ArrayList<>());
        }
        for (Task task : tasks.values()) {
            tasksByPriority.get(task.getPriority()).add(task);
        }
        return tasksByPriority;
    }
}
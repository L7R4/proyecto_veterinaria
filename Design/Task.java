package Design;

import java.time.LocalDate;

public class Task extends Agenda {
    
    private static final long serialVersionUID = 1L;
    
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private TaskPriority priority;

    public Task() {
        super();
        this.completed = false;
        this.priority = TaskPriority.MEDIUM;
    }

    public Task(String id, String title, String description, LocalDate dueDate, TaskPriority priority) {
        super(id, title);
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Agenda other) {
        if (other instanceof Task) {
            Task otherTask = (Task) other;
            int priorityComparison = this.priority.compareTo(otherTask.priority);
            if (priorityComparison != 0) {
                return priorityComparison;
            }
            return this.dueDate.compareTo(otherTask.dueDate);
        }
        return super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", creationDate=" + getCreationDate() +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }
}
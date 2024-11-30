package Design;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Agenda implements Comparable<Agenda>, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String title;
    private LocalDateTime creationDate;

    public Agenda() {
        this.creationDate = LocalDateTime.now();
    }

    public Agenda(String id, String title) {
        this();
        this.id = id;
        this.title = title;
    }

    
    // Getters and Setters

   
    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    
    public String getTitle(){
        return this.title;
    }
    
    
    public void setTitle(String title){
        this.title = title;
    }

   
    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

   
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    
    
    //Methods

    @Override
    public int compareTo(Agenda other) {
        return this.creationDate.compareTo(other.creationDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Agenda agenda = (Agenda) obj;
        return Objects.equals(id, agenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
package Design;

public class Note extends Agenda {
    private static final long serialVersionUID = 1L;
    
    private String content;

    public Note() {
        super();
    }

    public Note(String id, String title, String content) {
        super(id, title);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   
    @Override
    public String toString() {
        return "Note{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", creationDate=" + getCreationDate() +
                ", content='" + content + '\'' +
                '}';
    }
    
}
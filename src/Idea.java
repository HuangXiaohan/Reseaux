import java.io.File;
import java.io.Serializable;

/**
 * Created by huang on 12/05/16.
 */
public class Idea implements Serializable {
    private User author;
    private File idea;


    public Idea(File content, User author) {
        this.idea = content;
        this.author = author;
    }


    public String getName() {
        return author.getIdentifiant();
    }

    public String getEmail() {
        return author.getEmail();
    }

    public File getIdea() {
        return idea;
    }
}

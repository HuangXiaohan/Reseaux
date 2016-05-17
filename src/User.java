import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huang on 12/05/16.
 */
public class User implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String identifiant;
    private String email;


    public User(String identifiant, String email) {
        this.identifiant = identifiant;
        this.email = email;
        this.id=count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getEmail() {
        return email;
    }
}

import java.io.Serializable;

/**
 * Created by huang on 12/05/16.
 */
public class ClientObject implements Serializable {
    private String arg;
    private Object object;

    public ClientObject(String arg, Object object) {
        this.arg = arg;
        this.object = object;
    }

    public String getArg() {
        return arg;
    }

    public Object getObject() {
        return object;
    }



}

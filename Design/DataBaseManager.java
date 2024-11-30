package Design;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager<T extends Serializable> implements CRUD<T> {
    private List<T> list;
    private String file;

    public DataBaseManager(String file) {
        this.file = file;
        this.list = load();
    }

    @Override
    public void add(T object) {
        list.add(object);
        save();
    }

    @Override
    public void delete(String ID) {
        list.removeIf(obj -> obj.toString().contains(ID));
        save();
    }

    @Override
    public void modify(T object) {
        delete(object.toString());
        add(object);
    }

    @Override
    public List<T> list() {
        return new ArrayList<>(list);
    }

    @Override
    public T consult(String ID) {
        for (T obj : list) {
            if (obj.toString().contains(ID)) {
                return obj;
            }
        }
        return null;
    }

    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<T> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

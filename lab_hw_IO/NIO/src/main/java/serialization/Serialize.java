package serialization;

import java.io.*;

public class Serialize<T> {
    public void saveObject(T obj, String fileName) {
        try {
            ObjectOutputStream objOutStr = new ObjectOutputStream(new FileOutputStream(fileName));
            objOutStr.writeObject(obj);
            objOutStr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T getSavedObject(String fileName) {
        try {
            ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(fileName)) ;
            return (T) objInStr.readObject();
            }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return  null;
    }
}

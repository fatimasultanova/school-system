package inputUtils;

import classes.Classes;
import dynamicArrays.DynamicArray;
import globalData.GlobalData;
import users.Person;

import java.io.*;

public class FileUtils implements Serializable {
    public static void saveAll(String file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file,true);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(GlobalData.dynamicArrayPerson);
            objectOutputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DynamicArray<Person> readAll(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            DynamicArray<Person> personDynamicArray = (DynamicArray<Person>) objectInputStream.readObject();
//            System.out.println(personDynamicArray.get(0));
            return personDynamicArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public static void saveAllClasses(String file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file,true);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(GlobalData.dynamicArrayClass);
            objectOutputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DynamicArray<Classes> readAllClasses(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            DynamicArray<Classes> classesDynamic = (DynamicArray<Classes>) objectInputStream.readObject();
            return classesDynamic;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public static void applicationLogs(String filename, String log) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename,true));
            bufferedWriter.write(log);
            bufferedWriter.flush();
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();

        }


    }
}

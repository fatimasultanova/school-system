package inputUtils;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalData.GlobalData;
import users.Person;

import java.io.*;
import java.util.ArrayList;

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

    public static ArrayList<Person> readAll(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
           ArrayList<Person> personArrayList = (ArrayList<Person>) objectInputStream.readObject();
            return personArrayList;
//            System.out.println(personDynamicArray.get(0));
           // return personDynamicArray;
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

    public static ArrayList<Classes> readAllClasses(String file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            ArrayList<Classes> classesArrayList = (ArrayList<Classes>) objectInputStream.readObject();
            return  classesArrayList;
           // return classesDynamic;
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

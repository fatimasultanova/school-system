package dynamicArrays;

import users.Person;

import java.io.Serializable;

public class DynamicArray<T> implements Serializable {
    private static final long serialVersionUID = 4755545064758769181L;
   public Object[] persons;

    public DynamicArray(){
        persons= new Object[0];
    }

    public void add(T person){
        Object[] newPersons = new Object[persons.length+1];
        for (int i=0;i< persons.length;i++){
            newPersons[i]=persons[i];
        }
        newPersons[persons.length]=person;

        persons=newPersons;
    }

    public void delete(int index) throws IllegalArgumentException{

        if (index>=persons.length || index<0){
            throw new IllegalArgumentException();
        }
            Object[] newPersons = new Object[persons.length-1];
            for (int i = 0, k=0;i< persons.length;i++) {
                if (i == index) {
                    continue;
                }
                newPersons[k++]=persons[i];
            }
           persons=newPersons;
        }

        
        public T get(int index){
       try {
           if (index<0 || index>= persons.length){
               System.out.println("Wrong index!");

               //throw new IllegalArgumentException();
           }
       }catch (IllegalArgumentException ex){
           ex.printStackTrace();
       }
        return (T) persons[index];
    }

    public int size(){
        return persons.length;
    }

    }

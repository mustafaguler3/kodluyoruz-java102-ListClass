import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class MyList<T> {

    T[] array;

    public MyList() {
        this.array = (T[]) new Object[10];
    }


    public MyList(int capasity) {
        this.array = (T[]) new Objects[capasity];
    }

    public void add(T data){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                break;
            } else if (array[i] != null && i == array.length - 1) {
                array = Arrays.copyOf(array, array.length * 2);
                array[array.length / 2] = data;
                break;
            }
        }
    }

    public int size(){
        int count = 0;
        for (T element : array) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }

    public int getCapacity(){
        return this.array.length;
    }

    public int raiseArraySize(){
        return this.array.length*2;
    }

    public T get(int index) {
        try {
            if (array[index] != null) {
                return array[index];
            } else return null;
        } catch (Exception ignored) {
            return null;
        }


    }

    public T remove(int index) {
        T value;
        try {
            value=get(index);
            if (array[index] != null) {
                if (size() - index >= 0)
                    System.arraycopy(array, index + 1, array, index, size() - index);
            }
        } catch (Exception ignored) {
            return null;
        }
        return value;
    }

    public void set(int index, T data) {
        try {
            if (array[index] != null) {
                array[index] = data;
            }
        } catch (Exception ignored) {
            System.out.println("Hatalı işlem");
        }
    }

    public String toString() {
        if (size() > 0) {
            StringBuilder str = new StringBuilder("[");
            for (int i = 0; i < size(); i++) {
                if (i == (size() - 1)) {
                    str.append(array[i]).append("]");
                } else str.append(array[i]).append(",");

            }
            return str.toString();
        }
        return "[]";
    }

    public int indexOf(T data) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (array[i] == data) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(T data) {
        int index = -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (array[i] == data) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T[] toArray() {
        return Arrays.copyOfRange(array, 0, size());
    }

    public void clear() {
        this.array = (T[]) new Object[10];
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> newList = new MyList<>((finish - start + 1));
        for (int i = start; i <= finish; i++) {
            newList.add(array[i]);
        }
        return newList;
    }

    public boolean contains(T data) {
        boolean isIt = false;
        for (int i = 0; i < size(); i++) {
            if (array[i] == data) {
                isIt = true;
                break;
            }
        }
        return isIt;
    }

}
























# Przydatne klasy
## [`ArrayList`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
Metody (nie wszystkie):
- `public boolean add(E e)`
Appends the specified element to the end of this list.
- `public void add(int index,
                E element)`
Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
- `public void clear()`
Removes all of the elements from this list. The list will be empty after this call returns.
- `public boolean contains(Object o)`
Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that (o==null ? e==null : o.equals(e)).
- `public E get(int index)`
Returns the element at the specified position in this list.
- `public int indexOf(Object o)`
Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
- `public E remove(int index)`
Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
- `public boolean remove(Object o)`
Removes the first occurrence of the specified element from this list, if it is present. If the list does not contain the element, it is unchanged. More formally, removes the element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists). Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
- `public E set(int index,
             E element)`
Replaces the element at the specified position in this list with the specified element.
- `public int size()`
Returns the number of elements in this list.
- `public Object[] toArray()`
Returns an array containing all of the elements in this list in proper sequence (from first to last element).
The returned array will be "safe" in that no references to it are maintained by this list. (In other words, this method must allocate a new array). The caller is thus free to modify the returned array.
- `public <T> T[] toArray(T[] a)`
Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array. If the list fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this list.
If the list fits in the specified array with room to spare (i.e., the array has more elements than the list), the element in the array immediately following the end of the collection is set to null. (This is useful in determining the length of the list only if the caller knows that the list does not contain any null elements.)
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // uwaga, nie może być ArrayList<int>, musi być klasa

        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(arr);

        for (Integer numer : arr) {
            System.out.println(numer);
        }

        for (int numer : arr) {
            System.out.println(numer);
        }

        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
            //arr[i] nie działa
        }
    }
}
```

## Zamiana listy na tablice

```java
list.stream().toArray(typ::new);
```

# Potencjalne błędy
## [Wołanie konstruktora z drugiego konstruktora](https://stackoverflow.com/questions/285177/how-do-i-call-one-constructor-from-another-in-java)

```java
public class Foo {
    private int a, b;

    public Foo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // chcę, aby wywołanie Foo(a) stworzyło obiekt z parametrami (a, 0)
    public Foo(int a) {
        Foo(a, 0); //!!! nie działa
    }

    public Foo(int a) {
        this(a, 0); // działa
    }
}
```

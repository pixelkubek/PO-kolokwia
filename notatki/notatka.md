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

## [`String`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
String jest immutable

Metody (nie wszytkie):
- `public char charAt(int index)`
Returns the char value at the specified index. An index ranges from 0 to length() - 1. The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.
If the char value specified by the index is a surrogate, the surrogate value is returned.
- `public int compareTo(String anotherString)`
Compares two strings lexicographically. Returns:
the value 0 if the argument string is equal to this string; a value less than 0 if this string is lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically greater than the string argument.
- `public boolean contains(CharSequence s)`
Returns true if and only if this string contains the specified sequence of char values.
- `public String concat(String str)`
Concatenates the specified string to the end of this string.
If the length of the argument string is 0, then this String object is returned. Otherwise, a String object is returned that represents a character sequence that is the concatenation of the character sequence represented by this String object and the character sequence represented by the argument string.
- `public int indexOf(String str)`
Returns the index within this string of the first occurrence of the specified substring.
- `public int indexOf(String str, int fromIndex)`
Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
- `public int length()`
Returns the length of this string. The length is equal to the number of Unicode code units in the string.
- `public String substring(int beginIndex, int endIndex)`
Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex.

# Przydatne info

## Zamiana listy na tablice

```java
list.stream().toArray(typ::new);
```
## Kopiowanie tablic
```java
System.arraycopy(z, indeksStartZ, do, indeksStartDo,ileElementow);
```

## Sortowanie
- `public interface Comparable<T>` This interface imposes a total ordering on the objects of each class that implements it. This ordering is referred to as the class's natural ordering, and the class's compareTo method is referred to as its natural comparison method.
Lists (and arrays) of objects that implement this interface can be sorted automatically by Collections.sort (and Arrays.sort). Objects that implement this interface can be used as keys in a sorted map or as elements in a sorted set, without the need to specify a comparator.
- `public interface Comparator<T>` A comparison function, which imposes a total ordering on some collection of objects. Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order.

```java
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4]

        Foo[] arr2 = {new Foo(4), new Foo(3), new Foo(2), new Foo(1)};

        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4]

        Bar[] arr3 = {new Bar(4), new Bar(3), new Bar(2), new Bar(1)};

        Arrays.sort(arr3, new BarComparator());

        System.out.println(Arrays.toString(arr3)); // [1, 2, 3, 4]
    }
}

public class Foo implements Comparable<Foo> {
    private int i;

    public Foo(int num) {
        i = num;
    }

    @Override
    public int compareTo(Foo f) {
        return this.i - f.i;
    }

    @Override
    public String toString() {
        return "" + i;
    }
}

public class Bar {
    private int i;

    public Bar(int num) {
        i = num;
    }

    @Override
    public String toString() {
        return "" + i;
    }

    public int getI() {return i;}
}

import java.util.Comparator;

public class BarComparator implements Comparator<Bar> {
    public int compare(Bar b, Bar c) {
        return b.getI() - c.getI();
    }
}
```

## Modyfikatory dostępu (metody, klasy, atrybuty...)
- *domyślny* - dostępny w całej paczce,
- `public` - dostępny dla wszystkich,
- `private` - dostępny tylko w tej klasie (**i nie w klasie pochodnych!!!**),
- `protected` - dostępny w całej paczce i klasach pochodnych.
### inne ważne słowa kluczowe
- `abstract` - klasa / metoda abstrakcyjna, to znaczy jej implementacja musi być przysłonięta
- `final` - to jest finalna wartość / implementacja, nie można jej później zmienić (uwaga, przy lokalnych atrybutach w klasie oznacza, że można je ustawić tylko w konstruktorze)
- `super` - odwołanie do nadklasy (lub jednej z nich, najbliższej z daną implementacją, czarna skrzynka trochę)
- `this` - odwołanie do tego obiektu, w którym jesteśmy
- `extends` - klasa dziedzidzy po innej klasie (```Chomik extends Ssak```)
- `impements` - klasa implementuje interfejs (```Samochod implements Pojazd```)
- `@Override` - używamy przed funkcją informując, że poniższy kod to przysłonięcie poprzedniej(o ile istniała) implementacji funkcji
## Konwencje
- pakiet
  - com.sun.eng
- ToJestKlasa (*PascalCase*)
- ToZaśJestInterfejs (*PascalCase*)
- aToMetoda() (*camelCase*)
- nazwaZmiennej (*camelCase*)
- TO_JEST_STALA


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

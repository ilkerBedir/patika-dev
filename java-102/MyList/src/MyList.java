import java.util.Arrays;

//Sınıf içerisindeki dizinin varsayılan boyutu 10 ve dizinin eleman sayısı ihtiyaç duydukça 2 katı şeklinde artmalı.
public class MyList<T> {
  private T[] myList;
  private int capacity;
  private int lastIndex = 0;
  private final int DEFAULT_CAPACITY = 10;

  //MyList() : Boş contructor kullanılırsa dizinin başlangıç boyutu 10 olmalıdır.
  public MyList() {
    myList = ((T[]) new Object[DEFAULT_CAPACITY]);
    this.capacity = DEFAULT_CAPACITY;
  }

  //MyList(int capacity) : Dizinin başlangıç değeri capacity parametresinden alınmalıdır.
  public MyList(int capacity) {
    myList = ((T[]) new Object[capacity]);
    this.capacity = capacity;
  }

  //size() : dizideki eleman sayısını verir.
  public int size() {
    return lastIndex;
  }

  //getCapacity() : dizinin kapasite değerini verir.
  public int getCapacity() {
    return this.capacity;
  }

  //add(T data) : sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.
  public void add(T data) {
    if (lastIndex < this.capacity) {
      myList[lastIndex] = data;
      lastIndex++;
    } else {
      this.capacity *= 2;
      grow();
      myList[lastIndex] = data;
      lastIndex++;
    }
  }

  private void grow() {
    T[] tmpList = ((T[]) new Object[this.capacity]);
    System.arraycopy(myList, 0, tmpList, 0, myList.length);
    myList = tmpList;
  }

  //get(int index): verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
  public T get(int index) {
    if (index < 0 && index > lastIndex) {
      return null;
    }
    return myList[index];
  }

  //remove(int index): verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sol doğru kaydırmalı. Geçersiz indis girilerse null döndürür.
  public T remove(int index) {
    if (index < 0 && index > lastIndex) {
      return null;
    }
    for (int i = index + 1; i <= lastIndex; i++) {
      myList[i - 1] = myList[i];
    }
    myList[lastIndex] = null;
    lastIndex--;
    return myList[index];
  }

  //  set(int index, T data) : verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır. Geçersiz indis girilerse null döndürür.
  public T set(int index, T data) {
    if (index < 0 && index > lastIndex) {
      return null;
    }
    myList[index] = data;
    return data;
  }

  //    String toString() : Sınıfa ait dizideki elemanları listeleyen bir metot.
  public String toString() {
    if (lastIndex == 0) {
      return "[]";
    }
    String str = ("[");
    for (int i = 0; i < lastIndex; i++) {
      str += myList[i] + ",";
    }
    str = str.substring(0, str.length() - 1);
    str += "]";
    return str;
  }

  //    int indexOf(T data) : Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
  public int indexOf(T data) {
    for (int i = 0; i < lastIndex; i++) {
      if (myList[i].equals(data)) {
        return i;
      }
    }
    return -1;
  }

  //    int indexOf(T data) : Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.
  public int lastIndexOf(T data) {
    for (int i = lastIndex - 1; i > 0; i--) {
      if (myList[i].equals(data)) {
        return i;
      }
    }
    return -1;
  }

  //    boolean isEmpty() : Listenin boş olup olmadığını söyler.
  public boolean isEmpty() {
    return lastIndex == 0;
  }

  //    T[] toArray() : Listedeki öğeleri, aynı sırayla bir array haline getirir.
  public T[] toArray() {
    return Arrays.copyOf(myList, lastIndex);
  }

  //  clear() : Listedeki bütün öğeleri siler, boş liste haline getirir.
  public void clear() {
    for (int i = 0; i < myList.length; i++) {
      myList[i] = null;
    }
    lastIndex = 0;
  }

  //  MyList<T> sublist(int start,int finish) : Parametrede verilen indeks aralığına ait bir liste döner.
  public MyList<T> subList(int start, int finish) {
    int newListCapacity = finish - start;
    MyList<T> newList = new MyList<>(newListCapacity + 1);
    for (int i = start; i <= finish; i++) {
      newList.add(myList[i]);
    }
    return newList;
  }

  //    boolean contains(T data) : Parametrede verilen değerin dizide olup olmadığını söyler.
  public boolean contains(T data) {
    for (int i = 0; i < lastIndex; i++) {
      if (data.equals(myList[i])) {
        return true;
      }
    }
    return false;
  }
}

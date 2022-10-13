import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.addFirst("S"); list.addFirst("e"); list.addFirst("a"); list.addFirst("n");
       list.add(1, "X"); list.add(3, "V");
        System.out.println(list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        Arraylist lst = new Arraylist();
        Arraylist lst2 = new Arraylist();
        //ArrayList<String> lst=new ArrayList<>();
        lst.add("Hello"); lst.add("World"); lst.add("item 3"); lst.add("item 4");
        lst.set(2,"Mads");
        lst.add(1,"Good");
        lst2.add("Hej"); lst2.add("Med"); lst2.add("Dig 3"); lst2.add("Nu 4");
        reverse(lst);
        reverse(lst2);
        for(int i=0;i<lst.size();i++)System.out.println(lst.get(i));

        Linkedlist llst =new Linkedlist();
        for(int i=0;i<lst2.size();i++)System.out.println(lst2.get(i));
    }
    static void reverse1(Arraylist lst){ //Denne kører i lineær tid
        int n = lst.size();
        for(int i = 0; i<n-1;i++){
            String v = lst.get(0);
            lst.remove(0);
            lst.add(n-1-i, v);
        }

    }

    static void reverse(Arraylist lst){
        int n = lst.size();
        for(int i=0; i<n/2;i++){
            String v=lst.get(i);
            lst.set(i,lst.get(n-i-1));
            lst.set(n-i-1,v);
        }
    }
}
class Arraylist{
    private String[] list = new String[4];
    private int size=0;
    public int size(){return size;}
    public void set(int i,String v){list[i]=v;}  //missing
    private void checkGrow(){
        if(size>=list.length){
            String[] tmp =new String[list.length*2];
            for(int j=0;j<list.length;j++)tmp[j]=list[j];
            list=tmp;
        }
    }
    public void add(int i, String v){checkGrow();
        for(int j=size-1;j>=i;j--){list[j+1]=list[j];}
        list[i]=v; size++;
    } //missing
    public void add(String v){checkGrow();list[size]=v; size++;}
    public String get(int i){return list[i];}
    public void remove(int i){
        for(int j=i+1;j<size;j++){
            list[j-1]=list[j];
        }
        size--;
    }
}
/*
Here is a version of ArrayLists for String
Add a method ”public void set(int i,String v)” that changes the value at position ”i”;
Add a method ”public void add(int i, String v)” that adds an element at position ”i”.
Change it so the array inside (list) grows if the list becomes longer than 10.
Make a new array which is longer, copy old content to the new array and set ”list” to point to this array.
*/

class Linkedlist{
    Node first;
    public String get (int i){

        Node n = first;
        while (i > 0) {
            n=n.next; i--;
        }
        return n.data;

    }
    public int size(){
        int sz=0;
        Node n=first;
        while(n!=null){n=n.next; sz++;}
        return sz;
    }
    public void addFirst(String v){
        Node n=new Node();
        n.next=first;
        n.data=v;
        first=n;
    }
    public void add(int i, String v){
        if (i== 0){
            addFirst(v); return;}
            //find node prior to insertion point
            Node p = first;
            while(i>1){
                p=p.next; i--; }
            Node n = new Node();
            n.data = v;
            n.next = p.next;
            p.next = n;


    } //missing
    public void remove(int i){} //missing

}
class Node{
    String data;
    Node next;
}

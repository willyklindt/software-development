public class ShortQueue {
    private String s;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    void put(String s){ 
        this.s = s;
    }
String take(){return s;}
boolean isFull(){return s != null;} 
}

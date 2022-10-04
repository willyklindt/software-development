public class Ovelse1{
    public static void main(String[] args) {
        Array newArray = new Array();
        newArray.add(0, "Hej");
        newArray.add(1, "Med");
        newArray.add(2, "Dig");
        newArray.add(3, "Min");
        newArray.add(4, "Ven,");
        newArray.add(5, "Hvordan");
        newArray.add(6, "Går");
        newArray.add(7, "Det");
        newArray.add(8, "Med");
        newArray.add(9, "Dig");
        newArray.add(10, "Nu virker det");
        //newArray.add(10, "Her for tiden?");

    }
}

class Array{
    private String[] list = new String[10];
    private int size = 0;

    public int id;
    public String name;

    public int size(){
        return size;
        }

    public void add(int i, String v){  
        String[] tempArray = new String[20];
        if (size > 10){
          for (int index = 0; index < list.length; index++) {
                size++;
                tempArray[index] = list[index];
            }
            list = tempArray;
            for (String hej : tempArray) {
                System.out.println(hej);
            }
        }
        list[i]=v; 
    }


    public String get(int i){
        return list[i];
        }

    public void remove(int i){
        for(int j=i+1;j<size;j++)list[j-1]=list[j]; size--;
        }
    

public void set(int i, String v){
    
        for (int index = 0; index <= i; index++) {
            if ( index == i){
            }
        }
    }
}

                    
            
    
    








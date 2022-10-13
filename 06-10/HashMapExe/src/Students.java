public class Students implements Comparable<Students> {
    private String name;
    private  int Age;
    private char sex;
    public Students(String n, int a, char s){
        this.name = n;
        this.Age = a;
        this.sex = s;
    }
    public void setSex(char sex){
        this.sex = sex;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.Age = age;
    }

    public String getName(){
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return Age;
    }

    @Override
    public int compareTo(Students o) {
        if (this.Age < o.getAge())
            return -1;
        if (this.getAge() > o.getAge())
            return  1;

        return 0;
    }
    @Override
    public int hashCode(){
        return Age;
    }
}

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<Students, Integer> ObjectStudents = new HashMap<Students, Integer>();
        Students A = new Students("Albert", 23, 'M');
        Students B = new Students("Berta", 22, 'F' );
        Students C = new Students("Robert", 27, 'M');
        Students D = new Students("Aisha", 15, 'F' );

        System.out.println(" Alberts Hash code is: " + A.hashCode());

        ObjectStudents.put(A, 7 );
        ObjectStudents.put(B, 7);
        ObjectStudents.put(C, 12);
        ObjectStudents.put(D, 10);

        Iterator it = ObjectStudents.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Students, Integer> pair = (Map.Entry) it.next();
            Students student = pair.getKey();
            Integer studentGrade = pair.getValue();
            System.out.println("Student: " + student.getName() + ". Age: " + student.getAge() + ", sex: " + student.getSex() + ", grade: " + studentGrade);
        }

    }
}

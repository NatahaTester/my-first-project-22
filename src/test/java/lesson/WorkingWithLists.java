package lesson;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    @Test
    public void createAndWorkingWithLists() {
        Student valera = new Student();
        valera.setFirstName("Valera1");
        valera.setLastName("Tester");
        valera.setEmail("valerun@test.lv");
        valera.setPhone("+37123232323");

        Student liga = new Student("Liga2", "Ivanova", "liga@test.lv", "+37198989898");
        Student vova = new Student("Vovan2", "Lisij", "boldhead@tester.lv", "+37129282726");
        Student tom = new Student("Tomas2", "", "Kruz", "+37123456789");

        List<Student> students = new ArrayList<>();
        students.add(valera);  //0
        students.add(liga);    //1
        students.add(vova);    //2
        students.add(tom);     //3

        //-----------FOR---------------

        for (int i = 0; i < 2; i++) {   //i = i + 1
            System.out.println(students.get(i).getFirstName());
        }
        for (int i = 0; i < students.size(); i++) {   //appears all elements(students) from list
            System.out.println(students.get(i).getFirstName());
        }
        //----------FOREACH---------

        for (Student s : students) {
            System.out.println(s.getFirstName());
        }
        for (Student s : students) {
            System.out.println(s.getFirstName() + " " + s.getLastName()); //add plus one infoline
            System.out.println(s.getFullName());  // custom metod
        }

        //----FOREACH WITH IF----------
        System.out.println("Printing students with phone nr starting with +371:");
        for (Student s : students) {
            if (s.getPhone().startsWith("+371")) {
                System.out.println(s.getFullName());
            }
        }
    }
}



public class Person implements Comparable<Person> {
    public int index;
    public String name;
    public String surname;
    public int age;

    Person(int numberI, String first_name, String last_name, int numberA){
        this.index = numberI;
        this.name = first_name;
        this.surname = last_name;
        this.age = numberA;
    }

    public int compareTo(Person p){
        if(index>p.index){
            return 1;
        }
        else{
            if(index<p.index){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}

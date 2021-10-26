import java.util.*;
import java.util.Scanner;

public class Console {
    private static final String MENU =
            "    M E N U   G Ł Ó W N E  \n" +
                "1 - Podaj dane nowej osoby \n" +
                "2 - Usuń dane osoby        \n" +
                "3 - Wypisz wszystkie osoby   \n" +
                "4 - Porównaj kolekcje       \n" +
                "0 - Zakończ program        \n" +
                "==>> ";

    // zmienne pomocnicze
    Scanner reader = new Scanner(System.in);
    private static int option;
    private static int addIndex = 0;

    // kolekcje
    private static final Set<Person> setHS = new HashSet<>();
    private static final Set<Person> setTS = new TreeSet<>();

    private static final List<Person> listAL = new ArrayList<>();
    private static final List<Person> listLL = new LinkedList<>();

    private static final Map<Integer, Person> mapHM = new HashMap<>();
    private static final Map<Integer, Person> mapTM = new TreeMap<>();

    // main
    public static void main(String[] args) {
        Console app = new Console();
        app.runMainLoop();
        System.exit(0);
    }

    // pętla menu głównego
    public void runMainLoop(){
        while(true){
            System.out.print("\n"+MENU);
            option = reader.nextInt();
            switch(option){
                case 1:
                    addPerson();
                    addIndex++;
                    break;
                case 2:
                    removePerson();
                    break;
                case 3:
                    showPerson();
                    break;
                case 4:
                    comparePerson();
                    break;
                case 0:
                    System.out.print("\nProgram zakończył działanie.");
                    System.exit(0);
            }
        }
    }

    // dodawanie osób
    public void addPerson(){
        System.out.print("Podaj imię: ");
        String name = reader.next();
        System.out.print("Podaj nazwisko: ");
        String surname = reader.next();
        System.out.print("Podaj wiek: ");
        int age = reader.nextInt();
        Person person = new Person(addIndex, name, surname, age);
        setHS.add(person);
        setTS.add(person);
        listAL.add(person);
        listLL.add(person);
        mapHM.put(addIndex, person);
        mapTM.put(addIndex, person);
    }

    // usuwanie osób
    public void removePerson(){
        System.out.print("Podaj indeks osoby do usunięcia: ");
        int removeIndex = reader.nextInt();
        for (Person person : setHS) {
            if(person.index == removeIndex) {
                setHS.remove(person);
                break;
            }
        }
        for (Person person : setTS) {
            if(person.index == removeIndex) {
                setTS.remove(person);
                break;
            }
        }

        listAL.remove(removeIndex);
        listLL.remove(removeIndex);

        mapHM.remove(removeIndex);
        mapTM.remove(removeIndex);
    }

    // wypisywanie osób
    public void showPerson(){
        System.out.print(
                "Którą kolekcje wyświetlić?\n" +
                "1 - HashSet\n" +
                "2 - TreeSet\n" +
                "3 - ArrayList\n" +
                "4 - LinkedList\n" +
                "5 - HashMap\n" +
                "6 - TreeMap\n"
        );
        option = reader.nextInt();
        switch(option){
            case 1:
                for (Person person : setHS) {
                    System.out.print(
                            "\nIndeks: " + person.index + "\n" +
                            "Imię: " + person.name + "\n" +
                            "Nazwisko: " + person.surname + "\n" +
                            "Wiek: " + person.age + "\n"
                    );
                }
                break;
            case 2:
                for (Person person : setTS) {
                    System.out.print(
                            "\nIndeks: " + person.index + "\n" +
                            "Imię: " + person.name + "\n" +
                            "Nazwisko: " + person.surname + "\n" +
                            "Wiek: " + person.age + "\n"
                    );
                }
                break;
            case 3:
                for (Person person : listAL) {
                    System.out.print(
                            "\nIndeks: " + person.index + "\n" +
                            "Imię: " + person.name + "\n" +
                            "Nazwisko: " + person.surname + "\n" +
                            "Wiek: " + person.age + "\n"
                    );
                }
                break;
            case 4:
                for (Person person : listLL) {
                    System.out.print(
                            "\nIndeks: " + person.index + "\n" +
                            "Imię: " + person.name + "\n" +
                            "Nazwisko: " + person.surname + "\n" +
                            "Wiek: " + person.age + "\n"
                    );
                }
                break;
            case 5:
                for (int i : mapHM.keySet()){
                    Person person = mapHM.get(i);
                    System.out.print(
                            "\nIndeks: " + person.index + "\n" +
                            "Imię: " + person.name + "\n" +
                            "Nazwisko: " + person.surname + "\n" +
                            "Wiek: " + person.age + "\n"
                    );
                }
                break;
            case 6:
                for (int i : mapTM.keySet()){
                    Person person = mapTM.get(i);
                    System.out.print(
                            "\nIndeks: " + person.index + "\n" +
                            "Imię: " + person.name + "\n" +
                            "Nazwisko: " + person.surname + "\n" +
                            "Wiek: " + person.age + "\n"
                    );
                }
                break;
            case 0:
                break;
        }
    }

    public void comparePerson(){
        System.out.print(
                "Jaka jest pierwsza kolekcja do porównania?\n" +
                "1 - HashSet\n" +
                "2 - TreeSet\n" +
                "3 - ArrayList\n" +
                "4 - LinkedList\n" +
                "5 - HashMap\n" +
                "6 - TreeMap\n"
        );
        Collection<Person> copy1 = null;
        Map<Integer, Person> copy1M = null;
        option = reader.nextInt();
        switch (option){
            case 1:
                copy1 = new HashSet<>(setHS);
                break;
            case 2:
                copy1 = new TreeSet<>(setTS);
                break;
            case 3:
                copy1 = new ArrayList<>(listAL);
                break;
            case 4:
                copy1 = new LinkedList<>(listLL);
                break;
            case 5:
                copy1M = new HashMap<>(mapHM);
                break;
            case 6:
                copy1M = new TreeMap<>(mapTM);
                break;
            case 0:
                break;
        }
        System.out.print(
                "Jaka jest druga kolekcja do porównania?\n" +
                "1 - HashSet\n" +
                "2 - TreeSet\n" +
                "3 - ArrayList\n" +
                "4 - LinkedList\n" +
                "5 - HashMap\n" +
                "6 - TreeMap\n"
                );
        Collection<Person> copy2 = null;
        Map<Integer, Person> copy2M = null;
        option = reader.nextInt();
        switch (option){
            case 1:
                copy2 = new HashSet<>(setHS);
                break;
            case 2:
                copy2 = new TreeSet<>(setTS);
                break;
            case 3:
                copy2 = new ArrayList<>(listAL);
                break;
            case 4:
                copy2 = new LinkedList<>(listLL);
                break;
            case 5:
                copy2M = new HashMap<>(mapHM);
                break;
            case 6:
                copy2M = new TreeMap<>(mapTM);
                break;
            case 0:
                break;
        }
        if(copy1 != null && copy2 != null){
            if(copy1.equals(copy2))
                System.out.print("\nWartości identyczne według metody equals\n");
            else
                System.out.print("\nWartości różne według metody equals\n");
            System.out.print("Wartośi hashCode:\n" + copy1.hashCode() + "\n" + copy2.hashCode() + "\n");
        }
        if(copy1 != null && copy2M != null){
            if(copy1.equals(copy2M))
                System.out.print("\nWartości identyczne według metody equals\n");
            else
                System.out.print("\nWartości różne według metody equals\n");
            System.out.print("Wartośi hashCode:\n" + copy1.hashCode() + "\n" + copy2M.hashCode() + "\n");
        }
        if(copy1M != null && copy2 != null){
            if(copy1M.equals(copy2))
                System.out.print("\nWartości identyczne według metody equals\n");
            else
                System.out.print("\nWartości różne według metody equals\n");
            System.out.print("Wartośi hashCode:\n" + copy1M.hashCode() + "\n" + copy2.hashCode() + "\n");
        }
        if(copy1M != null && copy2M != null){
            if(copy1M.equals(copy2M))
                System.out.print("\nWartości identyczne według metody equals\n");
            else
                System.out.print("\nWartości różne według metody equals\n");
            System.out.print("Wartośi hashCode:\n" + copy1M.hashCode() + "\n" + copy2M.hashCode() + "\n");
        }
    }
}

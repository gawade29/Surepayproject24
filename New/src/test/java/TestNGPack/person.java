package TestNGPack;

public class person {
    private String name;
    private int age;

    // Constructor, getters, and setters
    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

class JsonCreationExample 
{
    public static void main(String[] args) throws Exception {
        person person = new person("Jane Doe", 25);
        
        
        person.setName("Swap");
        System.out.println(person.getName());
    }
}



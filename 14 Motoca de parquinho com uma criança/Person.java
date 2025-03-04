public class Person {
    private int age;
    private String name;
    
    public Person(String name, int number){
        this.name = name;
        this.age = number;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String toString(){
        return getName() + ":" + getAge();
    }
}
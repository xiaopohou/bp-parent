package reflection;

/**
 * Created by Administrator on 2017-11-24.
 */
public class Person {

    private String name;

    private Integer age;

    private String gender;

    public void sayHello(){
        System.out.println("hello");
    }

    public void eat(){
        System.out.println("eat");
    }

    public int add(int a,int b){
        return a+b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public Person() {
    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}

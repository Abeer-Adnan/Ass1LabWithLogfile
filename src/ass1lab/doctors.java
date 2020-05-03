/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1lab;

/**
 *
 * @author rant
 */
public class doctors {
    private Integer id;
    private String name;
    private Integer age;
    private String  specialization;

    public doctors(){
        
    }
    public doctors(Integer doctorid, String name, Integer age, String specialization) {
        this.id = doctorid;
        this.name = name;
        this.age = age;
        this.specialization = specialization;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
return String.format("%-5s %-10s %-5s %-5s", id, name, age, specialization);  
    }
    
    
}

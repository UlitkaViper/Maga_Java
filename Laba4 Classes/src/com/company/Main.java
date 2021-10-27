package com.company;

public class Main {

    public static void main(String[] args) {

        Employee[] empArr = new Employee[5];
        empArr[0] = new Employee("Maks", "Razrab", "test@mail.ru",
                "123456789", 50000, 25, true);
        empArr[1] = new Employee("Biba", "HR", "Biba@mail.ru",
                "123473256", 20000, 30, false);
        empArr[2] = new Employee("Boba", "HR", "Boba@mail.ru",
                "123445676", 30000, 29, false);
        empArr[3] = new Employee("Petr", "Engineer", "Petr@mail.ru",
                "123474573", 60000, 27, true);
        empArr[4] = new Employee("Alex", "Manager", "Alex@mail.ru",
                "123789454", 100000, 26, true);

        for (int i = 0; i < 5; i++){
            if (empArr[i].is_vacinated){
                empArr[i].info();
                System.out.println("____________________________________");
            }
        }
    }
}

class Employee {
    String name;
    String position;
    String email;
    String phone;
    double salary;
    int age;
    boolean is_vacinated;

    public Employee(String name, String position, String email, String phone,
                    double salary, int age, boolean is_vacinated)
    {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.is_vacinated = is_vacinated;
    }

    public void info(){
        System.out.println("Имя: " + this.name + "\nДолжность: " + this.position +
                "\nПочта: " + this.email + "\nТелефон: " + this.phone +
                "\nЗарплата: " + this.salary + "\nВозраст: " + this.age);
    }
}

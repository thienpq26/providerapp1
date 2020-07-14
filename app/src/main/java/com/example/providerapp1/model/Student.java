package com.example.providerapp1.model;

public class Student {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;

    /**
     * The default constructor
     */
    public Student() {
    }

    /**
     * The constructor include full parameter of student
     *
     * @param id      The id of the student
     * @param name    The name of the student
     * @param phone   The phone of the student
     * @param address The address of the student
     * @param email   The email of the student
     */
    public Student(int id, String name, String phone, String address, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    /**
     * The constructor does not include the student id
     *
     * @param name    The name of the student
     * @param phone   The phone of the student
     * @param address The address of the student
     * @param email   The email of the student
     */
    public Student(String name, String phone, String address, String email) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    /**
     * Method get id of the student
     *
     * @return The id of the student
     */
    public int getId() {
        return id;
    }

    /**
     * Method get name of the student
     *
     * @return The name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Method set name of the student
     *
     * @param name The name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method get phone of the student
     *
     * @return The phone of the student
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method set phone of the student
     *
     * @param phone The phone of the student
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Method get address of the student
     *
     * @return The address of the student
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method set address of the student
     *
     * @param address The address of the student
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method get email of the student
     *
     * @return The email of the student
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method set email of the student
     *
     * @param email The email of the student
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.zenon.zenontest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="contactform")
public class ContactForm {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int empId;

        @NotBlank(message="Name can not be empty..")
        @Size(min=3,max=30,message="Name must be between 3 to 30 !!")
        @Column(name="Name")
        private String name;

        @NotBlank(message="Phone Name can not be empty..")
        @Column(name="phone")
        private String phone;

        @NotBlank(message="Email can not be empty..")
        @Size(min=3,max=30,message="Email must be between 3 to 30 !!")
        @Column(name="Email")
        private String email;

        @NotBlank(message="Query can not be empty..")
        @Size(min=3,max=120,message="Query must be between 3 to 120 !!")
        @Column(name="query")
        private String query;


        public ContactForm() {
            super();
        }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
        public String toString() {
            return "Employee [empId=" + empId + ", name=" + name + ", companyName=" + phone + ", email=" + email
                    + ", password=" + query + "]";
        }
        public ContactForm(int empId,
                        @NotBlank(message = "Name can not be empty..") @Size(min = 3, max = 30, message = "Name must be between 3 to 30 !!") String name,
                        @NotBlank(message = "Phone number can not be empty..") String companyName,
                        @NotBlank(message = "Email can not be empty..") @Size(min = 3, max = 30, message = "Email must be between 3 to 30 !!") String email,
                        @NotBlank(message = "Query can not be empty..") @Size(min = 3, max = 12, message = "Query must be between 3 to 12 !!") String password)
                        {
            super();
            this.empId = empId;
            this.name = name;
            this.phone = companyName;
            this.email = email;
            this.query = password;
        }



    }



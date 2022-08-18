package com.zenon.zenontest;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="user")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    @NotBlank(message="Name can not be empty..")
    @Size(min=3,max=30,message="Name must be between 3 to 30 !!")
    @Column(name="Name")
    private String name;

    @NotBlank(message="Company Name can not be empty..")
    @Column(name="Company_Name")
    private String companyName;

    @NotBlank(message="Email can not be empty..")
    @Size(min=3,max=30,message="Email must be between 3 to 30 !!")
    @Column(name="Email")
    private String email;

    @NotBlank(message="Password can not be empty..")
    @Size(min=3,max=120,message="Password must be between 3 to 120 !!")
    @Column(name="Password")
    private String password;

    @AssertTrue(message="Must agree terms and condition !!")
    private boolean agreed;

    public Employee(String password) {
        super();
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreed() {
        return agreed;
    }
    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }


    public Employee() {
        super();
    }
    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", companyName=" + companyName + ", email=" + email
                + ", password=" + password + ", agreed=" + agreed + "]";
    }
    public Employee(int empId,
                    @NotBlank(message = "Name can not be empty..") @Size(min = 3, max = 30, message = "Name must be between 3 to 30 !!") String name,
                    @NotBlank(message = "Company Name can not be empty..") String companyName,
                    @NotBlank(message = "Email can not be empty..") @Size(min = 3, max = 30, message = "Email must be between 3 to 30 !!") String email,
                    @NotBlank(message = "Password can not be empty..") @Size(min = 3, max = 12, message = "Password must be between 3 to 12 !!") String password,
                    @AssertTrue(message = "Must agree terms and condition !!") boolean agreed) {
        super();
        this.empId = empId;
        this.name = name;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.agreed = agreed;
    }



}

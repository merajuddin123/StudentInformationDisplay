package com.zenon.zenontest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class UserController {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ContactRepo contactRepo;

//    @GetMapping("/contact")
//    public String contact() {
//        return "contact";
//    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/index")
    public String form() {
        return "index";
    }

    @GetMapping("/form")
    public String register(Model m) {
        m.addAttribute("empl",new Employee());
        return "form";
    }

    @PostMapping("/register")
    public String processForm(@Valid @ModelAttribute("empl") Employee employee, BindingResult result, Model model, HttpSession session)
    {
        try {

            if(result.hasErrors()) {
                throw new Exception("Something went wrong !!");
            }

            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            Employee emp=this.userRepository.save(employee);
            model.addAttribute("empl",new Employee());

            System.out.println(emp);
            session.setAttribute("message", new Message("Successfully Registered !! ","alert-success"));
            return "form";
        }
        catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("empl",employee);
            session.setAttribute("message", new Message("Something went wrong !! ","alert-danger"));
            return "form";}
    }

    @GetMapping("/contact")
    public String query(Model m) {
        m.addAttribute("empl",new ContactForm());
        return "contact";
    }

    @PostMapping("/query")
    public String queryForm(@Valid @ModelAttribute("empl") ContactForm contact, BindingResult result, Model model, HttpSession session)
    {
        try {

            if(result.hasErrors()) {
                throw new Exception("Something went wrong !!");
            }
            ContactForm emp=this.contactRepo.save(contact);
            model.addAttribute("empl",new ContactForm());

            System.out.println(emp);
            session.setAttribute("message", new Message("Successfully Registered !! ","alert-success"));
            return "contact";
        }
        catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("empl",contact);
            session.setAttribute("message", new Message("Something went wrong !! ","alert-danger"));
            return "contact";}
    }


    @GetMapping("/login")
    public String signup(Model m) {
        m.addAttribute("empl",new Employee());
        return "login";
    }

    @GetMapping("/details")
    public String details(Model m, Principal prin) {
        String userName=prin.getName();
        System.out.println("Arsad Reza"+userName);
        Employee employee=userRepository.getEmployeeEmail(userName);
        System.out.println(employee);
        m.addAttribute("employee",employee);
        return "details";
    }

    @GetMapping("/admin")
        public String showDetails(Model m) {
            List<Employee> empl=userRepository.findAll();
            m.addAttribute("employ1",empl);
            return "show";
        }

    @GetMapping("/delete/{empid}")
    public String deleteemployee(@PathVariable("empid") Integer eid,Model m, HttpSession session) {
        Optional<Employee> findbyid= this.userRepository.findById(eid);
        Employee emp=findbyid.get();
        this.userRepository.delete(emp);
        session.setAttribute("message", new Message("Contact deleted Successfully...","success"));
        return "redirect:/admin";
    }

    @PostMapping("/update-emp/{eid}")
    public String editForm(@PathVariable("eid") Integer eid,Model m) {
        m.addAttribute("title","Update Employee");
        Employee emp=this.userRepository.findById(eid).get();
        m.addAttribute("employ",emp);
        return "Edit_Form";
    }
    //Edit Handler
    @PostMapping("/Edit_Form2")
    public String edithandler(@ModelAttribute() Employee employ,Principal prin) {
        try {
            int id=employ.getEmpId();
            Employee emp=this.userRepository.getEmployeeById(id);
            emp.setEmail(employ.getEmail());
            emp.setName(employ.getName());
            emp.setCompanyName(employ.getCompanyName());
            emp.setPassword(passwordEncoder.encode(employ.getPassword()));
            this.userRepository.save(emp);

        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception Arsad\n\n\n"+e);
        }
        return "redirect:/admin";
    }
}

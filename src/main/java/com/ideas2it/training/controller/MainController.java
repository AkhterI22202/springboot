package com.ideas2it.training.controller;

import com.ideas2it.training.constants.Constants;
import com.ideas2it.training.model.Employee;
import com.ideas2it.training.model.LeaveRecords;
import com.ideas2it.training.services.employee.EmployeeServices;
import com.ideas2it.training.services.leaveRecords.LeaveServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private LeaveServices leaveServices;

    @Autowired
    Constants constants;
//
//    @Autowired
//    private ProjectServices projectServices;

    @GetMapping("/home")
    public String Welcome(){
        System.out.println("hello");
        return "index";
    }
    @GetMapping("/login")
    public String LoginCred(){
        return "login";
    }

    @GetMapping(path = "/getEmployees")
    public String GetEmployees(Model model) throws Exception {
        //System.out.println(employee);
        //List<Employee> emp = employeeServices.getEmployees();
        List<Employee> employees = employeeServices.getEmployees();
        if(employees.size()!=0) {
            model.addAttribute("employees", employees);
            return "view_employees";
        } else {
            model.addAttribute("message", "Sorry ! Employee Database is empty");
            return "index";
        }
    }

    @GetMapping(path = "/searchEmployee")
    public String searchEmployee(Model model ,@RequestParam String employeeId) throws Exception {
        Employee employee = employeeServices.getEmployee(employeeId);
        if(employee!=null) {
            model.addAttribute("employee", employee);
            return "view_employee";
        } else {
            model.addAttribute("message","Employee doesnot exist");
            return "index";
        }
    }


    @GetMapping(path = "/employeeMenu")
    public String employeeMenu() {
        return "employee_menu";
    }
//
    @GetMapping(path = "/insertEmployee")
    public String viewInsertEmployee() {
        return "add_employee";
    }
    @GetMapping(path = "/searchEmployeePage")
    public String searchEmployeePage() {
        return "get_employee";
    }


    @GetMapping(path = "/insertEmployeeData")
    public String insertEmployee(@ModelAttribute Employee employee, Model model) throws Exception {
        System.out.println("hello");
        String message = employeeServices.addEmployee(employee);
        model.addAttribute("message",message);
        System.out.println(message);
        return "index";
    }

    @GetMapping(path="/updateMyEmployee")
    public String updateEmployee(@RequestParam String employeeId, Model model)  {
        Employee employee = employeeServices.getEmployee(employeeId);
        if(employee!=null) {
            model.addAttribute("employee", employee);
            return "add_employee";
        } else {
            model.addAttribute("message","Employee does not Exixt");
            return "index";
        }
    }
//
//    @GetMapping(path="/deleteEmployee")
//    public String deleteEmployee(@RequestParam String employeeId, Model model) throws Exception {
//        String message =  "";
//        Employee employee = employeeServices.getEmployee(employeeId);
//        if(employee!=null) {
//            boolean status = employeeServices.deleteEmployee(employee);
//            if (status) {
//                message = "Employee deleted successfully";
//            } else {
//                message = "Couldn't delete";
//            }
//        } else {
//            message = "Employee does not exist";
//        }
//        model.addAttribute("message",message);
//        return "index";
//
//    }

    @GetMapping(path = "/getLeaves")
    public String getLeaves(Model model) {
        List<LeaveRecords> leaves = leaveServices.getLeaveRecords();
        if(leaves.size()!=0) {
            model.addAttribute("leaves",leaves);
            return "view_leaves";
        } else {
            model.addAttribute("message","No leaves in Database");
            return "index";
        }
    }

    @GetMapping(path = "/getLeave")
    public String getLeave(@RequestParam int leaveId,Model model) {
        LeaveRecords leave = leaveServices.getLeaveByLeaveId(leaveId);
        if(leave!=null) {
            model.addAttribute("leave",leave);
            return "view_leave";
        } else {
            model.addAttribute("message","No leaves in Database");
            return "index";
        }
    }


    @GetMapping("/leaveMenu")
    public String leaveMenu() {
        return "leaves_menu";
    }

    @GetMapping("/insertLeavePage")
    public String insertLeavePage(Model model) {
        return "add_leave";
    }


    @GetMapping(path = "/insertLeave")
    public String insertLeaveRecord(@ModelAttribute LeaveRecords leave,@RequestParam String employeeId,Model model) {
        String message = "";
        Employee employee = employeeServices.getEmployee(employeeId);
        if(employee!=null) {
            leave.setEmployee(employee);
            message = leaveServices.addLeaveRecord(leave);
            if(message.equals(constants.DATA_NOT_SAVED) || message.equals(constants.DATA_SAVED)) {
                model.addAttribute("message", message);
                System.out.println(message);
                return "index";
            }
        } else {
            message = "Employee does not exist";
        }
        model.addAttribute("leave",leave);
        model.addAttribute("message",message);
        System.out.println(message);
        return "add_leave";
    }

    @GetMapping("/updateLeave")
    public String updateLeaveRecord(@RequestParam Integer leaveId, Model model) {
        LeaveRecords leave = leaveServices.getLeaveByLeaveId(leaveId);
        if(leave!=null){
            model.addAttribute("leave",leave);
            return "add_leave";
        } else {
            model.addAttribute("message","leave Record doesnot exist");
            return "index";
        }
    }


}
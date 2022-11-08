package com.ideas2it.training.services.employee.impl;

import com.ideas2it.training.dao.EmployeeDao;
import com.ideas2it.training.model.Employee;
import com.ideas2it.training.model.Project;
import com.ideas2it.training.services.employee.EmployeeServices;
import com.ideas2it.training.utils.UtilDateTime;
import com.ideas2it.training.utils.Validiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
    @Autowired
    private UtilDateTime utilDateTime;
    @Autowired
    Validiator validiator;

   @Autowired
   private EmployeeDao employeeDaoRepo;
////    EmployeeDao employeeDao = new EmployeeDao();



    public String addEmployee(@Autowired Employee employee) {
        String message = "";
        List<String> inputErrors = validiator.checkEmployeeRegisterInputs(employee);
        if (inputErrors.size()==0) {

            if(employee.getEmployeeId().equals("")) {
                String emailStatus = emailAlreadyExists(employee.getEmail());
                if(emailStatus!=null) {
                    return emailStatus;
                }
                employee.setEmployeeId(generateEmployeeId());
                employee.setCreatedAt(utilDateTime.getCurDateTime());
            } else {
                String emailStatus = emailAlreadyExists(employee.getEmail(),employee.getEmployeeId());
                if(emailStatus!=null) {
                    return emailStatus;
                }
                Employee temp = employeeDaoRepo.findById(employee.getEmployeeId()).get();
                employee.setCreatedAt(temp.getCreatedAt());
            }
            employee.setModifiedAt(utilDateTime.getCurDateTime());
            employee.setIsDeleted(false);
            Employee employee1 = (Employee) employeeDaoRepo.save(employee);
            if (employee1!=null) {
                message = "Employee Data saved";
            } else {
                message = "Employee was not Registered , Try Again";
            }
        } else {
            for(String str:inputErrors){
                message += "{"+ str +"}";
            }
        }
        return message;
    }

    public String emailAlreadyExists(String email,String employeeId) {
//        Employee employee = employeeDao.(email);
//        if(employee!= null && !employee.getEmployeeId().equals(employeeId)) {
//            System.out.println("1");
//            return "Email Already Exists with EmployeeId = " + employee.getEmployeeId();
//
//        } else
            return null;
    }

    public String emailAlreadyExists(String email) {
//        Employee employee = employeeDao.(email);
//        if(employee!= null)
//            return "Email Already Exists with EmployeeId = "+employee.getEmployeeId();
//        else
            return null;
    }

    public List<Employee> getEmployees() {

        List<Employee> employees = employeeDaoRepo.findAll();
        return employees;

    }


    @Override
    public Employee getEmployee(String employeeId) {
        Optional<Employee> employeeOp = employeeDaoRepo.findById(employeeId);
        if (!employeeOp.isEmpty()){
            Employee employee = employeeOp.get();
            System.out.println(employee);
            return employee;
        }  else {
            return null;
        }
    }

    @Override
    public Employee getEmployeeLeaves(String employeeId) {

//        return employeeDao.getEmployeeLeaves(employeeId);
        return null;
    }

    @Override
    public Employee getEmployeeProjects(String employeeId) {

//        return employeeDao.getEmployeeProjects(employeeId);
        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) {

//        return employeeDao.updateEmployee(employee);
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        //leaveDao.deleteLeaveRecord(employee.getEmployeeId());
        //projectDao.deleteProject(employee.getEmployeeId());
//        return employeeDao.deleteEmployee(employee);
        return false;
    }

    public String getLastEmployee() {

//        return employeeDao.getLastEmployee();
        return null;
    }

    public String generateEmployeeId() {
        String employeeId;
        String prefixId = "I2IT";
        String postfixId = "";

        String lastId = getLastEmployee();
        if (lastId == null) {
            employeeId = prefixId + 100;
        } else {
            for (int i = prefixId.length(); i < lastId.length(); i++)
                postfixId += lastId.charAt(i);
            int num = Integer.parseInt(postfixId) + 1;
            employeeId = prefixId + num;
        }
        return employeeId;
    }

    public boolean assignProject(Project project) {

//        return employeeDao.assignProject(project);
        return false;
    }

}


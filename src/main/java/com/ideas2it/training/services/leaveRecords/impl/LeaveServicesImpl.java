package com.ideas2it.training.services.leaveRecords.impl;

import com.ideas2it.training.constants.Constants;
import com.ideas2it.training.dao.LeaveRecordsDao;
import com.ideas2it.training.model.LeaveRecords;
import com.ideas2it.training.services.leaveRecords.LeaveServices;
import com.ideas2it.training.utils.UtilDateTime;
import com.ideas2it.training.utils.Validiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveServicesImpl implements LeaveServices {

    @Autowired
    private LeaveRecordsDao leaveDaoRepo;
    @Autowired
    Validiator validiator;
    @Autowired
    private UtilDateTime utilDateTime;
    @Autowired
    Constants constants;

    @Override
    public String addLeaveRecord(LeaveRecords leaveRecord) {
        String message = "";
        System.out.println(leaveRecord);
        List<String> errors = validiator.checkLeaveInputErrors(leaveRecord);
        if(errors.size()==0){
            if(leaveRecord.getLeaveId() == null) {
                leaveRecord.setCreatedAt(utilDateTime.getCurDateTime());
                leaveRecord.setIsDeleted(false);
            } else {
                LeaveRecords temp = (LeaveRecords) leaveDaoRepo.findById(leaveRecord.getLeaveId()).get();
                leaveRecord.setCreatedAt(temp.getCreatedAt());
                leaveRecord.setIsDeleted(temp.getIsDeleted());
            }
            System.out.println(leaveRecord);
            leaveRecord.setModifiedAt(utilDateTime.getCurDateTime());
            LeaveRecords leave = (LeaveRecords) leaveDaoRepo.save(leaveRecord);   //save(leaveRecord);
            if (leave!=null)
                message = constants.DATA_SAVED;
            else
                message = constants.DATA_NOT_SAVED;
        } else {
            for(String str:errors)
                message += "{"+str+"}";
        }
        return message;

    }


    @Override
    public List<LeaveRecords> getLeaveRecords() {
	    return leaveDaoRepo.findAll();

    }

    @Override
    public List<LeaveRecords> getLeaveRecord(String employeeId) {
    	//return leaveDaoRepo.findById(employeeId);
        return null;
    }

    @Override
    public boolean updateLeaveRecord(LeaveRecords leaveRecord) {
//	    return leaveDao.updateLeaveRecord(leaveRecord);
        return false;
    } 

    public int getLeaveCount(String employeeId) {
//	List<LeaveRecords> leaveRecords= getLeaveRecord(employeeId);
//        int leaveSum = 0;
//        int curYear = LocalDate.now().getYear();
//
//        LocalDate min = LocalDate.parse(curYear-1+"-12-30"); //end of last year
//        LocalDate max = LocalDate.parse(curYear+"-12-30");   //end of current year
//
//        for (LeaveRecords record: leaveRecords) {
//            LocalDate fromDate = LocalDate.parse(record.getFromDate());
//            LocalDate toDate = LocalDate.parse(record.getToDate());
//
//            //fromDate.isAfter(min) && toDate.isBefore(max) && toDate.isAfter(min) && fromDate.isBefore(max)
//
//            if(fromDate.getYear() == toDate.getYear()){
//                leaveSum +=ChronoUnit.DAYS.between(fromDate,toDate);
//
//            }
//            else if(fromDate.isBefore(min) && toDate.isAfter(min) && toDate.isBefore(max)) {
//                leaveSum += ChronoUnit.DAYS.between(min, toDate);
//                //System.out.println(leaveSum);
//            }
//            else if(toDate.isAfter(max) && fromDate.isBefore(max) && fromDate.isAfter(min)) {
//                //System.out.println(max+" "+fromDate);
//                leaveSum += ChronoUnit.DAYS.between(fromDate,max);
//                //System.out.println(leaveSum);
//            }
//            else{
//                leaveSum = leaveSum;
//            }
//
//        }
//        return leaveSum;
        return 0;
    }
    @Override
    public LeaveRecords getLeaveByLeaveId(Integer leaveId) {
        LeaveRecords leave =null;
        Optional<LeaveRecords> leaveOp = leaveDaoRepo.findById(leaveId);
        if (leaveOp != null)
            leave = leaveOp.get();
        return leave;
    }

    public boolean deleteLeaveRecord(LeaveRecords leaveRecord) {
//        return leaveDao.deleteLeaveRecord(leaveRecord);
        return false;
    }

}


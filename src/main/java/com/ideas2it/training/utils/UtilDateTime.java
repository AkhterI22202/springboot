package com.ideas2it.training.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class UtilDateTime {

    public String getCurDateTime() {
        String curDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss"));
	return curDateTime;
    }  

}
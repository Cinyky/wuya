package com.wuya.cyy.utils;  
 /**
  * 自定义异常
  * Cinyky 
  *
  * 2017年3月21日上午8:49:05
  */
public class ServiceException extends Exception {  
    private static final long serialVersionUID = -1708015121235851228L;  
      
    public ServiceException(String message) {  
        super(message);  
    }  
} 
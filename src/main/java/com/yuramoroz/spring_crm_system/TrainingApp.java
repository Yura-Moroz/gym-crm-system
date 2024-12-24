package com.yuramoroz.spring_crm_system;

import com.yuramoroz.spring_crm_system.config.StorageConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TrainingApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StorageConfig.class);
    }
}

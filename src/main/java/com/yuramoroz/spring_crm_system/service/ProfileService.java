package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileService {
    private static final Map<String, Integer> logins = new HashMap<>();

    public static String generatePassword() {
        return PasswordGenerator.generateRandomPassword(10);
    }

    public static String generateUsername(User user) {
        String resultLogin = user.getFirstName() + "." + user.getLastName();

        if (logins.containsKey(resultLogin)) {
            int serialNumber = logins.get(resultLogin);
            logins.put(resultLogin, serialNumber + 1);
            resultLogin += serialNumber;
        }
        logins.put(resultLogin, 0);

        return resultLogin;
    }
}

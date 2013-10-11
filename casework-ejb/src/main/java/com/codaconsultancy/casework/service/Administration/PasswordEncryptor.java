package com.codaconsultancy.casework.service.Administration;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {

    private final static Logger LOGGER = Logger.getLogger(PasswordEncryptor.class);


    static String encrypt(String password) {
        String encryptedPassword = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            digest.reset();
            digest.update(password.getBytes());
            encryptedPassword = convertToHex(digest.digest());

        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException SHA1");
        }
        return encryptedPassword;
    }

    static String convertToHex(byte[] data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i % 4 == 0 && i != 0) {
                builder.append("");
            }
            int x = (int) data[i];
            if (x < 0) {
                x += 256;
            }
            if (x < 16) {
                builder.append("0");
            }
            builder.append(Integer.toString(x, 16));
        }
        return builder.toString();
    }
}
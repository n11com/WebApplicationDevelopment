package com.bau.blog;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class EncryptionUtils {

    public static String encrypt(String text){
        MessageDigest digest = null;
        byte[] hash = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(text.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException("Encryption problem: " + text, e);
        }

        return Hex.encodeHexString(hash);
    }
}

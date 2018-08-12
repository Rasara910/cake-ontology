package com.sw.ontology.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Created by praveen on 8/12/18
 */
public class EncryptPassword {

    public static String encript(String password) {
        Sha256Hash sha256Hash = new Sha256Hash(password);
        return sha256Hash.toHex();
    }

    public static void main(String[] args) {
        System.out.println(""+encript("123"));
    }
}

package com.demo.jbehave.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

    private static Utility SINGLE_INSTANCE = null;
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ID = "id";
    private static final String APPLICATION_JSON = "application/json";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String CITY = "City";
    private static final String DATE_OF_BIRTH = "DateOfBirth";
    private static final String CONTACT_NUMBER = "ContactNumber";
    private static final String ADDRESS = "Address";

    private Utility() {
    }

    public static Utility getInstance() {
        if (SINGLE_INSTANCE == null) {
            synchronized (Utility.class) {
                SINGLE_INSTANCE = new Utility();
            }
        }
        return SINGLE_INSTANCE;
    }

    public String getUrl(String path) {
        return readDataFromPropertyFile(path);
    }

    public String getAadharId(String id) {
        return readDataFromPropertyFile(id);
    }

    private String readDataFromPropertyFile(String path) {
        String data = "";
        try (InputStream input = new FileInputStream("src/test/resources/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            data = prop.getProperty(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;


    }


    public static String getContentType() {
        return CONTENT_TYPE;
    }

    public static String getApplicationJson() {
        return APPLICATION_JSON;
    }

    public static String getFirstName() {
        return FIRST_NAME;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static String getCity() {
        return CITY;
    }

    public static String getDateOfBirth() {
        return DATE_OF_BIRTH;
    }

    public static String getContactNumber() {
        return CONTACT_NUMBER;
    }

    public static String getAddress() {
        return ADDRESS;
    }

    public static String getId() {
        return ID;
    }
}






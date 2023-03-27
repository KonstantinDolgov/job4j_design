package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte bYte = 1;
        short sHort = 1000;
        int iNt = 7777777;
        long lOng = 9L;
        double dOuble = 3.14;
        float fLoat = 3.14f;
        char cHar = '!';
        boolean bOolean = true;
        LOG.debug("Primitive variables example: byte - {}, short - {}, int - {}, long - {},"
                + " double - {}, float - {}, char - {}, boolean - {}", bYte, sHort, iNt,
                lOng, dOuble, fLoat, cHar, bOolean);
    }
}
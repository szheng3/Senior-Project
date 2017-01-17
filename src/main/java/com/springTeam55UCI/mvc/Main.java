package com.springTeam55UCI.mvc;

import proguard.*;

import java.io.*;

/**
 * Created by Shuai Zheng on 11/21/16.
 */
public class Main {
    public void obfuscation(String[] args) {


//        // Create the default options.
        Configuration configuration = new Configuration();

        try {
            // Parse the options specified in the command line arguments.
            ConfigurationParser parser = new ConfigurationParser(args,
                    System.getProperties());
            try {
                parser.parse(configuration);
            } finally {
                parser.close();
            }

            // Execute ProGuard with these options.
            new ProGuard(configuration).execute();
        } catch (Exception ex) {
            if (configuration.verbose) {
                // Print a verbose stack trace.
                ex.printStackTrace();
            } else {
                // Print just the stack trace message.
                System.err.println("Error: " + ex.getMessage());
            }

        }


    }


}


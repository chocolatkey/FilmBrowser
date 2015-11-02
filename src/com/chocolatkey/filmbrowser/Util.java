/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chocolatkey.filmbrowser;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Henry Stark
 */
public class Util {
    //Vars

    /**
     * Program version
     */
    public static String version = "1.6.3 RC";

    //new dateformat
    /**
     * Date format: dd/MM/yyy HH:mm:ss Example: 20/05/1998 14:55:20
     */
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
    /**
     * Operating system name
     */
    public static String os = System.getProperty("os.name").toLowerCase();

    /**
     * System user home directory
     */
    public static String uhome = System.getProperty("user.home");

    /**
     * Application initialization directory
     */
    public static String udir = System.getProperty("user.dir");

    /**
     *
     * @return Computer device name (network)
     */
    public static String devname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @return Computer device IP address
     */
    public static String ip() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Architecture (amd64 or i386)
     */
    public static String arch = System.getProperty("os.arch");

    /**
     * OS username
     */
    public static String uname = System.getProperty("user.name");

    /**
     * System language
     */
    public static String lang = System.getProperty("user.language").toLowerCase();

    /**
     * Java Version
     */
    public static String java = System.getProperty("java.version");

    /**
     * OS Version
     */
    public static String osversion = System.getProperty("os.version");

    /**
     * OS name
     *
     * @return Name of OS
     */
    public static String osname() {
        if (isWindows()) {
            return "Windows";
        } else if (isMac()) {
            return "Mac";
        } else if (isUnix()) {
            return "Unix based";
        } else if (isSolaris()) {
            return "Solaris";
        } else {
            return "Unknown OS!";
        }
    }

    /**
     *
     * @return Is Windows
     */
    public static boolean isWindows() {
        return (os.indexOf("win") >= 0);
    }

    /**
     *
     * @return Is Mac
     */
    public static boolean isMac() {
        return (os.indexOf("mac") >= 0);
    }

    /**
     *
     * @return Is Unix
     */
    public static boolean isUnix() {
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0);
    }

    /**
     *
     * @return Solaris
     */
    public static boolean isSolaris() {
        return (os.indexOf("sunos") >= 0);
    }

    /**
     * Converts String[] to String separated by |
     *
     * @param arr String[] to convert
     * @return String built from array
     */
    public static String arraytoString(String[] arr) {
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s).append(" | ");
        }
        return builder.toString();

    }

    /**
     * Open the String as File with system default
     *
     * @param f String to open
     */
    public static void open(String f) {
        File o = new File(f);
        System.out.println("Opening: " + o);
        if (o.exists()) {
            try {
                Desktop.getDesktop().open(o);
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Datei nicht vorhanden!\n"
                    + "Haben Sie das Ordner gelöscht oder die Festplatte ausgesteckt?", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}

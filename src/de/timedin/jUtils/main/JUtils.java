package de.timedin.jUtils.main;

import javax.swing.*;

public class JUtils {
    public static final String prefix = "[Java-Utils-Library]: ";

    //Method to display message when JAR is run directly
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "This is a Java library, not an executable!\n\n" +
                "Das ist eine Java-Bibliothek, keine ausführbare Datei!" +
                "\n\n\n" +
                "More information at: https://www.timedin.de/tools/java_utils" +
                "\n" +
                "Mehr Informationen unter: https://www.timedin.de/tools/java_utils" +
                "", "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}

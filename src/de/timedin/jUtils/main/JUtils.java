package de.timedin.jUtils.main;

import javax.swing.*;

public class JUtils {
    public static final String prefix = "[Java-Utils-Library]: ";

    //Method to display message when JAR is run directly
    public static void main(String[] args) {
        String url = "https://github.com/timedin-de/JUtils/releases/new";
        JOptionPane.showMessageDialog(null, "This is a Java library, not an executable!" +
                "\n" +
                "More information at: "+url +
                "\n\n\n"+
                "Das ist eine Java-Bibliothek, keine ausführbare Datei!" +
                "\n" +
                "Mehr Informationen unter: "+url +
                "", "Fehler", JOptionPane.ERROR_MESSAGE);
    }


}

package de.timedin.jUtils;

import de.timedin.jUtils.main.JUtils;

import javax.swing.*;
import java.awt.TrayIcon.MessageType;
import java.util.HashMap;

public class Logger {
    private final static HashMap<MessageType, Integer> typeSetting = new HashMap<>();

    public static void main(String[] args) {
        //0 nothing, 1 console, 2 window
        typeSetting.put(MessageType.NONE, 0);
        typeSetting.put(MessageType.INFO, 1);
        typeSetting.put(MessageType.WARNING, 2);
        typeSetting.put(MessageType.ERROR, 2);

    }

    public static void log(Object msg, MessageType type) {
        typeSetting.put(MessageType.NONE, 0);
        typeSetting.put(MessageType.INFO, 1);
        typeSetting.put(MessageType.WARNING, 2);
        typeSetting.put(MessageType.ERROR, 2);

        switch (typeSetting.get(type)) {
            case 0:
                break;
            case 1:
                System.out.println(msg);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, msg);
                break;
        }
        System.out.println(JUtils.prefix + msg);
    }
}

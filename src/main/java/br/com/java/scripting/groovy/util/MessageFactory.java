package br.com.java.scripting.groovy.util;

/**
 * Created by Lacau on 16/09/2016.
 */
public class MessageFactory {

    private String message;

    private MessageFactory(String message) {
        this.message = message;
    }

    public static MessageFactory createMessage(MessageType type, String message, String... args) {
        return new MessageFactory(type.name() + ": " + String.format(message, args));
    }

    @Override
    public String toString() {
        return message;
    }
}
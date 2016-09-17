package br.com.java.scripting.groovy.message;

/**
 * Created by Lacau on 16/09/2016.
 */
public class Message {

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public static Message createMessage(MessageType type, String message, String... args) {
        return new Message(type.name() + ": " + String.format(message, args));
    }

    @Override
    public String toString() {
        return message;
    }
}
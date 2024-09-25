package de.kamiql.util;

import de.kamiql.Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private String filePath;
    private BufferedWriter writer;

    // Konstruktor
    public Logger() {
    }

    public Logger initialize(String path) {
        this.filePath = path;
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            writer = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.err.println("Fehler beim Initialisieren des Loggers: " + e.getMessage());
        }
        return this;
    }

    public void log(String entry) {
        if (writer == null) {
            System.err.println("Logger ist nicht initialisiert. Bitte initialisieren Sie den Logger zuerst.");
            return;
        }
        try {
            writer.write(Main.getDateTime("yyyy-MM-dd HH:mm:ss") + " " + entry);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Log-Datei: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schließen des Loggers: " + e.getMessage());
        }
    }
}


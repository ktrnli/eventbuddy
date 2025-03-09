package ui;

import model.Category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import model.Tag;
import model.User;

public class EventBuddyApp {
    private Category interest;
    private Category identity;
    private Category lf;
    private User currUser;
    private Scanner input;

    public EventBuddyApp() {
        init();
    }

    private void init() {
        createTags();
        runProfileBuilder();
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    private void createTags() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/tags/inttaglist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                interest.addTag(new Tag(line, interest));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/tags/idtaglist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                identity.addTag(new Tag(line, identity));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/tags/lftaglist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lf.addTag(new Tag(line, lf));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void runProfileBuilder() {
        new ProfileBuilder(currUser, interest, identity, lf);
    }

    /*
     * private void processCommand(String command) {
     * if (command.equals("d")) {
     * doDeposit();
     * } else if (command.equals("w")) {
     * doWithdrawal();
     * } else if (command.equals("t")) {
     * doTransfer();
     * } else {
     * System.out.println("Selection not valid...");
     * }
     * }
     */

}
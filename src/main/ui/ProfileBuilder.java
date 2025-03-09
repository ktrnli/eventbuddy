package ui;

import model.Category;
import model.Tag;
import model.User;
import java.util.Scanner;

import exceptions.NotAUserTagOption;

public class ProfileBuilder {
    private Category idCat;
    private Category intCat;
    private Category lfCat;
    private User currUser;
    private Scanner input;

    public ProfileBuilder(User currUser, Category interests, Category identity, Category lf) {
        this.currUser = currUser;
        this.intCat = interests;
        this.idCat = identity;
        this.lfCat = lf;
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");

        String command = null;
        String newName;
        String newProfilePic;
        String newDescription;
        questionOne();
        command = input.next();
        command = command.toLowerCase();
        newName = command.toString();
        questionTwo();
        command = input.next();
        command = command.toLowerCase();
        newProfilePic = command.toString();
        questionThree();
        command = input.next();
        newDescription = command.toString();
        currUser = new User(newName, newProfilePic, newDescription);
        questionFour();
        command = input.next();
        newDescription = command.toString();
    }

    public void questionOne() {
        System.out.println("Hi! Welcome to profile builder.");
        System.out.println("What's your name?");
    }

    public void questionTwo() {
        System.out.println("Please submit a URL link of your profile pic.");
    }

    public void questionThree() {
        System.out.println("Tell us a little bit about yourself!");
    }

    public void questionFour() {

        boolean cont = true;
        String cmd = null;

        while (cont) {
            System.out.println("Here are some tags. Feel free to add whichever ones you're interested in, then press q to exit.");
            cmd = input.next();
            cmd = cmd.toLowerCase();
            if (cmd.toLowerCase().equals("q")) {
                cont = false;
            } else {
                for (Tag tag: intCat.getTags()) {
                    if (tag.getName().toLowerCase().equals(cmd)) {
                        try {
                            currUser.addTagToList(tag, 'i');
                        } catch (NotAUserTagOption e) {
                            System.out.println("Not a tag option. Try again!");
                        }
                        break;
                    }
                }
            }
        }
    }

}

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    //write a program that will recognize invalid inputs when the user requests information about students in a class
    //what will application do?
    public static void main(String[] args) {

        //continue boolean
        boolean contin = true;
        //provide information about students in a class
        //prompt the user to ask about a particular student
        Scanner scan = new Scanner(System.in);
        //give proper responses according user-submitted information
        //ask if user would like to learn about another student
        //parallel arrays to hold clown information
        String[] clowns = {"Sacha Baron Clownin", "Bozo", "Clown Dillinger", "Donald Drumpf", "Evan Nelson", "Freddy the Hobo", "George Carwashington", "Harry Hood", "I", "J", "Krusty", "Loki", "M", "N", "O", "Edwin 'Poodles' Hanneford", "Q", "R", "Steve-O", "T"};
        String[] typeOfClown = {"character", "bozo", "bank robber", "dumpy", "juggalo", "train hopper", "street sweeper", "sasquatch clown", "I", "J", "TV Clown", "god of mischief", "M", "N", "O", "cowboy", "Q", "R", "stunt clown", "T"};
        String[] outfits = {"a Borat suit", "some bozo stuff", "a three-piece suit", "a soiled Louis Vuitton diaper", "a gas station du rag", "an eyepatch and overalls", "G", "way too much fur to be comfortable", "I", "J", "blue hair and a big red nose", "The Mask", "M", "N", "O", "cowboy hat and some timberland boots. With a lasso on the side", "Q", "R", "nothing but some boxer shorts", "T"};
        //initial greeting
        System.out.println("Welcome to the Grand Circus Clown Rental Service!");
        System.out.println("We have many enthusiastic clowns available to rent (some of them even know how to code!)");
        do {
            //user prompt
            System.out.println("We have 20 clowns available at the moment. Which one were you interested in?");
            //grabs number from 1-20 and stores in int variable userSelection
            int userSelection = getUserSelection(scan);
            if (userSelection > 19 || userSelection < 0) {
                System.out.println("That's not a number between 1 and 20, bozo.");
                System.out.println("Who's it gonna be? (enter 1-20):");
                userSelection = getUserSelection(scan);
            }
            //displays information to the user
            System.out.println("That's " + clowns[userSelection] + "!");
            //clears input
            scan.nextLine();
            //user prompt
            System.out.println("What would you like to know about " + clowns[userSelection] + "?");
            System.out.println("What type of clown are they? Or their outfit of the day?");
            //stores user input (converted to all lowercase) in String variable clownInfoRequest
            String clownInfoRequest = scan.nextLine().toLowerCase();
            if (clownInfoRequest.contains("type")) {
                System.out.println(clowns[userSelection] + " is a " + typeOfClown[userSelection] + " clown.");
                System.out.println("Would you like to know more? (y/n)");
                learnMore(scan);
                if (contin) {
                    System.out.println(clowns[userSelection] + " is wearing " + outfits[userSelection]);
                } else {
                    System.out.println("OK Thanks!");
                }
            } else if (clownInfoRequest.contains("outfit") || clownInfoRequest.contains("day")) {
                System.out.println(clowns[userSelection] + " is wearing a" + outfits[userSelection]);
                System.out.println("Would you like to know more? (y/n)");
                learnMore(scan);
                if (contin) {
                    System.out.println(clowns[userSelection] + " is a " + typeOfClown[userSelection] + " clown.");
                } else {
                    System.out.println(" ");
                }
            }
            System.out.println("Would you like to learn about another clown?");
            learnMore(scan);
        } while (contin);
        System.out.println("Thanks again");
    }
    public static void learnMore(Scanner scan) {
        boolean contin;
        if (scan.nextLine().toLowerCase().contains("y") || scan.nextLine().toLowerCase().contains("s")) {
            contin = true;
        } else {
            contin = false;
        }
    }
    public static int getUserSelection(Scanner scan) {
        System.out.print("Please enter a number between 1-20: ");
        return (scan.nextInt()-1);
    }
}
//account for invalid user input with at least 2 exceptions, try to incorporate IndexOutOfBoundsException
// and IllegalArgumentException
//Make it easy for the user - tell them what information is available
//create other exceptions and catch those too!
//    Welcome to our Java class. Which student would you like to learn more about? (enter a number between 1-20): 100
//
//        That student does not exist. Please try again. (enter a number 1-20): 10
//
//        Student 10 is Kim Driscoll. What would you like to know about Kim? (enter or “hometown” or “favorite food”): age
//
//        That data does not exist. Please try again. (enter “hometown” or “favorite food”): hometown
//
//        Kim is from Detroit, MI. Would you like to know more? no
//
//        Thanks!
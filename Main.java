package App;

import App.Actions.CreateMember;
import App.Actions.ShowMembers;
import App.Actions.ShowReports;
import App.Members.Foster;
import App.Members.Volunteer;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    //the lists of all users are static so that only one instance is used everywhere
    public static List<Volunteer> allVolunteers = new ArrayList<>();
    public static List<Foster> allFosters = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to Animal Protection Organisation App!");

        //Initial Members
        Volunteer v = new Volunteer("code_stav@mail.com", "Stavroula", "Pratti", "Address 1", 20, "stav@mail.com", "Safekeep");
        Foster f = new Foster("code_dep@mail.com", "Despoina", "Pratti", "Address 2", 18, "dep@mail.com", 12, "Dog");

        allVolunteers.add(v);
        allFosters.add(f);

        Scanner scanner = new Scanner(System.in); //reads user's input

        String userInput = ""; //saves user's input

        //infinite loop that runs app
        while (true){
            System.out.println("Pick an action 'a' to create member, " +
                    "'b' to show all members " +
                    "'c' to show reports " +
                    "or 'd' to logout!");

            userInput = scanner.nextLine(); //read user input

            while (!userInput.equals("a") && !userInput.equals("b")  && !userInput.equals("c") && !userInput.equals("d")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userInput = scanner.nextLine();
            }

            if(userInput.equals("a")){ //check which action was selected
                CreateMember createMember = new CreateMember(); // create instance of CreateMember class
                createMember.createUser();
            }
            else if(userInput.equals("b")){
                ShowMembers showMembers = new ShowMembers();
                showMembers.loginAction();
            }
            else if(userInput.equals("c")){
                ShowReports showReports = new ShowReports();
                showReports.showStats();
            }
            else{
                break; // program finishes
            }

        }
        System.out.println("Thank you for using our App!");

        }


}

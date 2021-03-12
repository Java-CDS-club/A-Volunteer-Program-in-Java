package App.Actions;

import App.Main;
import App.Members.Foster;
import App.Members.Volunteer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowMembers {

    public static List<Foster> savedFosters = new ArrayList<>();
    public static List<Volunteer> savedVolunteers = new ArrayList<>();

    public void loginAction(){
        System.out.println("Welcome to Login Page!");

        savedFosters = Main.allFosters;
        savedVolunteers = Main.allVolunteers;

        Scanner scanner = new Scanner(System.in); //reads user's input

        System.out.println("Login by inserting your code to show Member List!");

        System.out.println("Give your code:");
        boolean exists = false;
        while(true){
            String code = scanner.nextLine();
            for(Volunteer member : savedVolunteers){
                if(member.getCode().equals(code)){
                    exists = true;
                }
            }
            for(Foster member : savedFosters){
                if(member.getCode().equals(code)){
                    exists = true;
                }
            }
            if(exists){
                System.out.println("Member exists, now you can see member list!");
                break;
            }
            else{
                System.out.println("Member does not exist, insert code again:");
            }
        }

        System.out.println("---ALL MEMBERS---");
        System.out.println("---ALL VOLUNTEERS---");
        for(Volunteer v : savedVolunteers){
            System.out.println("Volunteer with code: " + v.getCode() + " full name: " + v.getfName() + " " + v.getlName() + " age: " + v.getAge() + " and action: " + v.getAction());

        }
        System.out.println("---ALL FOSTERS---");
        for(Foster f : savedFosters){
            System.out.println("Foster for pet: " + f.getPet() + " with code: " + f.getCode() + " full name: " + f.getfName() + " " + f.getlName() + " and age: " +f.getAge());
        }
    }
}

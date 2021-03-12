package App.Actions;

import App.Main;
import App.Members.Foster;
import App.Members.Volunteer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateMember {
    public static List<Foster> savedFosters = new ArrayList<>();
    public static List<Volunteer> savedVolunteers = new ArrayList<>();

    public void createUser(){// function that gathers user's information and adds member to respective list
        System.out.println("Welcome to Create Member Page!");

        savedFosters = Main.allFosters;
        savedVolunteers = Main.allVolunteers;

        Scanner scanner = new Scanner(System.in); //reads user's input

        System.out.println("Give first name:");
        String fname = scanner.nextLine();

        System.out.println("Give last name:");
        String lname = scanner.nextLine();

        System.out.println("Give Address:");
        String address = scanner.nextLine();

        System.out.println("Give Age:");
        while (!scanner.hasNextInt()){
            scanner.next();
        }
        int age = scanner.nextInt();

        String regExEmail = "^(.+)@(.+)$"; // Regular Expression for valid email
        String email = "";
        while(true){
            System.out.println("Give unique email:");// user is unique by email
            email = scanner.nextLine();
            if(email.matches(regExEmail)){ // if Email matches Regular expression
               boolean uqnique = true;
               for(Volunteer member : savedVolunteers){ //we check in volunteers
                   if(member.getEmail().equals(email)){
                       uqnique = false;
                   }
               }
                for(Foster member : savedFosters){ //we check in fosters
                    if(member.getEmail().equals(email)){
                        uqnique = false;
                    }
                }
                if(uqnique){ //if user email is not in saved volunteers or fosters
                    break;
                }
                else{
                    System.out.println("This is not a unique Email Address!");
                }
            }
            else{
                System.out.println("This is an invalid Email Address!");
            }
        }

        String code = "code_" + email; //unique code is generated

        System.out.println("Pick an action for member 'a' to be a volunteer " +
                "'b' to be a foster");

        String action = "";
        action = scanner.nextLine();

        while (!action.equals("a") && !action.equals("b")){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            action = scanner.nextLine();
        }

        if(action.equals("a")){ //check which action was selected
            System.out.println("You want to become a volunteer!");

            System.out.println("Do you want to 'a' protect animals," +
                    " or 'b' safekeep animals?");
            action = "";
            action = scanner.nextLine();

            while (!action.equals("a") && !action.equals("b")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                action = scanner.nextLine();
            }

            String volunteerAction = "";
            if(action.equals("a")) {
                volunteerAction = "Protect";
            }
            else{
                volunteerAction = "Safekeep";
            }

            Volunteer v = new Volunteer(code, fname, lname, address, age, email, volunteerAction); //create volunteer object
            Main.allVolunteers.add(v); // add new volunteer to the static list

            System.out.println("New volunteer with code: " + v.getCode() + " and full name: " + v.getfName() + " " + v.getlName());
        }
        else{
            System.out.println("You want to become a foster!");

            System.out.println("Give number of Months you want to foster pet:");
            while (!scanner.hasNextInt()){
                scanner.next();
            }
            int months = scanner.nextInt();

            System.out.println("Do you want to foster 'a' a dog," +
                    " or 'b' a cat?");
            String pet = "";
            pet = scanner.nextLine();

            while (!pet.equals("a") && !pet.equals("b")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                pet = scanner.nextLine();
            }

            String pet_type = "";
            if(pet.equals("a")) {
                pet_type = "Dog";
            }
            else{
                pet_type = "Cat";
            }

            Foster f = new Foster(code, fname, lname, address, age, email, months, pet_type); //create foster object
            Main.allFosters.add(f); // add new foster to the static list

            System.out.println("New foster for pet: " + f.getPet() + " with code: " + f.getCode() + " and full name: " + f.getfName() + " " + f.getlName());
        }

    }
}

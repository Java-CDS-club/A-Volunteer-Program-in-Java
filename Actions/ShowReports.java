package App.Actions;

import App.Main;
import App.Members.Foster;
import App.Members.Volunteer;

import java.util.ArrayList;
import java.util.List;

public class ShowReports {
    public static List<Foster> savedFosters = new ArrayList<>();
    public static List<Volunteer> savedVolunteers = new ArrayList<>();

    public void showStats(){
        System.out.println("Welcome to Reports Page!");

        savedFosters = Main.allFosters;
        savedVolunteers = Main.allVolunteers;

        int minAge = 99999;

        //get list sizes
        System.out.println("There are " + savedVolunteers.size() + " Volunteers in our System!");
        System.out.println("There are " + savedFosters.size() + " Fosters in our System!");


        for(Volunteer v : savedVolunteers){
            if(v.getAge() <= minAge){
                minAge = v.getAge();
            }
        }
        for(Foster f : savedFosters){
            if(f.getAge() <= minAge){
                minAge = f.getAge();
            }
        }
        System.out.println("The youngest Member is " + minAge + " years old!");

    }
}

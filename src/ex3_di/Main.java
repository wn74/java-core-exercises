package ex3_di;

import ex3_di.exceptions.InvalidUserDataException;
import ex3_di.exceptions.UserAlreadyExistsException;

//=========================User registration=========================  
//--Fixes
//  [] Change User to record 


public class Main {
    

    public static void main(String[] args){
        InMemoryUserRepository userRepository = new InMemoryUserRepository();

        UserService userService = new UserService(userRepository);

        userService.registerUser(Long.valueOf(1), "email@user.com", "Dohn Joe");
        System.out.println("Successfully registered Dohn Joe!");

        try {userService.registerUser(Long.valueOf(1), "newMail@user.com", "Dohn Doe");}

        catch(UserAlreadyExistsException e) {System.out.println("[Handled Error] " + e.getMessage());}

        try {userService.registerUser(Long.valueOf(2), "email@user.com", "Dohn Doe");}

        catch(UserAlreadyExistsException e) {System.out.println("[Handled Error] " + e.getMessage());}

        try {userService.registerUser(Long.valueOf(-2), "newNewEmail@user.com", "Dohn Doe");}

        catch(InvalidUserDataException e) {System.out.println("[Handled Error] " + e.getMessage());}

        try {userService.registerUser(Long.valueOf(2), "", "Dohn Doe");}

        catch(InvalidUserDataException e) {System.out.println("[Handled Error] " + e.getMessage());}

        try {userService.registerUser(Long.valueOf(2), "email@user.com", "");}

        catch(InvalidUserDataException e) {System.out.println("[Handled Error] " + e.getMessage());}

    }


    
}

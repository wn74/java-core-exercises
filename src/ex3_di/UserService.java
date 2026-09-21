package ex3_di;

import ex3_di.exceptions.InvalidUserDataException;
import ex3_di.exceptions.UserAlreadyExistsException;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void registerUser(Long id, String email, String fullName){
    validateInputs(id, email, fullName);
    checkDuplicates(id, email);
    createUser(id, email, fullName);
    }
    private void validateInputs(Long id, String email, String fullName){
        validateId(id);
        validateEmail(email);
        validateName(fullName);
    }
    private void validateId(Long id){

        if( id == null || id <= 0){
            throw new InvalidUserDataException("ID must be greater than 0 and not empty");
        }

    }
    private void validateEmail(String email){

        if(email == null ||  email.isBlank()  ){
            throw new InvalidUserDataException("Email cannot be empty");
        }

        if(!email.contains("@")   ){
            throw new InvalidUserDataException("Email must contain @ symbol");
        }
    
    }

    private void validateName(String name){

        if(name == null  || name.isBlank()  ){
            throw new InvalidUserDataException("Name cannot be empty");
        }

    }

    private void checkDuplicates(Long id,String email){

        checkDuplicatesIDs(id);
        checkDuplicateEmails(email);

    }

    private void checkDuplicatesIDs(Long id){

        if (userRepository.findById(id).isPresent()){

            throw new UserAlreadyExistsException("User with the same ID already exists");

        }

    }

    private void checkDuplicateEmails(String email){

        if (userRepository.findByEmail(email).isPresent()){

            throw new UserAlreadyExistsException("User with the same Email already exists");

        }

    }

    public void  createUser(Long id, String email, String fullName){

        User newUser = new  User(id,email,fullName);
        userRepository.save(newUser);
        

    }
    
}

package ex3_di;

public class UserService {


    public void registerUser(Long id, String email, String fullName){
    validateInputs(id, email, fullName);
    checkDuplicates();
    //new User;
    }
    private void validateInputs(Long id, String email, String fullName){
        validateId(id);
        validateEmail(email);
        validateName(fullName);
    }
    private void validateId(Long id){}
    private void validateEmail(String email){}
    private void validateName(String name){}

    private void checkDuplicates(){}
    private void checkDuplicateEmails(){}
    private void checkDuplicatesIDs(){}
}

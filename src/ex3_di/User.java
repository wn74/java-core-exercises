package ex3_di;

public class User {
    public Long id;
    public String fullName;
    public String email;

    public User(Long id, String email , String  fullName){
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        
    }
}

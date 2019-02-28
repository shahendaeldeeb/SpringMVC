package spitter.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Spitter {
    private Long id;
    @NotNull
    @Size(min=5, max=16)
    private String username;
    @NotNull
    @Size(min=5, max=25)
    private String password;
    @NotNull
    @Size(min=2, max=30)
    private String firstName;
    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    public Spitter(String first_name, String last_name, String username, String password) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.username = username;
        this.password = password;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

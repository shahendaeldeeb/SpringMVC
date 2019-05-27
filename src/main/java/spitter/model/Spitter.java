package spitter.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    private Long id;

    private MultipartFile profile_picture;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;
    @NotNull
    @NotEmpty
    @Email(message = "{email.valid}")
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30, message = "{first_name.size}")
    private String first_name;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30, message = "{last_name.size}")
    private String last_name;

    public Spitter() {
    }

    public Spitter(String first_name, String last_name, String email, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public MultipartFile getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(MultipartFile profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

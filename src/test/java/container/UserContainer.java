package container;

import java.io.File;

public class UserContainer {
    private String name;
    private String email;
    private String phone;
    private String message;
    private File file;

    public String getMessage() {
        return message;
    }

    public UserContainer setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserContainer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserContainer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserContainer setName(String name) {
        this.name = name;
        return this;
    }

    public UserContainer getPositiveUserData() {
        this.name = "Name";
        this.phone = "+79999999999";
        this.email = "test@test.test";
        this.message = "Autotest Message MF!";
        this.file= new File(
                "src" + File.separator +
                        "main" + File.separator +
                        "resources" + File.separator +
                        "test.jpg"
        );

        return this;
    }

    public UserContainer getEmptyUserData() {
        this.name = " ";
        this.phone = " ";
        this.email = " ";
        this.message = " ";

        return this;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

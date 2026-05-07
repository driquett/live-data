package model;

public class User {

    // Atributos del usuario
    private int id;
    private String username;
    private String password;

    // Constructor vacío
    public User() {
    }

    // Constructor con parámetros
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getter del ID
    public int getId() {
        return id;
    }

    // Setter del ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter del username
    public String getUsername() {
        return username;
    }

    // Setter del username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter del password
    public String getPassword() {
        return password;
    }

    // Setter del password
    public void setPassword(String password) {
        this.password = password;
    }
}
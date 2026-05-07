package model;

public class Credential {

    private int id;
    private String code;
    private int employeeId;

    public Credential() {}

    public Credential(int id, String code, int employeeId) {
        this.id = id;
        this.code = code;
        this.employeeId = employeeId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
}
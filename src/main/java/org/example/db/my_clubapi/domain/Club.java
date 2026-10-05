package org.example.db.my_clubapi.domain;

public class Club {
    private Long id;
    private String name;
    private String role;
    private String gender;
    private String studentId;
    private String department;

    public Club() {}
    public Club(Long id, String name, String role, String gender, String studentId, String department) {
        this.id=id; this.name=name; this.role=role; this.gender=gender;
        this.studentId=studentId; this.department=department;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String studentId){
        this.studentId=studentId;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
}

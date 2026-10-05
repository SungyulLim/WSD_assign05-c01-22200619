package org.example.db.my_clubapi.domain;

public class Club {
    private Long id;
    private String name;
    private String role;
    private String gender;

    public Club() {}
    public Club(Long id, String name, String role, String gender) {
        this.id=id; this.name=name; this.role=role; this.gender=gender;
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
}

package com.cdth17pm.quizzgame;

public class ranking {
    private int id;
    private String username;
    private String email;
    private String img;
    private Double score;
    private int credit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    public ranking(int id , String username,String email,String img,Double score,int credit){
        this.id = id;
        this.username=username;
        this.img = img;
        this.score= score;
        this.credit=credit;
    }

}

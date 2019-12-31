package com.cdth17pm.quizzgame;

public class LinhVuc {
    private Integer id;
    private String tenLinhVuc;

    public LinhVuc(){
        this.id=0;
        this.tenLinhVuc="";
    }
    public LinhVuc(Integer id , String ten_linh_vuc){
        this.id =id;
        this.tenLinhVuc = ten_linh_vuc;
    }
    public LinhVuc(String tenLinhVuc){
        this.tenLinhVuc = tenLinhVuc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLinhVuc() {
        return tenLinhVuc;
    }

    public void setTenLinhVuc(String tenLinhVuc) {
        this.tenLinhVuc = tenLinhVuc;
    }
}

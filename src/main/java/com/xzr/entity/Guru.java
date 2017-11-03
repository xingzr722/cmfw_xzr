package com.xzr.entity;

/**
 * Created by F on 2017/10/29.
 */
public class Guru {
    private String id;
    private String headpic;
    private String name;
    private String status;

    public Guru() {
    }

    public Guru(String id, String headpic, String name, String status) {

        this.id = id;
        this.headpic = headpic;
        this.name = name;
        this.status = status;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", headpic='" + headpic + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

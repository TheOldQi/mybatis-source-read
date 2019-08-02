package com.qixiafei.mybatis.source.read.po;

public class IdxTestPo {

    private Long id;
    private String no;
    private String name;

    private Byte sex;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"no\":\"")
                .append(no).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"sex\":")
                .append(sex);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

}

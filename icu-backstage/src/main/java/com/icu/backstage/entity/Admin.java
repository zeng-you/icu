package com.icu.backstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author 曾有
 * @since 2022-05-09
 */
public class Admin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 盐
     */
    private String salt;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门 department id
     */
    private Long departmentId;

    /**
     * 添加时间
     */
    private LocalDateTime addTime;

    /**
     * 编辑时间
     */
    private LocalDateTime editTime;

    /**
     * 添加管理员 admin id
     */
    private Long addAdmin;

    /**
     * 编辑管理员 admin id
     */
    private Long editAdmin;

    /**
     * 删除（0：否，1：是）
     */
    private String del;

    /**
     * 状态（0：禁用，1：正常）
     */
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public Long getAddAdmin() {
        return addAdmin;
    }

    public void setAddAdmin(Long addAdmin) {
        this.addAdmin = addAdmin;
    }

    public Long getEditAdmin() {
        return editAdmin;
    }

    public void setEditAdmin(Long editAdmin) {
        this.editAdmin = editAdmin;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "id=" + id +
        ", pwd=" + pwd +
        ", salt=" + salt +
        ", phone=" + phone +
        ", avatar=" + avatar +
        ", name=" + name +
        ", email=" + email +
        ", departmentId=" + departmentId +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        ", addAdmin=" + addAdmin +
        ", editAdmin=" + editAdmin +
        ", del=" + del +
        ", status=" + status +
        "}";
    }
}

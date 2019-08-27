package com.ngari.ucenter.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ngari.ucenter.common.utils.DateFormatUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by win on 2019/8/17.
 */

@Entity
@Table(name = "base_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User implements Serializable {

        private static final long serialVersionUID =  8425443065747800192L;
        @Id
        @GeneratedValue(generator = "jpa-uuid")
        @Column(length = 32, nullable = false, unique = true)
        private String userid;
        @Column(nullable = false, unique = true)
        private String username;
        @Column(nullable = false)
        @JsonIgnore
        private String password;
        @Column(nullable = true, unique = true)
        private String nickname;
        @Column(nullable = false, unique = true)
        private String email;
        @Column(nullable = false, unique = true)
        private String mobile;
        @Column(nullable = false)
        private Integer status;
        @Column(nullable = false)
        @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale ="zh", timezone = "GMT+8")
        private Date createTime;
        @Column(nullable = false)
        @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale ="zh", timezone = "GMT+8")
        private Date updateTime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Date getCreatetime() {
        return createTime;
    }

    public void setCreatetime(Date createtime) {
        this.createTime = createtime;
    }


    public Date getUpdatetime() {
        return updateTime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updateTime = updatetime;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString(){
        String strCreateTime = DateFormatUtils.getDatetime(createTime);
        String strUpdateTime = DateFormatUtils.getDatetime(updateTime);
        return "{\"userid\":\"" + userid +"\"," +
                "\"username\":\"" + username + "\"," +
                "\"password\":\"" + password + "\"," +
                "\"nickname\":\"" + nickname + "\"," +
                "\"email\":\"" + email + "\"," +
                "\"mobile\":\"" + mobile + "\"," +
                "\"createTime\":\"" + strCreateTime + "\"," +
                "\"updateTime\":\"" + strUpdateTime  + "\"," +
                "\"status\":\"" + status + "\"" + "}";
    }

}

package com.polycis.api.nb.entity.device;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@TableName("dev_union_app")
public class UnionApp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 应用eui
     */
    private String appEui;
    /**
     * 应用名称
     */
    private String name;
    /**
     * lora设备id
     */
    private Integer loraAppId;
    /**
     * 创建时间
     */
    private Date creatTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppEui() {
        return appEui;
    }

    public void setAppEui(String appEui) {
        this.appEui = appEui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoraAppId() {
        return loraAppId;
    }

    public void setLoraAppId(Integer loraAppId) {
        this.loraAppId = loraAppId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "UnionApp{" +
                "id=" + id +
                ", appEui='" + appEui + '\'' +
                ", name='" + name + '\'' +
                ", loraAppId=" + loraAppId +
                ", creatTime=" + creatTime +
                '}';
    }
}

package com.polycis.api.nb.entity.device;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@TableName("dev_union_device")
public class UnionDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备eui
     */
    private String devEui;
    /**
     * 设备名称
     */
    private String devName;
    /**
     * 设备类型
     */
    private String type;
    /**
     * 创建时间
     */
    private Date creatTime;
    /**
     * 设备配置文件
     */
    private String devPro;
    /**
     * 优先级
     */
    private String priority;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevEui() {
        return devEui;
    }

    public void setDevEui(String devEui) {
        this.devEui = devEui;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getDevPro() {
        return devPro;
    }

    public void setDevPro(String devPro) {
        this.devPro = devPro;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "UnionDevice{" +
        ", id=" + id +
        ", devEui=" + devEui +
        ", devName=" + devName +
        ", type=" + type +
        ", creatTime=" + creatTime +
        ", devPro=" + devPro +
        ", priority=" + priority +
        "}";
    }
}

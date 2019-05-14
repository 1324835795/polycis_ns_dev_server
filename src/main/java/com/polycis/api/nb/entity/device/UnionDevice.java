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
 * @author cuiwenhao
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
     * 设备uuid
     */
    private String devUuid;
    /**
     * 应用eui
     */
    private String appEui;

    /**
     * 设备名称
     */
    private String name;
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

    /**
     * 设备状态啥
     */
    private String status;

    /**
     * 优先级推送队列
     */
    private String queue;

    private Date reportTime;

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getAppEui() {
        return appEui;
    }

    public void setAppEui(String appEui) {
        this.appEui = appEui;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevUuid() {
        return devUuid;
    }

    public void setDevUuid(String devUuid) {
        this.devUuid = devUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", devUuid='" + devUuid + '\'' +
                ", appEui='" + appEui + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", creatTime=" + creatTime +
                ", devPro='" + devPro + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", queue='" + queue + '\'' +
                '}';
    }
}

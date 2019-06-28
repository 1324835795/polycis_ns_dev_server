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
 * @since 2019-06-18
 */
@TableName("iot_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 产品平台 1lora 2nb 3移动2g3g4g  4以太网  5wifi
     */
    private Integer platform;
    /**
     * 产品唯一eui
     */
    private String productEui;
    /**
     * 数据解析方式 0透传 1解析
     */
    private Integer analysisWay;
    /**
     * 关联的lora设备模式 a:1 b:2 c:3
     */
    private Integer loraDeviceClass;
    /**
     * lora的设备配置id
     */
    private Integer loraConfigId;
    /**
     * 删除标识 0未删除 1删除
     */
    private Integer isDelete;
    /**
     * lora设备的激活方式 1abp 2otaa
     */
    private Integer activeWay;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;

    private Integer protocolId;

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getProductEui() {
        return productEui;
    }

    public void setProductEui(String productEui) {
        this.productEui = productEui;
    }

    public Integer getAnalysisWay() {
        return analysisWay;
    }

    public void setAnalysisWay(Integer analysisWay) {
        this.analysisWay = analysisWay;
    }

    public Integer getLoraDeviceClass() {
        return loraDeviceClass;
    }

    public void setLoraDeviceClass(Integer loraDeviceClass) {
        this.loraDeviceClass = loraDeviceClass;
    }

    public Integer getLoraConfigId() {
        return loraConfigId;
    }

    public void setLoraConfigId(Integer loraConfigId) {
        this.loraConfigId = loraConfigId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getActiveWay() {
        return activeWay;
    }

    public void setActiveWay(Integer activeWay) {
        this.activeWay = activeWay;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", id=" + id +
        ", name=" + name +
        ", platform=" + platform +
        ", productEui=" + productEui +
        ", analysisWay=" + analysisWay +
        ", loraDeviceClass=" + loraDeviceClass +
        ", loraConfigId=" + loraConfigId +
        ", isDelete=" + isDelete +
        ", activeWay=" + activeWay +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        "}";
    }
}

package com.polycis.api.nb.entity.device.vo;

public class DevQueueVO {

    /**
     * 设备uuid
     */
    private String devUuid;

    /**
     * 回调地址
     */
    private String httpApp;
    /**
     * 队列名称
     */
    private String queueNameApp;

    private Integer analysisWay;
    /**
     * 优先级[1,2,3,4,5,6....255]
     * 默认10
     * */
    private Integer priority;

    private Integer protocolId;

    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public Integer getAnalysisWay() {
        return analysisWay;
    }

    public void setAnalysisWay(Integer analysisWay) {
        this.analysisWay = analysisWay;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDevUuid() {
        return devUuid;
    }

    public void setDevUuid(String devUuid) {
        this.devUuid = devUuid;
    }

    public String getHttpApp() {
        return httpApp;
    }

    public void setHttpApp(String httpApp) {
        this.httpApp = httpApp;
    }

    public String getQueueNameApp() {
        return queueNameApp;
    }

    public void setQueueNameApp(String queueNameApp) {
        this.queueNameApp = queueNameApp;
    }

    @Override
    public String toString() {
        return "DevQueueVO{" +
                "devUuid='" + devUuid + '\'' +
                ", httpApp='" + httpApp + '\'' +
                ", queueNameApp='" + queueNameApp + '\'' +
                ", analysisWay=" + analysisWay +
                ", priority=" + priority +
                '}';
    }
}

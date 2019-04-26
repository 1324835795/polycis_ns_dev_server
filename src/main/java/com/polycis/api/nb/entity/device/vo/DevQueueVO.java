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


    /**
     * 优先级[1,2,3,4,5,6....255]
     * 默认10
     * */
    private Integer priority;

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
                '}';
    }
}

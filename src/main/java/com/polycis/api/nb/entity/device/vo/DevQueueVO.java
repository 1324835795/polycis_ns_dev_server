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

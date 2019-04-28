package com.polycis.api.nb.service.device;

import com.baomidou.mybatisplus.service.IService;
import com.polycis.api.nb.entity.device.Http;
import com.polycis.api.nb.entity.device.MqQueue;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuiwenhao
 * @since 2019-04-18
 */
public interface IMqQueueService extends IService<MqQueue> {

    /**
     * 新增MQ地址 区分优先级
     * @param
     * @return
     */
    boolean addMqQueue(MqQueue mqQueue);
}

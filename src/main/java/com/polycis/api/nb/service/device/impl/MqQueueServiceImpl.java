package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.MqQueue;
import com.polycis.api.nb.mapper.device.MqQueueMapper;
import com.polycis.api.nb.service.device.IMqQueueService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@Service
public class MqQueueServiceImpl extends ServiceImpl<MqQueueMapper, MqQueue> implements IMqQueueService{

    @Override
    public boolean addMqQueue(MqQueue mqQueue) {
        String filename= RandomStringUtils.randomAlphanumeric(5);
        String appEui = mqQueue.getAppEui();
        mqQueue.setQueueName(appEui+filename);
        boolean b = this.insert(mqQueue);
        return b;
    }
}

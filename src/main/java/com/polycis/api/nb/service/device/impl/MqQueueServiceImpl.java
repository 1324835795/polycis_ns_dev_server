package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.puls.dao.MqQueueMapper;
import com.polycis.api.nb.puls.entity.MqQueue;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@Service
public class MqQueueServiceImpl extends ServiceImpl<MqQueueMapper, MqQueue> implements IService<MqQueue> {

}

package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.mapper.device.UnionAppMapper;
import com.polycis.api.nb.service.device.IUnionAppService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@Service
public class UnionAppServiceImpl extends ServiceImpl<UnionAppMapper, UnionApp> implements IUnionAppService {


    @Override
    public boolean addApp(UnionApp appInfo) {

        //入库
        appInfo.setCreatTime(new Date());
        boolean b = this.insert(appInfo);
        return b;
    }
}

package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.mapper.device.UnionDeviceMapper;
import com.polycis.api.nb.service.device.IUnionDeviceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@Service
public class UnionDeviceServiceImpl extends ServiceImpl<UnionDeviceMapper, UnionDevice> implements IUnionDeviceService {

    @Override
    public boolean addDev(UnionDevice unionDevice) {

        Map<String,Object> device =new HashMap<>();
        device.put("dev_eui",unionDevice.getDevEui());
        List<UnionDevice> unionDevices = this.selectByMap(device);
        if(unionDevices.isEmpty()){
            unionDevice.setCreatTime(new Date());
            boolean b = this.insert(unionDevice);
            return b;
        }
        return false;
    }

    @Override
    public boolean deleteDev(UnionDevice unionDevice) {
        //删除设备
        Map<String,Object> device =new HashMap<>();
        device.put("dev_eui",unionDevice.getDevEui());
        boolean b = this.deleteByMap(device);
        return b;
    }

    @Override
    public UnionDevice devisExist(UnionDevice unionDevice) {

        //查询设备
        Map<String,Object> device =new HashMap<>();
        device.put("app_eui",unionDevice.getDevEui());
        List<UnionDevice> unionApps = this.selectByMap(device);
        if(!unionApps.isEmpty()){
            //应用存在
            UnionDevice deviceInfo = unionApps.get(0);
            return deviceInfo;
        }
        return null;

    }
}

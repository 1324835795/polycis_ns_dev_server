package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.Http;
import com.polycis.api.nb.entity.device.MqQueue;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.entity.device.vo.DevQueueVO;
import com.polycis.api.nb.mapper.device.UnionDeviceMapper;
import com.polycis.api.nb.service.device.IHttpService;
import com.polycis.api.nb.service.device.IMqQueueService;
import com.polycis.api.nb.service.device.IUnionAppService;
import com.polycis.api.nb.service.device.IUnionDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    IUnionAppService iUnionAppService;
    @Autowired
    IHttpService iHttpService;
    @Autowired
    IMqQueueService iMqQueueService;


    @Override
    public boolean addDev(UnionDevice unionDevice) {

        Map<String,Object> device =new HashMap<>();
        device.put("dev_uuid",unionDevice.getDevUuid());
        List<UnionDevice> unionDevices = this.selectByMap(device);
        if(unionDevices.isEmpty()){
            unionDevice.setPriority("1");
            unionDevice.setCreatTime(new Date());
            boolean b = this.insert(unionDevice);
            return b;
        }
        return false;
    }

    @Override
    public boolean deleteDev(UnionDevice unionDevice) {
        //删除设备
        if(unionDevice.getDevUuid()!=null){
            Map<String,Object> device =new HashMap<>();
            device.put("dev_uuid",unionDevice.getDevUuid());
            boolean b = this.deleteByMap(device);
            return b;
        }
        return false;
    }

    @Override
    public UnionDevice devisExist(UnionDevice unionDevice) {

        //查询设备
        Map<String,Object> device =new HashMap<>();
        device.put("dev_uuid",unionDevice.getDevUuid());
        List<UnionDevice> unionApps = this.selectByMap(device);
        if(!unionApps.isEmpty()){
            //应用存在
            UnionDevice deviceInfo = unionApps.get(0);
            return deviceInfo;
        }
        return null;

    }


    @Override
    public UnionDevice updateDev(UnionDevice unionDevice) {
        //修改设备
        this.updateById(unionDevice);
        return null;
    }

    @Override
    public DevQueueVO deviQueue(UnionDevice unionDevice) {
        DevQueueVO devQueueVO = new DevQueueVO();
        devQueueVO.setDevUuid(unionDevice.getDevUuid());
        String priority = unionDevice.getPriority();
        //优先级设备
        if(priority.equals("2")){
            devQueueVO.setQueueNameApp(unionDevice.getQueue());
            return devQueueVO;
        }else{

            String appEui = unionDevice.getAppEui();
            Map<String,Object> apply =new HashMap<>();
            apply.put("app_eui",appEui);
            List<UnionApp> unionApps = iUnionAppService.selectByMap(apply);
            if(!unionApps.isEmpty()){
                UnionApp unionApp = unionApps.get(0);
                if(unionApp.getPushType()==1){
                    //http推送地址
                    List<Http> https = iHttpService.selectByMap(apply);
                    String httpName = https.get(0).getHttpName();
                    devQueueVO.setHttpApp(httpName);
                    return devQueueVO;
                }else{
                    //mq正常推送地址
                    Map<String,Object> mq =new HashMap<>();
                    mq.put("app_eui",appEui);
                    mq.put("priority",1);

                    List<MqQueue> mqQueues = iMqQueueService.selectByMap(mq);
                    String queueName = mqQueues.get(0).getQueueName();
                    devQueueVO.setQueueNameApp(queueName);
                    return devQueueVO;

                }

            }

            return devQueueVO;
        }

    }
}

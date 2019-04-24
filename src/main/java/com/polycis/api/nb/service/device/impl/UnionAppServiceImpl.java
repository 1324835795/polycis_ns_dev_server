package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.Http;
import com.polycis.api.nb.entity.device.MqQueue;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.mapper.device.UnionAppMapper;
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
public class UnionAppServiceImpl extends ServiceImpl<UnionAppMapper, UnionApp> implements IUnionAppService {

    @Autowired
    IMqQueueService mqQueueService;
    @Autowired
    IHttpService httpService;
    @Autowired
    IUnionDeviceService iUnionDeviceService;


    @Override
    public boolean addApp(UnionApp appInfo) {
        //入库
        Map<String,Object> apply =new HashMap<> ();
        apply.put("app_eui",appInfo.getAppEui());
        List<UnionApp> unionApps = this.selectByMap(apply);
        if(unionApps.isEmpty()){
            appInfo.setCreatTime(new Date());
            boolean b = this.insert(appInfo);
            if(b){
                //生成两个推送地址
                MqQueue mq = new MqQueue();
                MqQueue mq2 = new MqQueue();
                Http http = new Http();
                mq.setAppEui(appInfo.getAppEui());
                mq.setPriority(1);
                mq2.setAppEui(appInfo.getAppEui());
                mq2.setPriority(2);
                //生成http推送地址
                if(appInfo.getHttp()!=null){
                    http.setAppEui(appInfo.getAppEui());
                    http.setHttpName(appInfo.getHttp());
                    httpService.addHttp(http);
                }
                mqQueueService.addMqQueue(mq);
                mqQueueService.addMqQueue(mq2);
            }
            return b;
        }
        return false;
    }

    @Override
    public boolean deleteApp(UnionApp appInfo) {

        if(appInfo.getAppEui()!=null){
            //删除应用
            Map<String,Object> apply =new HashMap<> ();
            apply.put("app_eui",appInfo.getAppEui());
            boolean b = this.deleteByMap(apply);
            return b;
        }
        return false;
    }

    @Override
    public Integer deleteApply(UnionApp appInfo) {

        if(appInfo.getAppEui()!=null){

            String appEui = appInfo.getAppEui();
            Map<String,Object> apply =new HashMap<> ();
            apply.put("app_eui",appEui);
            //查询应用下是否有设备
            List<UnionDevice> unionDevices = iUnionDeviceService.selectByMap(apply);

            if(unionDevices.size()>0){
                //设备存在不能删除应用
                return 401;
            }else{
                List<UnionApp> unionApps = this.selectByMap(apply);
                if(!unionApps.isEmpty()){
                    Integer id = unionApps.get(0).getId();
                    boolean b = this.deleteById(id);
                    if(b){
                        //删除应用下的队列名与mq
                        mqQueueService.deleteByMap(apply);
                        httpService.deleteByMap(apply);
                        return 200;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public boolean updateApp(UnionApp appInfo) {
        if(appInfo.getAppEui()!=null){
            //修改应用
            Map<String,Object> apply =new HashMap<> ();
            apply.put("app_eui",appInfo.getAppEui());
            List<UnionApp> unionApps = this.selectByMap(apply);
            UnionApp unionApp = unionApps.get(0);
            unionApp.setLoraAppId(appInfo.getLoraAppId());
            boolean b = this.updateById(unionApp);
            return b;
        }

        return false;
    }

    @Override
    public UnionApp appisExist(UnionApp appInfo) {
        Map<String,Object> apply =new HashMap<> ();
        apply.put("app_eui",appInfo.getAppEui());
        List<UnionApp> unionApps = this.selectByMap(apply);
        if(!unionApps.isEmpty()){
            //应用存在
            UnionApp unionApp = unionApps.get(0);
            Map<String,Object> http =new HashMap<> ();
            http.put("app_eui",appInfo.getAppEui());
            List<Http> https = httpService.selectByMap(http);
            unionApp.setHttp(https.get(0).getHttpName());

            Map<String,Object> mq =new HashMap<> ();
            mq.put("app_eui",appInfo.getAppEui());
            mq.put("priority",1);
            List<MqQueue> mqQueues = mqQueueService.selectByMap(mq);

            if(!mqQueues.isEmpty()){
                unionApp.setMqQueue(mqQueues.get(0).getQueueName());
            }
            return unionApp;
        }
        return null;
    }


}

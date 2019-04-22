package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.mapper.device.UnionAppMapper;
import com.polycis.api.nb.service.device.IUnionAppService;
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


    @Override
    public boolean addApp(UnionApp appInfo) {
        //入库
        Map<String,Object> apply =new HashMap<> ();
        apply.put("app_eui",appInfo.getAppEui());
        List<UnionApp> unionApps = this.selectByMap(apply);
        if(unionApps.isEmpty()){
            appInfo.setCreatTime(new Date());
            boolean b = this.insert(appInfo);
            return b;
        }
        return false;
    }

    @Override
    public boolean deleteApp(UnionApp appInfo) {
        //删除应用
        Map<String,Object> apply =new HashMap<> ();
        apply.put("app_eui",appInfo.getAppEui());
        boolean b = this.deleteByMap(apply);
        return b;
    }

    @Override
    public UnionApp appisExist(UnionApp appInfo) {
        Map<String,Object> apply =new HashMap<> ();
        apply.put("app_eui",appInfo.getAppEui());
        List<UnionApp> unionApps = this.selectByMap(apply);
        if(!unionApps.isEmpty()){
            //应用存在
            UnionApp unionApp = unionApps.get(0);
            return unionApp;
        }
        return null;
    }


}

package com.polycis.api.nb.service.device;

import com.baomidou.mybatisplus.service.IService;
import com.polycis.api.nb.entity.device.UnionApp;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-19
 */
public interface IUnionAppService extends IService<UnionApp> {

    /**
     * 新增应用`
     * @param
     * @return
     */
    boolean addApp(UnionApp deviceInfo);

}

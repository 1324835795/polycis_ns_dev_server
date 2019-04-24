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
    boolean addApp(UnionApp appInfo);

    /**
     * 删除应用`
     * @param
     * @return
     */
    boolean deleteApp(UnionApp appInfo);

    /**
     * 删除应用`
     * @param
     * @return
     */
    Integer deleteApply(UnionApp appInfo);


    /**
     * 修改应用`
     * @param
     * @return
     */
    boolean updateApp(UnionApp appInfo);


    /**
     * 查询应用是否存在`
     * @param
     * @return
     */
    UnionApp appisExist(UnionApp appInfo);

}

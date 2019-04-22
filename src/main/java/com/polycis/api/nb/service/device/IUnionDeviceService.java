package com.polycis.api.nb.service.device;

import com.baomidou.mybatisplus.service.IService;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cwh
 * @since 2019-04-18
 */
public interface IUnionDeviceService extends IService<UnionDevice> {

    /**
     * 新增设备
     * @param
     * @return
     */
    boolean addDev(UnionDevice unionDevice);

    /**
     * 删除设备
     * @param
     * @return
     */
    boolean deleteDev(UnionDevice unionDevice);


    /**
     * 查询设备是否存在`
     * @param
     * @return
     */
    UnionDevice devisExist(UnionDevice unionDevice);

    /**
     * 修改设备
     * @param
     * @return
     */
    UnionDevice updateDev(UnionDevice unionDevice);

}

package com.polycis.api.nb.service.device;

import com.polycis.api.nb.entity.device.Http;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cuiwenhao
 * @since 2019-04-22
 */
public interface IHttpService extends IService<Http> {

    /**
     * 新增http地址链接
     * @param
     * @return
     */
    boolean addHttp(Http httpinfo);
}

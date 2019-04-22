package com.polycis.api.nb.service.device.impl;

import com.polycis.api.nb.entity.device.Http;
import com.polycis.api.nb.mapper.device.HttpMapper;
import com.polycis.api.nb.service.device.IHttpService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2019-04-22
 */
@Service
public class HttpServiceImpl extends ServiceImpl<HttpMapper, Http> implements IHttpService {

}

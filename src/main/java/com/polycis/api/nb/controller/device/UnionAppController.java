package com.polycis.api.nb.controller.device;


import com.alibaba.fastjson.JSON;
import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.common.vo.RequestVO;
import com.polycis.api.nb.entity.device.DeviceEntity;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.service.device.IUnionAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-18
 */
@RestController
@RequestMapping("/unionApp")
public class UnionAppController {

    protected static Logger Log = LoggerFactory.getLogger(UnionAppController.class);
    @Autowired
    IUnionAppService iUnionAppService;

    /**
     * 对外新增应用
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/addApp")
    public String addApp(@RequestBody RequestVO requestVO) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionApp");
            UnionApp appInfo = JSON.parseObject(JSON.toJSONString(params), UnionApp.class);
            boolean b = iUnionAppService.addApp(appInfo);
            apiResult.setData(b);
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("应用创建失败");
            Log.error("应用创建失败");
        }
        return apiResult.toString();
    }



}


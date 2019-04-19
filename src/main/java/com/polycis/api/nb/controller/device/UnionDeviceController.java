package com.polycis.api.nb.controller.device;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.common.vo.RequestVO;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.entity.device.UnionDevice;
import com.polycis.api.nb.service.device.IUnionAppService;
import com.polycis.api.nb.service.device.IUnionDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/unionDevice")
public class UnionDeviceController {

    protected static Logger Log = LoggerFactory.getLogger(UnionDeviceController.class);
    @Autowired
    IUnionDeviceService iUnionDeviceService;

    /**
     * 对外新增应用
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/addDevice")
    public JSONObject addApp(@RequestBody RequestVO requestVO) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionDev");
            UnionDevice unionDevice = JSON.parseObject(JSON.toJSONString(params), UnionDevice.class);
            boolean b = iUnionDeviceService.addDev(unionDevice);
            apiResult.setData(b);
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("设备创建失败");
            Log.error(e.toString());
        }
        JSONObject jsStr = JSONObject.parseObject(apiResult.toString());
        return jsStr;
    }



    /**
     * 删除设备信息
     * @param requestVO
     * @return String
     */
    @PostMapping(value = "/deleteDev")
    public JSONObject deleteApp(@RequestBody RequestVO requestVO) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionDev");
            UnionDevice unionDevice = JSON.parseObject(JSON.toJSONString(params), UnionDevice.class);
            boolean b = iUnionDeviceService.deleteDev(unionDevice);
            apiResult.setData(b);
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("删除设备失败");
            Log.error(e.toString());
        }
        JSONObject jsStr = JSONObject.parseObject(apiResult.toString());
        return jsStr;
    }

}


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
     * 对外新增设备
     * @param requestVO
     * @return
     */
    @PostMapping(value = "/addDevice")
    public ApiResult addDevice(@RequestBody RequestVO requestVO) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionDev");
            UnionDevice unionDevice = JSON.parseObject(JSON.toJSONString(params), UnionDevice.class);
            boolean b = iUnionDeviceService.addDev(unionDevice);
            apiResult.setData(b);
            if(b==false){
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("设备已存在");
            }

        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("设备创建失败");
            Log.error(e.toString());
        }

        return apiResult;
    }


    /**
     * 删除设备信息
     * @param requestVO
     * @return String
     */
    @PostMapping(value = "/deleteDev")
    public ApiResult deleteApp(@RequestBody RequestVO requestVO) {
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

        return apiResult;
    }


    /**
     * 查询设备
     * @param requestVO
     * @return String
     */
    @PostMapping(value = "/devisExist")
    public ApiResult selectDev(@RequestBody RequestVO requestVO) {
        ApiResult<UnionDevice> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionDev");
            UnionDevice device = JSON.parseObject(JSON.toJSONString(params), UnionDevice.class);
            UnionDevice unionDevice = iUnionDeviceService.devisExist(device);

            if(unionDevice!=null){
                //查询到设备
                apiResult.setData(unionDevice);
            }else{
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());
                apiResult.setData(new UnionDevice());
            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("查询应用失败");
            Log.error(e.toString());
        }
        return apiResult;
    }


}


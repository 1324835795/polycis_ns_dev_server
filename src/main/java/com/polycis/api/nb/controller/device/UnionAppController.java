package com.polycis.api.nb.controller.device;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
    @PostMapping(value = "/addApply")
    public JSONObject addApp(@RequestBody RequestVO requestVO) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionApp");
            UnionApp appInfo = JSON.parseObject(JSON.toJSONString(params), UnionApp.class);
            boolean b = iUnionAppService.addApp(appInfo);
            System.out.println(appInfo.getAppName());
            apiResult.setData(b);
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("应用创建失败");
            Log.error(e.toString());
        }
        JSONObject jsStr = JSONObject.parseObject(apiResult.toString());
        return jsStr;
    }

    /**
     * 删除应用信息
     * @param requestVO
     * @return String
     */
    @PostMapping(value = "/deleteApply")
    public JSONObject deleteApp(@RequestBody RequestVO requestVO) {
        ApiResult<Boolean> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionApp");
            UnionApp appInfo = JSON.parseObject(JSON.toJSONString(params), UnionApp.class);
            boolean b = iUnionAppService.deleteApp(appInfo);
            apiResult.setData(b);
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("删除应用失败");
            Log.error(e.toString());
        }
        JSONObject jsStr = JSONObject.parseObject(apiResult.toString());
        return jsStr;
    }

    /**
     * 查询
     * @param requestVO
     * @return String
     */
    @PostMapping(value = "/appisExist")
    public JSONObject selectApp(@RequestBody RequestVO requestVO) {
        ApiResult<UnionApp> apiResult  = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Map<String, Object> params = (Map<String, Object>)requestVO.getData().get("unionApp");
            UnionApp appInfo = JSON.parseObject(JSON.toJSONString(params), UnionApp.class);
            UnionApp unionApp = iUnionAppService.appisExist(appInfo);
            if(unionApp!=null){
                //查询到设备
                apiResult.setData(unionApp);
            }else{
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());
                apiResult.setData(new UnionApp());
            }
        }catch (Exception e){
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("查询应用失败");
            Log.error(e.toString());
        }
        JSONObject jsStr = JSONObject.parseObject(apiResult.toString());
        return jsStr;
    }



}


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
     * @param appInfo
     * @return
     */
    @PostMapping(value = "/addApply")
    public ApiResult addApp(@RequestBody UnionApp appInfo) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            boolean b = iUnionAppService.addApp(appInfo);
            System.out.println(appInfo.getName());
            apiResult.setData(b);
            if (b == false) {
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("应用已存在");
            }
        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("应用创建失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

    /**
     * 删除应用信息
     * @param appInfo
     * @return String
     */
    @PostMapping(value = "/deleteApply")
    public ApiResult deleteApp(@RequestBody UnionApp appInfo) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            boolean b = iUnionAppService.deleteApp(appInfo);
            apiResult.setData(b);
            if(b==false){
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg("应用不存在,删除失败");
            }
        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("删除应用失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

    /**appisExist
     * 查询应用
     * @param appInfo
     * @return String
     */
    @PostMapping(value = "/appisExist")
    public ApiResult selectApp (@RequestBody UnionApp appInfo){
        ApiResult<UnionApp> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            UnionApp unionApp = iUnionAppService.appisExist(appInfo);
            if (unionApp != null) {
                //查询到应用
                apiResult.setData(unionApp);
            } else {
                //未查到数据
                apiResult.setCode(CommonCode.NO_DATA.getKey());
                apiResult.setMsg(CommonCode.NO_DATA.getValue());
            }
        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("查询应用失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

}


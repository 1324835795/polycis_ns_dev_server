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
     人生就像一场戏，因为有缘才相聚。
     相扶到老不容易，是否更该去珍惜。
     为了小事发脾气，回头想想又何必。
     别人生气我不气，气出病来无人替。
     我若生气谁如意，况且伤神又费力。
     邻居亲朋不要比，儿孙琐事由他去。
     吃苦享乐在一起，神仙羡慕好伴侣。
     */

    /**
     * 对外新增应用
     * @param appInfo
     * @return
     */
    @PostMapping(value = "/addApp")
    public ApiResult addApp(@RequestBody UnionApp appInfo) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            boolean b = iUnionAppService.addApp(appInfo);
            System.out.println(appInfo.getName());
            apiResult.setData(b);
            if (b == false) {
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("应用已存在,创建失败");
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
    @PostMapping(value = "/deleteApp")
    public ApiResult deleteApp(@RequestBody UnionApp appInfo) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Integer i = iUnionAppService.deleteApply(appInfo);
            if(i==200){
                apiResult.setData(true);
            }else if(i==401){
                apiResult.setCode(CommonCode.PARAMETER_LOSE.getKey());
                apiResult.setMsg("应用存在设备,不允许删除");
            }else{
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("删除应用失败");
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

    /**
     * 修改应用信息(应用与lora接入平台绑定)
     * @param appInfo
     * @return
     */
    @PostMapping(value = "/updateApp")
    public ApiResult updateApp(@RequestBody UnionApp appInfo) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            boolean b = iUnionAppService.updateApp(appInfo);
            apiResult.setData(b);
            if (b == false) {
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("更新应用失败");
            }

        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("应用修改失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

}


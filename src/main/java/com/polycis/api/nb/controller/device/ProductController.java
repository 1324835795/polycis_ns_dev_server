package com.polycis.api.nb.controller.device;


import com.polycis.api.nb.common.ApiResult;
import com.polycis.api.nb.common.CommonCode;
import com.polycis.api.nb.entity.device.Product;
import com.polycis.api.nb.entity.device.UnionApp;
import com.polycis.api.nb.service.device.IProductService;
import com.polycis.api.nb.service.device.IUnionAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-06-18
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    protected static Logger Log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    IProductService iProductService;

    /**
     * 对外新增应用
     * @param product
     * @return
     */
    @PostMapping(value = "/addProduct")
    public ApiResult addProduct(@RequestBody Product product) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            boolean b = iProductService.addProduct(product);
            Log.info("得到appEui"+product.getProductEui());
            apiResult.setData(b);
            if (b == false) {
                Log.info("产品存在创建失败");
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("产品已存在,创建失败");
            }

        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("产品创建失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

    /**
     * 修改产品
     * @param product
     * @return
     */
    @PostMapping(value = "/updateProduct")
    public ApiResult updateProduct(@RequestBody Product product) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("得到productEui"+product.toString());
            boolean b = iProductService.updateProduct(product);
            apiResult.setData(b);
            if (b == false) {
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("更新应用失败");
            }
            Log.info("更新产品成功返回:"+product.getProductEui());
        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("产品修改失败");
            Log.error(e.toString());
        }
        return apiResult;
    }
    /**
     * 删除应用信息
     * @param product
     * @return String
     */
    @PostMapping(value = "/deleteProduct")
    public ApiResult deleteProduct(@RequestBody Product product) {
        ApiResult<Boolean> apiResult = new ApiResult<>(CommonCode.SUCCESS);
        try {
            Log.info("得到ProductEui"+product.getProductEui());
            Integer i = iProductService.deleteProduct(product);
            if(i==200){
                Log.info("删除产品成功");
                apiResult.setData(true);
            }else if(i==401){
                apiResult.setCode(CommonCode.PARAMETER_LOSE.getKey());
                apiResult.setMsg("产品存在设备,不允许删除");
            }else{
                apiResult.setCode(CommonCode.ERROR.getKey());
                apiResult.setMsg("删除产品失败");
            }
        } catch (Exception e) {
            apiResult.setCode(CommonCode.ERROR.getKey());
            apiResult.setMsg("删除产品失败");
            Log.error(e.toString());
        }
        return apiResult;
    }

}


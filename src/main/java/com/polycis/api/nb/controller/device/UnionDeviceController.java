package com.polycis.api.nb.controller.device;


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
@RequestMapping("/unionDevice")
public class UnionDeviceController {

    /**
     * 对外删除设备接口
     * @param requestVO
     * @return
     */


    @PostMapping(value = "/test")
    public String deleteDev(@RequestBody String requestVO) {

        System.out.println(requestVO);
        return requestVO;
    }
}


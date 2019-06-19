package com.polycis.api.nb.service.device;

import com.baomidou.mybatisplus.service.IService;
import com.polycis.api.nb.entity.device.Product;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2019-06-18
 */
public interface IProductService extends IService<Product> {

    boolean addProduct(Product product);


    boolean updateProduct(Product product);

    Integer deleteProduct(Product product);

}

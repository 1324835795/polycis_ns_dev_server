package com.polycis.api.nb.service.device.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.polycis.api.nb.entity.device.*;
import com.polycis.api.nb.mapper.device.ProductMapper;
import com.polycis.api.nb.service.device.IProductService;
import com.polycis.api.nb.service.device.IUnionDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cuiwenhao
 * @since 2019-06-18
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    IUnionDeviceService iUnionDeviceService;

    @Override
    public boolean addProduct(Product product) {
        EntityWrapper<Product> pro = new EntityWrapper<>();
        List<Product> proList = this.selectList(pro.eq("product_eui", product.getProductEui()));
        if(proList.isEmpty()){
            boolean b = this.insert(product);
            if(b){
                return b;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        EntityWrapper<Product> pro = new EntityWrapper<>();
        boolean b = this.update(product, pro.eq("product_eui", product.getProductEui()));
        return b;
    }

    @Override
    public Integer deleteProduct(Product product) {
        if(product.getProductEui()!=null){
            //查询产品数据
            Map<String,Object> proMap =new HashMap<> ();
            proMap.put("product_eui",product.getProductEui());
            List<UnionDevice> unionDevices = iUnionDeviceService.selectByMap(proMap);
            if(unionDevices.size()>0){
                //产品下有设备不能删除
                return 401;
            }
            List<Product> products = this.selectByMap(proMap);
            if(!products.isEmpty()){
                //删除产品
                boolean b = this.deleteByMap(proMap);
                if(b){
                    return 200;
                }
            }
        }
        return 0;
    }
}

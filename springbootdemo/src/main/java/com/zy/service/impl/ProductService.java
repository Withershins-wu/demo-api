package com.zy.service.impl;

import com.zy.dao.ProductMapper;
import com.zy.entity.Product;
import com.zy.service.IProductService;
import com.zy.vo.JsonResult;
import com.zy.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangyan
 * @date 2018-08-09 14:54
 * @desc 商品实现类
 **/
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public JsonResult addProduct(ProductVo vo) {

        JsonResult result = new JsonResult();
        Product product = new Product();
        product.setProName(vo.getName());
        product.setProSort(vo.getSort());
        productMapper.insertSelective(product);

        result = result.success("添加商品成功了");
        result.setData(product.getId());
        return result;
    }

    @Override
    public JsonResult<Product> getProduct(Long pid) {
        JsonResult<Product> result = new JsonResult<Product>();
        Product product = productMapper.selectByPrimaryKey(pid);

        result = result.success("获取商品成功");
        result.setData(product);
        return result;
    }


}

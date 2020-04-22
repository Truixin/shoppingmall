package com.liren.shoppingmall.malltiny01.service;


import com.liren.shoppingmall.malltiny01.mbg.model.PmsBrand;

import java.util.List;

/**
 * @description: 提供对品牌操作的接口
 * @author: tianruixin
 * @date: 2020/4/16 1:21
 */
public interface PmsBrandService {

    /**
     * 新建品牌
     *
     * @param pmsBrand
     * @return
     */
    int creatBrand(PmsBrand pmsBrand);

    /**
     * 按id删除品牌
     *
     * @param id
     * @return
     */
    int deleteBrand(Long id);

    /**
     * 通过id获取品牌信息
     *
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);

    /**
     * 更新品牌信息
     *
     * @param id
     * @param pmsBrand
     * @return
     */
    int updateBrand(Long id, PmsBrand pmsBrand);

    /**
     * 查询所有品牌信息
     *
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 查询品牌的分页信息
     *
     * @param pageNum  页码
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);


}

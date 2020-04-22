package com.liren.shoppingmall.malltiny01.Controller;


import com.liren.shoppingmall.malltiny01.common.api.CommonPage;
import com.liren.shoppingmall.malltiny01.common.api.CommonResult;
import com.liren.shoppingmall.malltiny01.mbg.model.PmsBrand;
import com.liren.shoppingmall.malltiny01.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 品牌管理Controller
 * @author: tianruixin
 * @date: 2020/4/16 1:20
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    PmsBrandService pmsBrandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     * @param pmsBrand
     * @return com.liren.shoppingmall.malltiny01.common.api.CommonResult
     * @Description: 新建品牌
     * @Author tianruixin
     * @Date 2020/4/22 10:54
     **/
    @RequestMapping(value = "/creat", method = RequestMethod.POST)
    public CommonResult creatBrand(PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.creatBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("creatBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("creatBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("delete success:id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("delete failed :id={}", id);
            return CommonResult.failed("删除失败");
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public CommonResult<PmsBrand> gerBrand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") Long id, PmsBrand pmsBrand) {
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        if (count == 1) {
            LOGGER.debug("update success :{}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            LOGGER.debug("update failed :{}", pmsBrand);
            return CommonResult.failed("更新失败");
        }
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> listAllBrand() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

}

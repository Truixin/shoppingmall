package com.liren.shoppingmall.malltiny01.Controller;


import com.liren.shoppingmall.malltiny01.mbg.model.PmsBrand;
import com.liren.shoppingmall.malltiny01.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: tianruixin
 * @date: 2020/4/16 1:20
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    public int creatBrand(PmsBrand pmsBrand) {
        return pmsBrandService.creatBrand(pmsBrand);
    }


}

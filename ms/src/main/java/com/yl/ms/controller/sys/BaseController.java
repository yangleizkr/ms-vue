package com.yl.ms.controller.sys;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;

/**
 * @author yl on 2021/6/17
 */
public class BaseController {

    /**
     * 处理参数为对象时的，对象的格式校验、有效性校验
     *
     * @param map    map对象
     * @param result 绑定返回结果对象
     * @return 返回第一个错误校验信息
     */
    public HashMap<String, Object> checkObject(HashMap<String, Object> map, BindingResult result) {

        for (ObjectError error : result.getAllErrors()) {
            map.put("flag", false);
            map.put("mes", error.getDefaultMessage());
            return map;
        }
        return map;
    }
}

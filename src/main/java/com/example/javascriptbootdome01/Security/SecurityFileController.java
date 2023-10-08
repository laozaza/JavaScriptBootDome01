package com.example.javascriptbootdome01.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @BelongsProject: JavaScriptBootDome01  //项目名
 * @BelongsPackage: com.example.javascriptbootdome01.Security  //包名
 * @ClassName SecurityFileController                //类名
 * @Author: laozaza                   //作者
 * @CreateTime: 2023-10-08  10:35  //时间
 * @Description: TODO                //类描述
 * @Version: 1.0                     //版本
 */
@Controller
public class SecurityFileController {
    private String TAG = "FilmeController";
    //影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("path") String path) {
        String value = "detail/" + type + "/" + path;
        System.out.println(TAG + "===toDeil===" + value);
        return value;
    }
}

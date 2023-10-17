package com.example.javascriptbootdome01.Security;

import com.example.javascriptbootdome01.SQL.jpa.Discuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
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
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    private String TAG = "FilmeController";

    //影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("path") String path) {
        String value = "detail/" + type + "/" + path;
        System.out.println(TAG + "===toDeil===" + value);
        return value;
    }

    //登录页面
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login";
    }

    //错误登录页面
    @GetMapping("/loginError")
    String loginerror() {
        return "login/loginerror";
    }

    //登录后的影片主页面
    @PostMapping("/index2")
    String index2() {
        return "login/index2";
    }



    //使用HttpSession获取用户信息
    @GetMapping("/getuserBySession")
    @ResponseBody
    public void getUser(HttpSession session) {
        //从当前HttpSession获取绑定到此会话的所有对象的名称
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            //获取HttpSession中的会话名称
            String element = names.nextElement();
            //获取HttpSession中的应用上下文
            SecurityContextImpl attribute = (SecurityContextImpl) session.getAttribute(element);
            System.out.println("element:" + element);
            System.out.println("attribute:" + attribute);
            //获取用户相关信息
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username:" + principal.getUsername());

        }
    }
//使用SecurityContextHolder获取用户登录信息
    @GetMapping("/getuserByContext")
    @ResponseBody
    public void getUser2() {
    //获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("UserDetails:"+context);
        //获取用户相关信息
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal);
        System.out.println("username:"+principal.getUsername());



    }

    //向用户修改页
    @RequestMapping("/toupdateUser")//这里使用 @GetMapping会报错因为 @GetMapping是GET类型不是POST
    public String toupdateuser(){return "/csrf/csrfTest";}


    //用户修改提交处理
    @ResponseBody
    @PostMapping(value = "/updateUser")
    public Customer updateUser(@RequestParam String username, @RequestParam String password,HttpServletRequest request){

        //获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        //获取用户相关信息
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        Customer customer=new Customer();
        customer= customerService.findById(principal.getUsername());
        System.out.println(customer);
        customer.setUsername(username);
        System.out.println(customer.getUsername());
         customerService.updateUser(customer.getUsername(),customer.getId());

//        System.out.println(username);
//        System.out.println(password);
//        String csrf_token = request.getParameter("_csrf");
//        System.out.println(csrf_token);
        return customer;

    }
}

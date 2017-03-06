package tk.mybatis.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.springboot.dubbotest.provider.DemoService;

/**
 * Created by Administrator on 2017/2/7.
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;
    @Autowired
    public DemoService demoService;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        demoService.sayHello("dd");
        return content;
    }
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String say2(){
        return girlProperties.getCupSize();
    }
    //请求地址路径中获取参数方式
    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say3(@PathVariable("id") Integer id){
        return "id: " + id;
    }
    //获取请求参数
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say4(@RequestParam("id") Integer id){
        return "id: " + id;
    }
    //带有默认值的请求参数
    @RequestMapping(value = "/say1",method = RequestMethod.GET)
    public String say5(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "myId: " + myId;
    }
}

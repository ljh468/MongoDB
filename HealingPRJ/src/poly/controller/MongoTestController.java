package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.service.IMongoTestService;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식가능
 * 자바 서블릭 역할 수정
 */
@Controller
public class MongoTestController {

   /*
    * 비즈니스 로직 ( 중용 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재( 싱글톤 패턴 적용됨 )
    */
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name = "MongoTestService")
   private IMongoTestService mongoTestService;
   
   /**
    * 컬렉션 생성 TEST
    */
   @RequestMapping(value = "mongo/test")
   @ResponseBody
   public String test(HttpServletRequest request, HttpServletResponse response) throws Exception{
      log.info(this.getClass().getName() + ".test Start!");
      
      mongoTestService.createCollection();
      
      log.info(this.getClass().getName() + ".test end!");
      return "success";
   }
}
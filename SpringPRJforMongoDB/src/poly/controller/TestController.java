//package poly.controller;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import poly.service.ITestService;
//import poly.util.CmmUtil;
//
//@Controller
//public class TestController {
//
//	private Logger log = Logger.getLogger(this.getClass());
//	
//	@Resource(name = "TestService")
//	private ITestService testService;
//	
//	@RequestMapping(value="index")
//	public String index(HttpServletRequest request, HttpServletResponse reponse) { 
//		
//		log.info("hi");
//		return "/index";
//	}
//	
//	//운영결과 페이지 호출 _ 유연준
//	@RequestMapping(value ="YearMonthResult")
//	public String resultProgram(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		log.info("프로그램 결과");
//		return "/YearMonthResult";
//	}
//	@RequestMapping(value ="aa")
//	public String fadsam(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		log.info("프로그램 결과");
//		return "/resProgram_chart";
//	}
//	
//	
//	//운영결과 페이지 차트 호출  _ 유연준
//	@RequestMapping(value ="resProgram_chart")
//	public String resultProgram_chart(HttpServletRequest request, HttpServletResponse response)  throws Exception{
//		String name = CmmUtil.nvl(request.getParameter("name"));
//		
//		log.info("프로그램 차트 가기");
//		log.info(name);
//		return "/resProgram_chart";
//	}
//} 

package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.persistance.mapper.ITestMapper;
import poly.service.ITestService;

@Service("TestService")
public class TestService implements ITestService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "TestMapper")
	private ITestMapper testMapper;

}

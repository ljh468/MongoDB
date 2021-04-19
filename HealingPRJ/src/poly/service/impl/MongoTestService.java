package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.persistance.mongo.IMongoTestMapper;
import poly.service.IMongoTestService;


@Service("MongoTestService")
public class MongoTestService implements IMongoTestService{

   @Resource(name = "MongoTestMapper")
   private IMongoTestMapper mongoTestMapper;
   
   // 로그 파일 생성
   private Logger log = Logger.getLogger(this.getClass());


   @Override
   public boolean createCollection() throws Exception {

      log.info(this.getClass().getName() + ".createCollection Start!");
      
      // 생성할 컬렉션 명
      String colnm = "MyCollection";
      
      log.info(this.getClass().getName() + ".createCollection Start!");
      
      return mongoTestMapper.createCollection(colnm);
   }
   
   
}
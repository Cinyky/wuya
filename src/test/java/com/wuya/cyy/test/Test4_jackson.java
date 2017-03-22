package com.wuya.cyy.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wuya.cyy.dao.BookDao;
import com.wuya.cyy.pojo.Book;
import com.wuya.cyy.service.Impl.BookServiceImpl;

//告诉junit spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@SuppressWarnings("unchecked")
@ContextConfiguration({ "classpath:spring/spring-web.xml", "classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml" })
public class Test4_jackson {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 private JsonGenerator jsonGenerator = null;
	 private ObjectMapper objectMapper = null;
	 private Book book = null;
	 private List<Book> books = null;
	@Before
    public void init() {
		long bookId = 1;
		book = new Book(bookId, "1", 1);
		books = new ArrayList<>();
		books.add(new Book(1, "1", 1));
		books.add(new Book(2, "2", 2));
		books.add(new Book(3, "3", 3));
        objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void destory() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            book = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Test
	public void writeJsonObject() throws Exception {
		
		try {
	        System.out.println("jsonGenerator");
	        //writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
	        jsonGenerator.writeObject(book);    
	        System.out.println();
	        
	        System.out.println("ObjectMapper");
	        //writeValue具有和writeObject相同的功能
	        objectMapper.writeValue(System.out, book);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	@Test
	public void writeJsonList() throws Exception {
		
		try {
	        System.out.println("jsonGenerator");
	        //writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
	        jsonGenerator.writeObject(books);    
	        System.out.println();
	        
	        System.out.println("ObjectMapper");
	        //writeValue具有和writeObject相同的功能
	        System.out.println(objectMapper.writeValueAsString(books));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
	
}

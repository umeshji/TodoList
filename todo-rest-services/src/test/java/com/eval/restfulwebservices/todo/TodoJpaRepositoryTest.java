package com.eval.restfulwebservices.todo;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eval.restfulwebservices.todo.Todo;
import com.eval.restfulwebservices.todo.TodoJpaRepository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoJpaRepositoryTest {
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	   @After
	    public void tearDown() throws Exception {
		   todoJpaRepository.deleteAll();
	    }
	   
	   @Test
	    public void test_findByUsername() {
		   Todo todo = new Todo(1L,  "umesh", "desc", new java.util.Date(),true);
		   todoJpaRepository.save(todo);
		   List<Todo> todoList = todoJpaRepository.findByUsername("umesh");
	        assertThat(todoList).isNotNull();
	        assertThat(todoList.get(0).getUsername()).isEqualTo("umesh");
	   }
	   
}

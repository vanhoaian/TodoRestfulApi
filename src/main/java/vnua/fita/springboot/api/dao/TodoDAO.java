package vnua.fita.springboot.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import vnua.fita.springboot.api.model.Todo;

@Repository
@Transactional
public class TodoDAO {
	@Autowired
	ITodoRepository todoRepo;

	public Todo getTodo(int id) {
		return todoRepo.findById(id).get();
	}

	public Todo addTodo(Todo todo) {
		return todoRepo.save(todo);
	}

	public Todo updateTodo(Todo todo) {
		Todo existingTodo = todoRepo.findById(todo.getId()).get();
		existingTodo.setId(todo.getId());
		existingTodo.setUserId(todo.getUserId());
		existingTodo.setTitle(todo.getTitle());
		existingTodo.setCompleted(todo.isCompleted());
		Todo updatedTodo = todoRepo.save(existingTodo);
		return updatedTodo;
	}

	public void deleteTodo(int id) {
		todoRepo.deleteById(id);
	}

	public List<Todo> getAllTodo() {
		return todoRepo.findAll();
	}
}

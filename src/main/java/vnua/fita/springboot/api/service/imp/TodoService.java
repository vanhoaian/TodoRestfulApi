package vnua.fita.springboot.api.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vnua.fita.springboot.api.dao.ITodoRepository;
import vnua.fita.springboot.api.model.Todo;
import vnua.fita.springboot.api.service.ITodoService;

@Service
public class TodoService implements ITodoService{

	@Autowired
	ITodoRepository todoRepo;
	
	@Override
	public Iterable<Todo> findAll() {
		return todoRepo.findAll();
	}

	@Override
	public Optional<Todo> findById(int id) {
		// TODO Auto-generated method stub
		return todoRepo.findById(id);
	}

	@Override
	public Todo save(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepo.save(todo);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		todoRepo.deleteById(id);
	}
}

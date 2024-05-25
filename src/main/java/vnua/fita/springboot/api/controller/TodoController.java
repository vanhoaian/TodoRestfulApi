package vnua.fita.springboot.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vnua.fita.springboot.api.model.Todo;
import vnua.fita.springboot.api.service.ITodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // Đánh dấu lớp này là một RESTful controller
@CrossOrigin("*") // Cho phép các yêu cầu từ bất kỳ nguồn nào
@RequestMapping("/todo") // Đường dẫn chung cho tất cả các phương thức trong lớp này
public class TodoController {

	@Autowired // Tự động liên kết với dịch vụ Todo
	private ITodoService todoService;

	@GetMapping("/") // Xử lý GET request tại "/todo/"
	public ResponseEntity<Iterable<Todo>> getAllTodo() {
		return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK); // Trả về tất cả Todo với status 200
	}

	@GetMapping("/{id}") // Xử lý GET request tại "/todo/{id}"
	public ResponseEntity<Todo> getTodo(@PathVariable int id) {
		Optional<Todo> todoOptional = todoService.findById(id);
		return todoOptional.map(todo -> new ResponseEntity<>(todo, HttpStatus.OK)) // Nếu tìm thấy, trả về Todo với status 200
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Nếu không tìm thấy, trả về status 404
	}

	@PutMapping("/{id}") // Xử lý PUT request tại "/todo/{id}"
	public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo todo) {
		Optional<Todo> todoOptional = todoService.findById(id);
		return todoOptional.map(todo1 -> {
			todo.setId(todo1.getId());
			return new ResponseEntity<>(todoService.save(todo), HttpStatus.OK); // Nếu tìm thấy, cập nhật Todo và trả về với status 200
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Nếu không tìm thấy, trả về status 404
	}

	@PostMapping("/") // Xử lý POST request tại "/todo/"
	public ResponseEntity<Todo> createNewTodo(@RequestBody Todo todo) {
		return new ResponseEntity<>(todoService.save(todo), HttpStatus.OK); // Tạo mới Todo và trả về với status 200
	}

	@DeleteMapping("/{id}") // Xử lý DELETE request tại "/todo/{id}"
	public ResponseEntity<Todo> deleteTodo(@PathVariable int id) {
		Optional<Todo> todoOptional = todoService.findById(id);
		return todoOptional.map(todo -> {
			todoService.remove(id);
			return new ResponseEntity<>(todo, HttpStatus.OK); // Nếu tìm thấy, xóa Todo và trả về với status 200
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Nếu không tìm thấy, trả về status 404
	}
}

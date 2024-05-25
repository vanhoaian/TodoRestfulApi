package vnua.fita.springboot.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vnua.fita.springboot.api.model.Todo;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Integer> {

}

package org.bharathi.repo;


import org.bharathi.entity.TodoDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITodoRepo extends JpaRepository<TodoDetails, Integer> {

}

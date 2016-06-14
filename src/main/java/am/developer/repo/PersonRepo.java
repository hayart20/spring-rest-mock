package am.developer.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import am.developer.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface PersonRepo extends CrudRepository<Person, Long>
{
		@Query("{'name' : ?0}")
		public Iterable<Person> searchByName(String personName);

}

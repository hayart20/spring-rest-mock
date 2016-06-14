package am.developer.repo;

import org.springframework.data.repository.CrudRepository;

import am.developer.entity.Address;

public interface AddressRepo extends CrudRepository<Address, Long>
{
}

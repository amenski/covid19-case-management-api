package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.EthUser;

@Repository
public interface UserRepository extends JpaRepository<EthUser, Integer> {
	EthUser findByUsername(String email);
}

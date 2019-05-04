package hh.palvelinohjelmointi.urheilutilasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Long> {
	List<Score> findById(long gameid);
}
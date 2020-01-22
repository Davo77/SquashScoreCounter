package hh.palvelinohjelmointi.urheilutilasto.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Long> {
	Optional<Score> findById(Long Id);
}
/*
public interface ScoreRepository extends CrudRepository<Score, Long> {
    List<Score> findById(Long Id);
}*/
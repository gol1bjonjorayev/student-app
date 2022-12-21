package gol1bjon.developer.springbootapp.repository;

import gol1bjon.developer.springbootapp.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {

    @Query("select s from Students s where upper(s.firstName) like upper(concat('%',:firstName,'%'))")
    List<Students> findAllByLike(@Param("firstName") String firstName);

    List<Students> findAllByFirstNameStartingWith(String name);

    @Query(value = "select * from Students s where upper(s.first_name) like upper(concat(:firstName,'%'))",nativeQuery = true)
    List<Students> searchByName(@Param("firstName") String firstName);


}

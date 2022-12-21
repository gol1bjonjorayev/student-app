package gol1bjon.developer.springbootapp.repository;

import gol1bjon.developer.springbootapp.entity.file.FileClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileClass,Long> {

}

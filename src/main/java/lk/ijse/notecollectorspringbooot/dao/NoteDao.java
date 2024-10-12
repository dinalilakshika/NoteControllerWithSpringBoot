package lk.ijse.notecollectorspringbooot.dao;


import lk.ijse.notecollectorspringbooot.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String> {

}

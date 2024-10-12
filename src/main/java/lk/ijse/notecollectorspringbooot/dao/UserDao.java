package lk.ijse.notecollectorspringbooot.dao;

import lk.ijse.notecollectorspringbooot.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
}

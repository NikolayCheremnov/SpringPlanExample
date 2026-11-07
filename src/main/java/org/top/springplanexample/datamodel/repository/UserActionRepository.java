package org.top.springplanexample.datamodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.top.springplanexample.datamodel.entity.UserActionJournal;

@Repository
public interface UserActionRepository extends JpaRepository<UserActionJournal, Long> {
}

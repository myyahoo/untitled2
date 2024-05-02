package com.example.demo.repository;

import com.example.demo.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaReposigory extends JpaRepository<BoardEntity,Integer> {

    @Modifying
    @Query("update BoardEntity b set b.title=:title, b.contents=:contents where b.id=:id")
    void update(@Param("title") String title, @Param("contents") String contents, @Param("id") int id);
}

package com.zjl.producer.repository;

import com.zjl.producer.model.BookPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhou
 * @className BookRepository
 * @date 2022/02/07 10:46
 * @description
 **/
public interface BookRepository extends JpaRepository<BookPO,Long> {
}

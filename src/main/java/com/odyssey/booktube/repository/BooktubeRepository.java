package com.odyssey.booktube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooktubeRepository<T> {

    public T save(T t);

    public T get(String name);

    public List<T> list();

}

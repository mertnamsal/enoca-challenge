package com.namsalmert.enoca_challange.utility;

import com.namsalmert.enoca_challange.model.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Getter
public class ServiceManager <T extends BaseEntity,ID> implements IService<T,ID> {
    private final JpaRepository<T,ID> repository;

    @Override
    public T save(T t) {
        t.setCreateDate(LocalDateTime.now().toString());
        t.setUpdateDate(LocalDateTime.now().toString());
        t.setState(true);
        return repository.save(t);
    }

    @Override
    public T update(T t) {
        t.setUpdateDate(LocalDateTime.now().toString());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }
}

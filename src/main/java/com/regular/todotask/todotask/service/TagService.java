package com.regular.todotask.todotask.service;

import com.regular.todotask.todotask.domain.SubTask;
import com.regular.todotask.todotask.domain.Tag;
import com.regular.todotask.todotask.repository.TagRepository;
import com.regular.todotask.todotask.repository.ToDoSubTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {
    private final TagRepository repository;


    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Tag> findAllTag(){
        return repository.findAll();
    }

    @Transactional
    public void saveTag(Tag tag){
        repository.saveAndFlush(tag);
    }

    @Transactional
    public void updateTag(Tag tag){
        Optional<Tag> otag = repository.findById(tag.getId());
        Tag tempTask = otag.get();
        tag.setId(tempTask.getId());
        repository.saveAndFlush(tag);
    }
}

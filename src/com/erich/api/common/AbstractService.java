package com.erich.api.common;

import com.erich.api.enums.Message;
import com.erich.api.member.Member;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Message save(T t);

    public abstract Message save(Member member);

    public abstract List<T> findAll();
    public abstract Optional<T> findById(Long id);
    public abstract String count();
    public abstract Optional<T> getOne(String id);
    public abstract String delete(T t);
    public abstract String deleteAll();
    public abstract Boolean existById (Long id);
}

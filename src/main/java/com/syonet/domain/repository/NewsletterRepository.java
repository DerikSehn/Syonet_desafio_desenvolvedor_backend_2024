package com.syonet.domain.repository;

import com.syonet.domain.model.Newsletter;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public interface NewsletterRepository extends PanacheRepository<Newsletter> {
    void saveNewsletter(Newsletter newsletter);

    List<Newsletter> findUnsentNewsletters();
}
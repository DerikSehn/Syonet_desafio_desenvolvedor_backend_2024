package com.syonet.adapters.repository;

import java.util.List;

import com.syonet.domain.model.Newsletter;
import com.syonet.domain.repository.NewsletterRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class NewsletterRepositoryImpl implements NewsletterRepository {

    @Inject
    EntityManager entityManager;

    public List<Newsletter> findUnsentNewsletters() {
        TypedQuery<Newsletter> query = entityManager.createQuery("SELECT n FROM Newsletter n WHERE n.sent = false",
                Newsletter.class);

        List<Newsletter> result = query.getResultList();

        for (Newsletter newsletter : result) {
            markAsSent(newsletter);
        }

        return result;
    }

    private void markAsSent(Newsletter newsletter) {
        newsletter.sent = true;
        entityManager.merge(newsletter);

    }

    @Transactional
    public void saveNewsletter(Newsletter newsletter) {
        entityManager.persist(newsletter);
    }

}

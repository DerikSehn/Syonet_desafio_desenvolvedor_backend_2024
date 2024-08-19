package com.syonet.application.service;

import java.util.List;

import com.syonet.domain.model.Newsletter;
import com.syonet.domain.repository.NewsletterRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class NewsletterService {

    @Inject
    NewsletterRepository newsletterRepository;

    @Transactional
    public List<Newsletter> findUnsentNewsletters() {
        return newsletterRepository.findUnsentNewsletters();
    }

    @Transactional
    public void saveNewsletter(Newsletter newsletter) {
        newsletterRepository.saveNewsletter(newsletter);

    }

    /*
     * public List<Newsletter> getNewsletters(int page, int size) {
     * TypedQuery<Newsletter> query =
     * entityManager.createQuery("SELECT n FROM Newsletter n", Newsletter.class);
     * query.setFirstResult(page * size);
     * query.setMaxResults(size);
     * return query.getResultList();
     * }
     */
    /*
     * public Optional<Newsletter> getNewsletterById(Long id) {
     * return Optional.ofNullable(entityManager.find(Newsletter.class, id));
     * }
     */

    /*
     * @Transactional
     * public void deleteNewsletter(Long id) {
     * Newsletter newsletter = entityManager.find(Newsletter.class, id);
     * if (newsletter != null) {
     * entityManager.remove(newsletter);
     * }
     * }
     */

}
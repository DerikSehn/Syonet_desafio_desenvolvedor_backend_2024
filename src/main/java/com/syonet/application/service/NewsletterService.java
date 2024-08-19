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

}
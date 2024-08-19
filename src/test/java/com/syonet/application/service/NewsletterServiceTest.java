package com.syonet.application.service;

import com.syonet.domain.model.Newsletter;
import com.syonet.domain.repository.NewsletterRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class NewsletterServiceTest {

    @Inject
    NewsletterRepository newsletterRepository;

    @Inject
    NewsletterService newsletterService;

    @Test
    @Transactional
    public void testSaveNewsletter() {
        Newsletter newsletter = new Newsletter();
        newsletter.title = "New Feature Released!";
        newsletter.description = "We have released a new feature.";
        newsletter.link = "http://example.com/feature";

        newsletterService.saveNewsletter(newsletter);

        Optional<Newsletter> foundNewsletter = newsletterRepository.findByIdOptional(newsletter.id);
        assertTrue(foundNewsletter.isPresent());
        assertEquals(newsletter.title, foundNewsletter.get().title);
        assertEquals(newsletter.description, foundNewsletter.get().description);
        assertEquals(newsletter.link, foundNewsletter.get().link);
    }

    @Test
    @Transactional
    public void findUnsentNewsletters() {
        Newsletter newsletter1 = new Newsletter();
        newsletter1.title = "Newsletter 1";
        newsletter1.description = "Description 1";
        newsletter1.link = "http://example.com/1";

        Newsletter newsletter2 = new Newsletter();
        newsletter2.title = "Newsletter 2";
        newsletter2.description = "Description 2";
        newsletter2.link = "http://example.com/2";

        newsletterRepository.saveNewsletter(newsletter1);
        newsletterRepository.saveNewsletter(newsletter2);

        List<Newsletter> newsletters = newsletterService.findUnsentNewsletters();
        assertEquals(2, newsletters.size());
    }

    /*
     * @Test
     * 
     * @Transactional
     * public void testGetNewsletterById() {
     * Newsletter newsletter = new Newsletter();
     * newsletter.title = "Newsletter Title";
     * newsletter.description = "Newsletter Description";
     * newsletter.link = "http://example.com";
     * 
     * newsletterRepository.saveNewsletter(newsletter);
     * 
     * Optional<Newsletter> foundNewsletter = newsletterService.(newsletter.id);
     * assertTrue(foundNewsletter.isPresent());
     * assertEquals(newsletter.id, foundNewsletter.get().id);
     * assertEquals(newsletter.title, foundNewsletter.get().title);
     * }
     */
    @Test
    @Transactional
    public void testInvalidLinkFormat() {
        Newsletter newsletter = new Newsletter();
        newsletter.title = "Invalid Link";
        newsletter.description = "Description";
        newsletter.link = "invalid-link";

        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            newsletterRepository.persistAndFlush(newsletter);
        });

        assertTrue(exception.getMessage().contains("Invalid URL format"));
    }
}

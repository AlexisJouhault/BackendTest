package com.example.UrlShortener.utils;

import com.example.UrlShortener.models.ShortenedUrl;
import com.example.UrlShortener.repositories.UrlRepository;
import com.example.UrlShortener.utils.UrlShortener;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlShortenerTest {

    private String url = "www.google.com";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UrlRepository mMockedUrlRepository;

    @InjectMocks
    UrlShortener mTested;

    @Before
    public void setUp() throws Exception {
        when(mMockedUrlRepository.exists(anyString())).thenReturn(false);
    }

    @Test
    public void shouldShortenUrl() throws Exception {
        String shortened = mTested.shortenUrl(url);

        assertNotNull(shortened);
        assertTrue(shortened.length() > 0);
    }

    @Test
    public void shouldGenerateRandomHash() throws Exception {
        //todo: change behavior depending on expected result
        String firstHash = mTested.getUrlHash(url);
        String secondHash = mTested.getUrlHash(url);

        assertNotSame(firstHash, secondHash);
        assertSame(firstHash.length(), secondHash.length());
    }
}

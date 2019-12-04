package com.huber.aoc04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SecureContainerTest {
    private SecureContainer secureContainer;

    @BeforeEach
    void setUp() {
        this.secureContainer = new SecureContainer();
    }

    @Test
    void checkPassword() {
        assertTrue(this.secureContainer.checkPassword("111111"));
        assertTrue(this.secureContainer.checkPassword("111123"));
        assertFalse(this.secureContainer.checkPassword("223450"));
        assertFalse(this.secureContainer.checkPassword("135679"));
        assertFalse(this.secureContainer.checkPassword("123789"));
        assertFalse(this.secureContainer.checkPassword("402328"));
    }
}
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
    void checkPasswordOne() {
        assertTrue(this.secureContainer.checkPasswordOne("111111"));
        assertTrue(this.secureContainer.checkPasswordOne("111123"));
        assertFalse(this.secureContainer.checkPasswordOne("223450"));
        assertFalse(this.secureContainer.checkPasswordOne("135679"));
        assertFalse(this.secureContainer.checkPasswordOne("123789"));
        assertFalse(this.secureContainer.checkPasswordOne("402328"));
    }

    @Test
    void checkPasswordTwo() {
        assertTrue(this.secureContainer.checkPasswordTwo("112233"));
        assertTrue(this.secureContainer.checkPasswordTwo("111122"));
        assertFalse(this.secureContainer.checkPasswordTwo("123444"));
        assertFalse(this.secureContainer.checkPasswordTwo("124444"));
        assertTrue(this.secureContainer.checkPasswordTwo("112222"));
        assertFalse(this.secureContainer.checkPasswordTwo("112220"));
        assertFalse(this.secureContainer.checkPasswordTwo("444445"));
        assertTrue(this.secureContainer.checkPasswordTwo("112223"));
    }
}
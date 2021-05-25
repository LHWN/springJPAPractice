package com.springJPAPractice.springJPAPractice.Models;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResetDatabase {
    @Autowired
    private Flyway flyway;

    @BeforeEach
    public void setUp() {
        // 1. DB Clean
        flyway.clean();
        // 2. DB Migrate
        flyway.migrate();
    }
}

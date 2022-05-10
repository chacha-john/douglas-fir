package chachaup.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static java.time.LocalTime.now;
import static org.junit.jupiter.api.Assertions.*;

class SightingTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sighting_instantiatesCorrectly() {
        Sighting sighting = new Sighting("kayote","can i call you tom");
        sighting.save();
        assertEquals(3,sighting.getId());
    }

    @Test
    void sighting_recordsTimeWhenSightingWasMade() {
        Sighting sighting = new Sighting("kayote","can i call you tom");
        sighting.save();
        assertEquals(now().getSecond(), Sighting.findById(sighting.getId()).getTimeOfSight().getSeconds());
    }

    @Test
    void sighting_searchById() {
        Sighting sighting = new Sighting("kayote","can i call you tom");
        sighting.save();
        Sighting sighting1 = Sighting.findById(sighting.getId());
        assertTrue(sighting.getRangerName().equals(sighting1.getRangerName()));
    }
}
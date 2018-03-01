package gb.nabson.taxonomy.api.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {
    private Division division;

    @Before
    public void setUp() {
        this.division = new Division();
    }
    @Test
    public void getId() {
        String id = "division_test";

        division.setId(id);
        assertEquals(id, division.getId());
    }

}
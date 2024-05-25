package db;

import helpers.DataBaseHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DBResultsTest {
    private DataBaseHelper dataBaseHelper = new DataBaseHelper();

    @BeforeEach
    public void initPages() {
        dataBaseHelper = new DataBaseHelper();
    }

    @Test
    public void testDBConnection() {
        String citizenIdByPassport = dataBaseHelper.getCitizenIdByPassport();
        String applicationIdByCitizenId = dataBaseHelper.getApplicationIdByCitizenId();
        System.out.println(citizenIdByPassport + " " + applicationIdByCitizenId);
    }
}

package db;

import exceptions.WrongUserStatusInDBException;
import helpers.DataBaseHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DBUserStatusTest {
    private DataBaseHelper dataBaseHelper = new DataBaseHelper();

    @BeforeEach
    public void initPages() {
        dataBaseHelper = new DataBaseHelper();
    }

    @Test
    public void getUserStatusTest() {
        String status = "";
        try {
            status = dataBaseHelper.getWrongApplicationStatus();
            checkUserStatus(status);
        } catch (WrongUserStatusInDBException e) {
            System.out.println("So sad, try later. Current user status is " + status);
            status = dataBaseHelper.getApplicationStatus();
        } finally {
            System.out.println("Current status is " + status);
        }
    }

    public static void checkUserStatus(String userStatus) throws WrongUserStatusInDBException {
        if (!userStatus.equals("approved")) {
            throw new WrongUserStatusInDBException("User status is under consideration or rejected");
        }
    }
}

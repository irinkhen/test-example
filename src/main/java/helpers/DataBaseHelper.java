package helpers;

import config.DataBaseConnection;
import exceptions.WrongUserStatusInDBException;
import io.qameta.allure.Step;

public class DataBaseHelper {
    @Step("Get random user Id")
    public String getCitizenIdByPassport() {
        String query = "SELECT citizenid FROM reg_office.citizens ORDER BY RANDOM() LIMIT 1";
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Get random application id")
    public String getApplicationIdByCitizenId() {
        String query = "SELECT applicationId FROM reg_office.applications ORDER BY RANDOM() LIMIT 1";
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Get application status from database")
    public String getApplicationStatus() {
        String query = "SELECT statusofapplication FROM reg_office.applications " +
                "WHERE statusofapplication = 'approved' ORDER BY RANDOM() LIMIT 1";
        return new DataBaseConnection().getSingleValueQuery(query);
    }

    @Step("Get application status from database")
    public String getWrongApplicationStatus() throws WrongUserStatusInDBException {
        String query = "SELECT statusofapplication FROM reg_office.applications " +
                "WHERE statusofapplication != 'approved' ORDER BY RANDOM() LIMIT 1";
        return new DataBaseConnection().getSingleValueQuery(query);
    }
}


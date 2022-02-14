package de.goldmann.realestate.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqlLiteConnectorTest {

    SqlLiteConnector cut;

    @Test
    public void loadData() {
        this.cut = new SqlLiteConnector();
        this.cut.loadData();
    }
}
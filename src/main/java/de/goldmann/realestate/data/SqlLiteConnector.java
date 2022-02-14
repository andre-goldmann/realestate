/*
 * Created: 13.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Andre Goldmann
 */
public class SqlLiteConnector {
    private static final String url = "jdbc:sqlite:/home/goldmann/development/workspace-private/tradingview-strategy-optimizer/configuration.db";

    public boolean loadData(){
        final String realtorSelect ="select * from realtor_estates";
        try (Connection conn = this.connect();
            final PreparedStatement pstmt  = conn.prepareStatement(realtorSelect)){

            // set the value
//            pstmt.setString(1, symbol);
//            pstmt.setString(2, direction);
//            pstmt.setString(3, trend);
//            pstmt.setString(4, signal);
//            pstmt.setInt(5, trendLength);
//            pstmt.setString(5, timeframe);
            //

            final ResultSet rs  = pstmt.executeQuery();
            final int result = rs.getInt(1);
            return result > 0;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

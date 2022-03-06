package de.timedin.jUtils.methods;

import de.timedin.jUtils.Logger;

import java.awt.TrayIcon.MessageType;
import java.sql.*;

@SuppressWarnings("unused")
public class DBConnector {
    private final String host;
    private final String dbName;
    private final String user;
    private final String password;
    private Connection con;

    public DBConnector(String host, String dbName, String user, String password) throws SQLException {
        this.host = host;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        connect();
    }

    public void connect() throws SQLException {
        if ((host + dbName).contains("&") || (host + dbName).contains("?")) {
            throw new SQLException("Hostname and Database-names cant contain '&' or '?'.");
        }
        String url = "jdbc:mysql://" + host + "/" + dbName;
        try {
            new com.mysql.cj.jdbc.Driver();
            con = DriverManager.getConnection(url, user, password);
            Logger.log("Connection was successfully.", MessageType.INFO);
        } catch (SQLInvalidAuthorizationSpecException e) {
            throw new SQLException("Wrong database credentials specified.");
        } catch (SQLNonTransientConnectionException e) {
            throw new SQLException("Wrong Database hostname specified.");
        }
    }

    public ResultSet querySingleRow(String sqlQuery) throws SQLException {
        return querySingleRow(sqlQuery, null);
    }

    public ResultSet querySingleRow(String sqlQuery, Object[] preparedValues) throws SQLException {
        ResultSet rs = query(sqlQuery, preparedValues);
        if (!rs.next()) {
            return null;
        }
        return rs;
    }

    public ResultSet query(String sqlQuery) throws SQLException {
        return query(sqlQuery, null);
    }

    public ResultSet query(String sqlQuery, Object[] preparedValues) throws SQLException {
        if (con == null || con.isClosed()) {
            Logger.log("Exit", null);
            return null;
        }
        ResultSet out;
        PreparedStatement stmt;
        stmt = con.prepareStatement(sqlQuery);

        for (int i = 0; i < preparedValues.length; i++) {
            stmt.setObject(i + 1, preparedValues[i]);
        }
        out = stmt.executeQuery();
        return out;
    }

    public Integer update(String sqlQuery) throws SQLException {
        return update(sqlQuery, null);
    }

    public Integer update(String sqlQuery, Object[] preparedValues) throws SQLException {
        if (con == null || con.isClosed()) {
            Logger.log("Exit", null);
            return null;
        }
        int out;
        PreparedStatement stmt;
        stmt = con.prepareStatement(sqlQuery);
        for (int i = 0; i < preparedValues.length; i++) {
            stmt.setObject(i + 1, preparedValues[i]);
        }
        out = stmt.executeUpdate();
        return out;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        con.close();
    }

    @Deprecated
    public Integer insert(String sqlQuery) throws SQLException {
        return update(sqlQuery, null);
    }

    @Deprecated
    public Integer edit(String sqlQuery) throws SQLException {
        return update(sqlQuery, null);
    }

    @Deprecated
    public Integer delete(String sqlQuery) throws SQLException {
        return update(sqlQuery, null);
    }

    @Deprecated
    public Integer insert(String sqlQuery, Object[] preparedValues) throws SQLException {
        return update(sqlQuery, preparedValues);
    }

    @Deprecated
    public Integer edit(String sqlQuery, Object[] preparedValues) throws SQLException {
        return update(sqlQuery, preparedValues);
    }

    @Deprecated
    public Integer delete(String sqlQuery, Object[] preparedValues) throws SQLException {
        return update(sqlQuery, preparedValues);
    }
}

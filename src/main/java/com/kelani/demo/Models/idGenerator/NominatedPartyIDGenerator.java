package com.kelani.demo.Models.idGenerator;

import java.io.Serializable;
import java.sql.*;

import org.hibernate.HibernateException;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.Connection;

public class NominatedPartyIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        String prefix = "N-PARTY-";
        Connection connection = sharedSessionContractImplementor.connection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(nominated_party_id) as Id from nominated_party");
            if (rs.next()) {
                int id = rs.getInt(1) + 101;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}

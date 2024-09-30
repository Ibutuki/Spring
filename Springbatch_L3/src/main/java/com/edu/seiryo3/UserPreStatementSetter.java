package com.edu.seiryo3;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

public class UserPreStatementSetter implements ItemPreparedStatementSetter<User>{

	@Override
	public void setValues(User item, PreparedStatement ps) throws SQLException {
		ps.setLong(1, item.getId());
        ps.setString(2, item.getName());
        ps.setInt(3, item.getAge());
	}

}

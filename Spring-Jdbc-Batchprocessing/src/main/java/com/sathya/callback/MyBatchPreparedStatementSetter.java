package com.sathya.callback;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

public class MyBatchPreparedStatementSetter implements BatchPreparedStatementSetter {
	List<Integer> custidsList=Arrays.asList(101,102,103);
	List<String> custnamesList=Arrays.asList("scott","miller","james");
	List<String> citiesList=Arrays.asList("HYD","BAN","DELHI");

	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setInt(1,custidsList.get(i));
		ps.setString(2,custnamesList.get(i));
		ps.setString(3,citiesList.get(i));

	}

	public int getBatchSize() {

		return 3;
	}

}

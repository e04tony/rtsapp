package com.mercury.rtsapp.repository.load;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface LoadUtility {
	public void setPs(PreparedStatement ps) throws SQLException;
}

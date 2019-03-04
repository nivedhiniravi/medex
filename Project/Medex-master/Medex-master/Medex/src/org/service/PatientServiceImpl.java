package org.service;

import org.beans.Patient;
import org.dao.Dao;
import org.dao.DaoImpl;

public class PatientServiceImpl implements PatientService {
	
	Dao dao =new DaoImpl();

	@Override
	public boolean register(Patient p) {
		boolean b=dao.insert(p);
		return b;
	}

}

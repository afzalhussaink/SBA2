package com.eval.coronakit.service;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.exception.ProductMasterException;

public interface CoronaKitService {
	public CoronaKit saveKit(CoronaKit kit) throws ProductMasterException;
	public CoronaKit getKitById(int kitId);
}

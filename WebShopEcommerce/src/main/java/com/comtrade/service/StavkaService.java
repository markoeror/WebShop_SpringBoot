package com.comtrade.service;

import java.util.ArrayList;

import com.comtrade.entity.Stavke;
import com.comtrade.entity.User;

public interface StavkaService {

	public void insertKupovine(ArrayList<Stavke> lista, User user);
}

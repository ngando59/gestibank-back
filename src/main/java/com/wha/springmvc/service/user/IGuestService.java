package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.user.Guest;

public interface IGuestService {
	void save(Guest guest);

	Guest findOneById(long id);

	List<Guest> findAll();

	void update(long id, Guest guest);

	void delete(long id);
}

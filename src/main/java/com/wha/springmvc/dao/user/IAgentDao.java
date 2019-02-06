package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.user.Agent;

public interface IAgentDao {
	void save(Agent user);

	Agent findOneById(long id);

	List<Agent> findAll();

	void update(long id, Agent user);

	void delete(long id);
}

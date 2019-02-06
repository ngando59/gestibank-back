package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.user.Agent;

public interface IAgentService {
	void save(Agent agent);

	Agent findOneById(long id);

	List<Agent> findAll();

	void update(long id, Agent agent);

	void delete(long id);
}

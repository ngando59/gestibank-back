package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.user.IAgentDao;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.service.user.IAgentService;

@Service
@Transactional
public class AgentServiceImpl implements IAgentService {

	@Autowired
	private IAgentDao dao;

	@Override
	public void save(Agent agent) {
		dao.save(agent);
	}

	@Override
	public Agent findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Agent> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Agent agent) {
		dao.update(id, agent);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}

package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.Exercise1Service;

@Service("exercise1Service")
public class Exercise1ServiceImpl implements Exercise1Service{

	private static final Log LOG = LogFactory.getLog(Exercise1ServiceImpl.class);
	
	@Override
	public void logMessage() {
		LOG.info("SERVICE Exercise1 EXEC");
	}

}

package org.james.actuator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.james.actuator.entity.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	
	public SysUser findByUsername(String username);

}

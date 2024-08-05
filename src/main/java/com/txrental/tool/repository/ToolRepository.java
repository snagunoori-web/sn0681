package com.txrental.tool.repository;

import com.txrental.tool.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Long> {
    Tool findByToolCode(String toolCode);
}

package com.txrental.tool.repository;

import com.txrental.tool.entity.ToolRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRentalRepository extends JpaRepository<ToolRental, Long> {

    ToolRental findByToolType(String toolType);

}

package com.repository.contract;

import com.model.contract.AttachContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachContractRepository extends JpaRepository<AttachContract, Integer> {

    @Query(value = "SELECT * " +
            "FROM attach_contract as ac " +
            "JOIN contract_detail as cd ON cd.attach_facility_id = ac.id " +
            "JOIN contract ON cd.contract_id = contract.contract_id " +
            "WHERE contract.contract_id = :id ", nativeQuery = true)
    List<AttachContract> findAttachContract(@Param("id") Integer id);
}


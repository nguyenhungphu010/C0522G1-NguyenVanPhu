use module_5_final_test_2; 

INSERT INTO `module_5_final_test_2`.`customer` (`id`, `customer_name`) VALUES ('1', 'Nguyễn Văn Phú');
INSERT INTO `module_5_final_test_2`.`customer` (`id`, `customer_name`) VALUES ('2', 'Nguyễn Tất Thành');
INSERT INTO `module_5_final_test_2`.`customer` (`id`, `customer_name`) VALUES ('3', 'Nguyễn Thị Thủy Tiên ');
INSERT INTO `module_5_final_test_2`.`customer` (`id`, `customer_name`) VALUES ('4', 'Nguyễn Văn Tí');

INSERT INTO `module_5_final_test_2`.`books` (`id`, `customer_id`, `openDate`, `savingDate`, `period`, `savingAmount`, `interestRate`, `promotion`) VALUES ('1', '2', '2022-05-01', '2022-05-05', '6 tháng', '10000000', '8', 'condom');
INSERT INTO `module_5_final_test_2`.`books` (`id`, `customer_id`, `openDate`, `savingDate`, `period`, `savingAmount`, `interestRate`, `promotion`) VALUES ('2', '3', '2022-05-05', '2022-05-05', '3 tháng', '20000000', '5', 'condom big size');
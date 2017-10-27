ALTER TABLE consume_record MODIFY other DECIMAL COMMENT '其他';
ALTER TABLE consume_record MODIFY breakfast DECIMAL(10,2) COMMENT '早餐';
ALTER TABLE consume_record MODIFY lunch DECIMAL(10,2) COMMENT '午餐';
ALTER TABLE consume_record MODIFY dinner DECIMAL(10,2) COMMENT '晚餐';
ALTER TABLE consume_record MODIFY other DECIMAL(10,2) COMMENT '其他';
ALTER TABLE account_info MODIFY balance DECIMAL(10,2) COMMENT '余额';
ALTER TABLE recharge_record MODIFY recharge_money DECIMAL(10,2) COMMENT '充值金额';
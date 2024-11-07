DROP TABLE IF EXISTS coin_type;
CREATE TABLE coin_type
(
    code           VARCHAR(5) NOT NULL PRIMARY KEY, -- 幣別代碼，例如 USD
    symbol         VARCHAR(20),                     -- 幣別符號，例如 $
    rate           VARCHAR(20),                     -- 匯率，例如 73,743.961
    description_en VARCHAR(100),                    -- 幣別英文描述，例如 United States Dollar
    description_ch VARCHAR(100),                    -- 幣別中文描述，例如 美元
    rate_float     DECIMAL(10, 4),                  -- 匯率的小數表示，例如 73743.9607
    update_time    DATETIME DEFAULT NOW()           -- 更新時間
);



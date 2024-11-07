INSERT INTO `coin_type` (code, symbol, rate, description_en, description_ch, rate_float)
VALUES ('USD', '&#36;', '73,743.961', 'United States Dollar', '美金', 73743.9607),
       ('GBP', '&pound;', '57,373.76', 'British Pound Sterling', '英鎊', 57373.7601),
       ('EUR', '&euro;', '68,996.472', 'Euro', '歐元', 68996.472);



INSERT INTO `coin_config` (id,description_en, description_ch)
VALUES (1, 'USD', '美金'),
       (2, 'GBP', '英鎊'),
       (3, 'EUR', '歐元');
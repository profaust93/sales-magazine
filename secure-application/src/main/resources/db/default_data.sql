INSERT INTO PRODUCERS(PRODUCER_ID, NAME, PRODUCER_URL, TOR, LAST_UPDATE, VERSION)
            VALUES (0, 'Apple', 'www.apple.com', SYSDATE, SYSDATE, 0);
INSERT INTO PRODUCT( PRODUCT_ID, NAME, PRICE, LAST_UPDATE, PRODUCT_URL, VERSION, PRODUCER_ID)
            VALUES (NEXT VALUE FOR PRODUCT_SEQ, 'iPhone 7', 10, SYSDATE, 'http://www.apple.com/iphone', 0, 0);
INSERT INTO PRODUCT( PRODUCT_ID, NAME, PRICE, LAST_UPDATE, PRODUCT_URL, VERSION, PRODUCER_ID)
            VALUES (NEXT VALUE FOR PRODUCT_SEQ, 'Mac', 10, SYSDATE, 'http://www.apple.com/mac/', 0, 0);
INSERT INTO PRODUCT( PRODUCT_ID, NAME, PRICE, LAST_UPDATE, PRODUCT_URL, VERSION, PRODUCER_ID)
            VALUES (NEXT VALUE FOR PRODUCT_SEQ, 'iPad', 10, SYSDATE, 'http://www.apple.com/ipad/', 0, 0);
INSERT INTO PRODUCT( PRODUCT_ID, NAME, PRICE, LAST_UPDATE, PRODUCT_URL, VERSION, PRODUCER_ID)
            VALUES (NEXT VALUE FOR PRODUCT_SEQ, 'Watch', 10, SYSDATE, 'http://www.apple.com/watch/', 0, 0);


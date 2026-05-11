-- 1. 切换到你的业务数据库 (非常关键，不要建在 CDB 里)
ALTER SESSION SET CONTAINER = FREEPDB1;

-- 2. 创建你的测试用户并赋予最高权限
-- (如果报错说用户已存在没关系，继续往下跑)
CREATE USER ORAUSR00 IDENTIFIED BY ORAUSR00;
GRANT DBA TO ORAUSR00;

-- 3. 建表
CREATE TABLE ORAUSR00.TEST_BULK_TABLE (
    ID NUMBER, 
    DATA_FILLER VARCHAR2(2000)
);

-- 4. 插入 10 万条“胖数据” (这大概会生成 150MB 的数据量)
-- 这个过程大概需要十几秒，请耐心等待直到出现 "PL/SQL procedure successfully completed."
BEGIN
  FOR i IN 1..100000 LOOP
    INSERT INTO ORAUSR00.TEST_BULK_TABLE VALUES (i, LPAD('A', 1500, 'A'));
    IF MOD(i, 10000) = 0 THEN 
      COMMIT; 
    END IF;
  END LOOP;
  COMMIT;
END;
/

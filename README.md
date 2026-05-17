$mockDataSql = @"
-- 1. 强行把数据泵目录指到你 docker-compose 挂载的物理路径！
CREATE OR REPLACE DIRECTORY DATA_PUMP_DIR AS '/opt/oracle/oradata/dpdump';

-- 2. 创建测试用户并赋予权限
BEGIN EXECUTE IMMEDIATE 'DROP USER ORAUSR00 CASCADE'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
CREATE USER ORAUSR00 IDENTIFIED BY orausr00;
GRANT DBA TO ORAUSR00;

-- 3. 建表
CREATE TABLE ORAUSR00.TEST_BULK_TABLE (ID NUMBER, DATA_FILLER VARCHAR2(2000));

-- 4. 灌入 10 万条胖数据（为了切片）
BEGIN
  FOR i IN 1..100000 LOOP
    INSERT INTO ORAUSR00.TEST_BULK_TABLE VALUES (i, LPAD('A', 1500, 'A'));
    IF MOD(i, 10000) = 0 THEN COMMIT; END IF;
  END LOOP;
  COMMIT;
END;
/
EXIT;
"@

$mockDataSql | docker exec -i rds-mock bash -c "export ORACLE_PDB_SID=ORCLPDB1 && sqlplus -s / as sysdba"
Write-Host ">>> 数据与目录准备完毕！" -ForegroundColor Green

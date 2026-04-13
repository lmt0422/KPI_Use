-- パラメータ定義
-- &1: S3 Bucket Name
-- &2: RDS Directory Name (e.g., 'DATA_PUMP_DIR')
-- &3: Dump File Prefix
DEFINE U5_S3EXPIMPBKT = '&1'
DEFINE DUMP_DIR_NAME = '&2'
DEFINE DUMPFILE_PREFIX = '&3'

whenever sqlerror exit failure
whenever oserror exit failure

set linesize 130
set pagesize 0
set serveroutput on size 1000000
variable rc number

DECLARE
    l_task_id   VARCHAR2(100);
    l_file_name VARCHAR2(100);
BEGIN
    -- 単一ファイルテスト用の設定
    l_file_name := '&DUMPFILE_PREFIX' || '.dmp';

    dbms_output.put_line('===================================================');
    dbms_output.put_line('[INFO] S3からのダウンロード要求を開始します。');
    dbms_output.put_line('ファイル名: ' || l_file_name);
    dbms_output.put_line('S3バケット: &U5_S3EXPIMPBKT');
    dbms_output.put_line('RDSディレクトリ: &DUMP_DIR_NAME');

    -- RDS標準関数を呼び出してTask IDを取得
    l_task_id := rdsadmin.rdsadmin_s3_tasks.download_from_s3(
        p_s3_bucket_name => '&U5_S3EXPIMPBKT',
        p_directory_name => '&DUMP_DIR_NAME',
        p_s3_prefix      => l_file_name
    );

    dbms_output.put_line('---------------------------------------------------');
    dbms_output.put_line('[SUCCESS] ダウンロードタスクが正常に発行されました。');
    dbms_output.put_line('[TASK ID] ' || l_task_id);
    dbms_output.put_line('---------------------------------------------------');
    dbms_output.put_line('以下のSQLを実行して、ダウンロードの進捗状況を確認してください：');
    dbms_output.put_line('SELECT text FROM table(rdsadmin.rds_file_util.read_text_file(''BDUMP'', ''dbtask-' || l_task_id || '.log''));');
    dbms_output.put_line('===================================================');

    :rc := 0;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('[ERROR] ダウンロードタスクの発行中にエラーが発生しました：');
        dbms_output.put_line(SQLERRM);
        :rc := 99;
END;
/

-- 戻り値をPowerShellに渡す
exit :rc
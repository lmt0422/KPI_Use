aws s3 cp s3://value-dev-s3-tokyo-logbk-001/kaichi_tmp/rm190at_result.dmp s3://value-dev-s3-tokyo-logbk-001/kaichi_tmp/rm190at_result.dmp --storage-class GLACIER
aws s3api head-object --bucket value-dev-s3-tokyo-logbk-001 --key kaichi_tmp/rm190at_result.dmp

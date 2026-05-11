$LocalEndpoint = "http://localhost:4566"

# AWS認証情報設定（LocalStack用ダミー）
Initialize-AWSDefaultConfiguration `
    -AccessKey "mock-key" `
    -SecretKey "mock-secret" `
    -Region "us-east-1"

Write-Host ">>> ローカルDockerに接続：S3 Bucket作成..." -ForegroundColor Cyan

# S3 Bucket作成
New-S3Bucket `
    -BucketName "my-local-test-bucket" `
    -EndpointUrl $LocalEndpoint

Write-Host ">>> ローカルBucketリスト取得：" -ForegroundColor Yellow

# Bucket一覧取得
Get-S3Bucket -EndpointUrl $LocalEndpoint

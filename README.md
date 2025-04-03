private ImageView agreeImageView;
private ImageView privacyPersonaldataImageView;
private ImageView monitorAgreeImageView;

private boolean isAgreeChecked = false;
private boolean isPrivacyChecked = false;
private boolean isMonitorChecked = false;

// 規約同意ImageView
agreeImageView = socialAccount.findViewById(R.id.agree_imageview);
agreeImageView.setClickable(true);
agreeImageView.setOnClickListener(v -> {
    isAgreeChecked = !isAgreeChecked;
    updateImageViewState(agreeImageView, isAgreeChecked);
    
    if(isAgreeChecked){
        if (!isPrivacyChecked) {
            isPrivacyChecked = true;
            updateImageViewState(privacyPersonaldataImageView, true);
        }
        if (!isMonitorChecked) {
            isMonitorChecked = true;
            updateImageViewState(monitorAgreeImageView, true);
        }
    } else {
        if (isPrivacyChecked) {
            isPrivacyChecked = false;
            updateImageViewState(privacyPersonaldataImageView, false);
        }
        if (isMonitorChecked) {
            isMonitorChecked = false;
            updateImageViewState(monitorAgreeImageView, false);
        }
    }
    buttonLogin.setEnabled(isAgreeChecked);
});

// 個人情報の取り扱いImageView
privacyPersonaldataImageView = socialAccount.findViewById(R.id.privacy_policy_imageview);
privacyPersonaldataImageView.setClickable(true);
privacyPersonaldataImageView.setOnClickListener(v -> {
    isPrivacyChecked = !isPrivacyChecked;
    updateImageViewState(privacyPersonaldataImageView, isPrivacyChecked);
    updateAgreeImageViewState();
});

// モニタ規約ImageView
monitorAgreeImageView = socialAccount.findViewById(R.id.monitor_agreement_imageview);
monitorAgreeImageView.setClickable(true);
monitorAgreeImageView.setOnClickListener(v -> {
    isMonitorChecked = !isMonitorChecked;
    updateImageViewState(monitorAgreeImageView, isMonitorChecked);
    updateAgreeImageViewState();
});

// 更新ImageView状态的方法
private void updateImageViewState(ImageView imageView, boolean isChecked) {
    if (isChecked) {
        imageView.setImageResource(R.drawable.ic_checkbox_checked); // 选中状态的图片
    } else {
        imageView.setImageResource(R.drawable.ic_checkbox_unchecked); // 未选中状态的图片
    }
}

private void updateAgreeImageViewState() {
    boolean allChecked = isPrivacyChecked && isMonitorChecked;
    boolean anyUnChecked = !isPrivacyChecked || !isMonitorChecked;
    
    if (allChecked && !isAgreeChecked) {
        isAgreeChecked = true;
        updateImageViewState(agreeImageView, true);
    } else if (anyUnChecked && isAgreeChecked) {
        isAgreeChecked = false;
        updateImageViewState(agreeImageView, false);
    }
    buttonLogin.setEnabled(isAgreeChecked);
}

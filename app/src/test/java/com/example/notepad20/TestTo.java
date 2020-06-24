   //长按跳出LinkDialog
        mLinkView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                FragmentManager manager=getFragmentManager();
                LinkDialog dialog=LinkDialog.newInstance(mLinkView.getText().toString());
                dialog.setTargetFragment(NoteFragment.this,REQUEST_SAVE_LINK);
                dialog.show(manager,DIALOG_LINK);
                return true;
            }
        });

        if (mPhotoFile.exists()){
            updatePhotoView();
        }else {
            updatePhotoView(mNote.getPicturePath());
        }

        switch (mTheme.getNumber()){
            case 0:
                v.setBackground(getResources().getDrawable(R.drawable.background));
                mTitleText.setTextColor(getResources().getColor(R.color.white));
                mDetailText.setTextColor(getResources().getColor(R.color.white));
                mTitleField.setTextColor(getResources().getColor(R.color.white));
                mTimeButton.setBackgroundColor(getResources().getColor(R.color.buttonColorDefault));
                mTimeButton.setTextColor(getResources().getColor(R.color.textColorDefault));
                mDetailField.setTextColor(getResources().getColor(R.color.white));
                mSolvedCheckBox.setTextColor(getResources().getColor(R.color.textColorDefault));
                mDateButton.setBackgroundColor(getResources().getColor(R.color.buttonColorDefault));
                mDateButton.setTextColor(getResources().getColor(R.color.textColorDefault));
                break;
            case 1:
                v.setBackground(getResources().getDrawable(R.drawable.background1));
                mTitleText.setTextColor(getResources().getColor(R.color.white));
                mDetailText.setTextColor(getResources().getColor(R.color.white));
                mLinkView.setAlpha(1);
                mTitleField.setTextColor(getResources().getColor(R.color.white));
                mTimeButton.setBackgroundColor(getResources().getColor(R.color.buttonColorOne));
                mTimeButton.setTextColor(getResources().getColor(R.color.textColorDefault));
                mDetailField.setTextColor(getResources().getColor(R.color.white));
                mSolvedCheckBox.setAlpha(1);
                mSolvedCheckBox.setTextColor(getResources().getColor(R.color.white));
                mDateButton.setBackgroundColor(getResources().getColor(R.color.buttonColorOne));
                mDateButton.setTextColor(getResources().getColor(R.color.textColorDefault));
                break;
            case 2:
                v.setBackground(getResources().getDrawable(R.drawable.background2));
                mTitleText.setTextColor(getResources().getColor(R.color.white));
                mDetailText.setTextColor(getResources().getColor(R.color.white));
                mLinkView.setAlpha(1);
                mTitleField.setTextColor(getResources().getColor(R.color.white));
                mTimeButton.setBackgroundColor(getResources().getColor(R.color.buttonColorOne));
                mTimeButton.setTextColor(getResources().getColor(R.color.textColorDefault));
                mDetailField.setTextColor(getResources().getColor(R.color.white));
                mSolvedCheckBox.setAlpha(1);
                mSolvedCheckBox.setTextColor(getResources().getColor(R.color.white));
                mDateButton.setBackgroundColor(getResources().getColor(R.color.buttonColorOne));
                mDateButton.setTextColor(getResources().getColor(R.color.textColorDefault));
                break;
            case 3:
                v.setBackground(getResources().getDrawable(R.drawable.background3));
                mTitleText.setTextColor(getResources().getColor(R.color.textColorThree));
                mDetailText.setTextColor(getResources().getColor(R.color.textColorThree));
                mLinkView.setAlpha(1);
                mTitleField.setTextColor(getResources().getColor(R.color.textColorThree));
                mTimeButton.setBackgroundColor(getResources().getColor(R.color.buttonColorThree));
                mTimeButton.setTextColor(getResources().getColor(R.color.textColorThree));
                mDetailField.setTextColor(getResources().getColor(R.color.textColorThree));
                mSolvedCheckBox.setTextColor(getResources().getColor(R

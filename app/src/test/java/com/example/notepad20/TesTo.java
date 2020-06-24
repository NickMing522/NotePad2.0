blic class DialogContextFragment extends DialogFragment {
    public static final String EXTRA_TEXT="com.example.notepad20.text";
    private static final String ARGS_TEXT="textArgs";


    private EditText mContentEditText;

    private String mText;

    public static DialogContextFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putSerializable(ARGS_TEXT,text);
        DialogContextFragment fragment = new DialogContextFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog_context,null);
        mText=(String) getArguments().getSerializable(ARGS_TEXT);

        mContentEditText=view.findViewById(R.id.context_content);
        mContentEditText.setText(mText);
        mContentEditText.setTextColor(getResources().getColor(R.color.textColor));
        mContentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mText=charSequence.toString();
            }

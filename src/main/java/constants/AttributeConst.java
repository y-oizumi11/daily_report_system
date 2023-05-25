package constants;

public enum AttributeConst {
  //フラッシュメッセージ
    FLUSH("flush"),

    //一覧画面共通
    MAX_ROW("maxRow"),
    PAGE("page"),

    //入力フォーム共通
    TOKEN("_token"),
    ERR("errors"),

    //ログイン中の従業員
    LOGIN_EMP("login_employee"),

    //ログイン画面
    LOGIN_ERR("loginError"),

    //従業員管理
    EMPLOYEE("employee"),
    EMPLOYEES("employees"),
    EMP_COUNT("employees_count"),
    EMP_ID("id"),
    EMP_CODE("code"),
    EMP_PASS("password"),
    EMP_NAME("name"),
    EMP_ADMIN_FLG("admin_flag"),
    EMP_MGR_FLG("mgr_flag"), //追記

    //管理者フラグ
    ROLE_ADMIN(1),
    ROLE_GENERAL(0),

    //削除フラグ
    DEL_FLAG_TRUE(1),
    DEL_FLAG_FALSE(0),

    //マネージャーフラグ（追記）
    ROLE_MGR(1),
    ROLE_NOT_MGR(0),

    //日報管理
    REPORT("report"),
    REPORTS("reports"),
    REP_COUNT("reports_count"),
    REP_ID("id"),
    REP_DATE("report_date"),
    REP_TITLE("title"),
    REP_CONTENT("content_msg"),
    REP_COMFIRM("comfirmed_date"), //追記
    REP_APPROVED_FLAG("approved_flag"),
    REP_PENDING_FLAG("pending_flag"),
    REP_DISAPPROVED_FLAG("disapproved_flag"),

    //承認済み、追記
    REP_APPROVED(1),
    REP_NOT_APPROVED(0),

    //保留、追記
    REP_PENDING(1),
    REP_NOT_PENDING(0),

    //差し戻し、追記
    REP_DISAPPROVED(1),
    REP_NOT_DISAPPROVED(0);

    private final String text;
    private final Integer i;

    private AttributeConst(final String text) {
        this.text = text;
        this.i = null;
    }

    private AttributeConst(final Integer i) {
        this.text = null;
        this.i = i;
    }

    public String getValue() {
        return this.text;
    }

    public Integer getIntegerValue() {
        return this.i;
    }
}

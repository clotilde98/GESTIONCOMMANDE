package modelPackage;

public class Language {
    private String code;
    private String label;

    public Language(String code, String label){
        setCode(code);
        setLabel(label);
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

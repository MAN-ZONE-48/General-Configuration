package id.project.skripsi.manzone.dto;

public class GeneralConfigDTO {
    private String userName;
    private String userConfigValue;

    public static class Builder{
        private String userName;
        private String userConfigValue;

        public Builder(String userName){ this.userName = userName;}

        public Builder withUserConfigVale(){
            this.userConfigValue = userConfigValue;
            return this;
        }
        public GeneralConfigDTO build(){return new GeneralConfigDTO(this);}

    }

    private GeneralConfigDTO(Builder builder) {
        this.userName = builder.userName;
        this.userConfigValue = builder.userConfigValue;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserConfigValue() {
        return userConfigValue;
    }
}

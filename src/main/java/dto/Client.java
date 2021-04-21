package dto;

public class Client {
    private  String firmName;
    private String firmTown;
    private String firmAddress;
    private String firmMol;
    private Boolean firmIsRegVat;

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public void setFirmTown(String firmTown) {
        this.firmTown = firmTown;
    }

    public void setFirmAddress(String firmAddress) {
        this.firmAddress = firmAddress;
    }

    public void setFirmMol(String firmMol) {
        this.firmMol = firmMol;
    }

    public void setFirmIsRegVat(Boolean firmIsRegVat) {
        this.firmIsRegVat = firmIsRegVat;
    }
}

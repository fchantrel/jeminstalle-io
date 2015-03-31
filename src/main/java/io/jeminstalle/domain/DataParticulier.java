package io.jeminstalle.domain;

public class DataParticulier {

    private RefGeo refGeo;
    private Pollution pollution;
    private Couverture4G couverture4G;
    private RevenuMoyen revenuMoyen;
    private Precipitation precipitation;
    private Nucleaire nucleaire;

    public RefGeo getRefGeo() {
        return refGeo;
    }

    public void setRefGeo(RefGeo refGeo) {
        this.refGeo = refGeo;
    }

    public Pollution getPollution() {
        return pollution;
    }

    public void setPollution(Pollution pollution) {
        this.pollution = pollution;
    }


    public Couverture4G getCouverture4G() {
        return couverture4G;
    }

    public void setCouverture4G(Couverture4G couverture4G) {
        this.couverture4G = couverture4G;
    }

    public RevenuMoyen getRevenuMoyen() {
        return revenuMoyen;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public Nucleaire getNucleaire() {
        return nucleaire;
    }

    public void setNucleaire(Nucleaire nucleaire) {
        this.nucleaire = nucleaire;
    }

    public void setRevenuMoyen(RevenuMoyen revenuMoyen) {
        this.revenuMoyen = revenuMoyen;

    }
}

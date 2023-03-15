package resources;

public enum APIResources {

    IamService("https://dev-ingress-gateway.gaiansolutions.com/iam-service/oauth/token"),
    CreateConfig("http://ingress-gateway.gaiansolutions.com/engagements-web/v1.0/GAIAN/configs"),
    getAllConfigs("http://ingress-gateway.gaiansolutions.com/engagements-web/v1.0/GAIAN/configs"),
    getConfiguration("http://ingress-gateway.gaiansolutions.com/engagements-web/v1.0/GAIAN/configs/de35154a-63ee-4f4b-a851-37289c265f61"),
    updateExistingConfig("http://ingress-gateway.gaiansolutions.com/engagements-web/v1.0/GAIAN/configs/de35154a-63ee-4f4b-a851-37289c265f61");

    private String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }


}

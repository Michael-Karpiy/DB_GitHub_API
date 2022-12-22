package db_github_api.MainComponents;

import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("login") private String login;
    @SerializedName("id") private String id;
    @SerializedName("node_id") private String node_id;
    @SerializedName("avatar_url") private String avatar_url;
    @SerializedName("gravatar_id") private String gravatar_id;
    @SerializedName("url") private String url;
    @SerializedName("html_url") private String html_url;
    @SerializedName("followers_url") private String followers_url;
    @SerializedName("following_url") private String following_url;
    @SerializedName("gists_url") private String gists_url;
    @SerializedName("starred_url") private String starred_url;
    @SerializedName("subscriptions_url") private String subscriptions_url;
    @SerializedName("organizations_url") private String organizations_url;
    @SerializedName("repos_url") private String repos_url;
    @SerializedName("events_url") private String events_url;
    @SerializedName("received_events_url") private String received_events_url;
    @SerializedName("type") private String type;
    @SerializedName("site_admin") private String site_admin;
    @SerializedName("name") private String name;
    @SerializedName("company") private String company;
    @SerializedName("blog") private String blog;
    @SerializedName("location") private String location;
    @SerializedName("email") private String email;
    @SerializedName("hireable") private String hireable;
    @SerializedName("bio") private String bio;
    @SerializedName("twitter_username") private String twitter_username;
    @SerializedName("public_repos") private String public_repos;
    @SerializedName("public_gists") private String public_gists;
    @SerializedName("followers") private String followers;
    @SerializedName("following") private String following;
    @SerializedName("created_at") private String created_at;
    @SerializedName("updated_at") private String updated_at;


    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getAvatar_url() {return avatar_url;}
    public void setAvatar_url(String avatar_url) {this.avatar_url = avatar_url;}

    public String getNode_id() {return node_id;}
    public void setNode_id(String node_id) {this.node_id = node_id;}

    public String getGravatar_id() {return gravatar_id;}
    public void setGravatar_id(String gravatar_id) {this.gravatar_id = gravatar_id;}

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    public String getHtml_url() {return html_url;}
    public void setHtml_url(String html_url) {this.html_url = html_url;}
}
